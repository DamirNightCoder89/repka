package com.someday.somework.feign.clients;

import com.someday.somework.feign.fallbacks.GipgyHystrixClietnFallbackFactory;
import com.someday.somework.feign.model.GyphiLink;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name="gyphi-client", url = "${repka.giphy.url}", fallbackFactory = GipgyHystrixClietnFallbackFactory.class)
public interface GyphiClient {

    @GetMapping("/random")
    Optional<GyphiLink> getGiphyLink(@RequestParam("api_key") String api_key, @RequestParam("tag") String tag);
}
