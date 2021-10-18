package com.someday.somework.controllers;

import com.someday.somework.feign.model.ExcRates;
import com.someday.somework.services.InspectorBobWorker;
import com.someday.somework.utils.SimpleDateForBob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainWebController {

    @Autowired
    private Environment env;

    @Autowired
    private InspectorBobWorker inspectorBobWorker;

    @GetMapping("/")
    public String getCurrentRates(Model model) {

        ExcRates excRates = inspectorBobWorker.getCurrentRates(env.getProperty("RATE_API_KEY"), SimpleDateForBob.getCurrentDate());
        model.addAttribute("currentRates", excRates);
        return "rates";
    }

}
