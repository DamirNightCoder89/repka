package com.someday.somework.controllers;

import com.someday.somework.feign.model.GyphiLink;
import com.someday.somework.services.InspectorBobWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest")
public class MainRestController {

    @Autowired
    private Environment env;

    @Autowired
    private InspectorBobWorker inspectorBobWorker;

    @GetMapping("/ready")
    GyphiLink getGyphiLinkReady() {
        return inspectorBobWorker.getGyphi(env.getProperty("PYGI_API_KEY"));
    }

    @GetMapping("/ready/{currency}")
    GyphiLink getGyphiLinkReady(@PathVariable String currency) {
        return inspectorBobWorker.getGyphi(currency, env.getProperty("PYGI_API_KEY"), env.getProperty("RATE_API_KEY"));
    }

}
