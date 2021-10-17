package com.someday.somework.services;

import com.someday.somework.feign.model.ExcRates;
import com.someday.somework.feign.model.GyphiLink;

public interface InspectorBob {

    ExcRates getCurrentRates(String api_id, String data);

    ExcRates getYesterdaysRates(String api_id, String data);

    GyphiLink getGyphi(String giphy_api_id);

    GyphiLink getGyphi(String currency, String giphy_api_id, String rate_api_id);


}
