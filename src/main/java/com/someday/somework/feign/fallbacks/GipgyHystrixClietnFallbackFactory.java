package com.someday.somework.feign.fallbacks;

import com.someday.somework.feign.clients.GyphiClient;
import com.someday.somework.feign.model.GyphiLink;
import com.someday.somework.utils.StatusInspector;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Component
public class GipgyHystrixClietnFallbackFactory extends StatusInspector implements FallbackFactory<GyphiClient> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public GyphiClient create(Throwable cause) {

        Integer httpStatus = cause instanceof FeignException ? ((FeignException) cause).status() : null;

        return new GyphiClient() {

            @Override
            public Optional<GyphiLink> getGiphyLink(String appid, @PathVariable String tag) {
                logger.error(httpStatus.toString());
                logger.error(cause.getMessage());

                return Optional.of(GyphiLink.GyphiLinkBuilder.getGyphiLink(checkStatus(httpStatus), httpStatus.toString()));
            }
        };
    }
}
