package com.someday.somework.services;

import com.someday.somework.feign.clients.ExchangeRatesClient;
import com.someday.somework.feign.clients.GyphiClient;
import com.someday.somework.feign.model.ExcRates;
import com.someday.somework.feign.model.GyphiLink;
import com.someday.somework.utils.SimpleDateForBob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class InspectorBobWorker implements InspectorBob {

    @Autowired
    private ExchangeRatesClient excClient;

    @Autowired
    private GyphiClient gyphiClient;

    @Value("${repka.money.forcurrency}")
    private String forСurrency;

    @Override
    public ExcRates getCurrentRates(String api_id, String data) {
        return excClient.getCurrentRates(api_id)
                .orElse(ExcRates.ErrorExcRateBuilder.createExcRates("Could connect to dates, maybe your internet is turned off", "500"));
    }

    @Override
    @Cacheable(value = "yesterdays", unless = "#result.isEmpty()", key = "#data") //
    public ExcRates getYesterdaysRates(String api_id, String data) {
        return excClient.getYesterdaysRates(api_id, data)
                .orElse(ExcRates.ErrorExcRateBuilder.createExcRates("Could connect to dates, maybe your internet is turned off", "500"));
    }

    @Override
    public GyphiLink getGyphi(String giphy_api_id) {
        return gyphiClient.getGiphyLink(giphy_api_id, "are you ready?")
                .orElse(GyphiLink.GyphiLinkBuilder.getGyphiLink("something is wrong with the network", "500"));
    }

    @Override
    public GyphiLink getGyphi(String currency, String giphy_api_id, String rate_api_id) {
        ExcRates currentRates = getCurrentRates(rate_api_id, SimpleDateForBob.getCurrentDate());
        if (currentRates.isEmpty())
            return GyphiLink.GyphiLinkBuilder.getGyphiLink(currentRates.getError(), currentRates.getStatus());
        ExcRates ysterdaysRates = getYesterdaysRates(rate_api_id, SimpleDateForBob.getYsterdayDate());
        if (ysterdaysRates.isEmpty()) {
            return GyphiLink.GyphiLinkBuilder.getGyphiLink(currentRates.getError(), currentRates.getStatus());
        } else if (!ysterdaysRates.getRates().containsKey(currency)) {
            return GyphiLink.GyphiLinkBuilder.getGyphiLink("There is no currency in yesterdays currency list", "404");
        }
        return gyphiClient.getGiphyLink(giphy_api_id, checkRateDif(currency, currentRates, ysterdaysRates))
                .orElse(GyphiLink.GyphiLinkBuilder.getGyphiLink("something is wrong with the network", "500"));
    }

    private String checkRateDif(String currency, ExcRates current, ExcRates yesterday) {
        Double yesterdays_weight = Double.valueOf(yesterday.getRates().get(currency))/Double.valueOf(yesterday.getRates().get(forСurrency));
        Double current_weight = Double.valueOf(current.getRates().get(currency))/Double.valueOf(current.getRates().get(forСurrency));
        if (yesterdays_weight > current_weight) {
            return "broke";
        } else if (yesterdays_weight < current_weight) {
            return "rich";
        } else {
            return "can not be";
        }
    }
}
