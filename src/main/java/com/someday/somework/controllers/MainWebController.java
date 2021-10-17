package com.someday.somework.controllers;

import com.someday.somework.feign.model.ExcRates;
import com.someday.somework.services.InspectorBobWorker;
import com.someday.somework.utils.SimpleDateForBob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainWebController {

    String APPID = "bb2674ea85bc40bba1caf02e4cc842e0";
    String GIID = "hJxqFUNlVYg1NsNEejeQQMqBrUhnDuY1";

    @Autowired
    private InspectorBobWorker inspectorBobWorker;

    @GetMapping("/")
    public String getCurrentRates(Model model) {

        ExcRates excRates = inspectorBobWorker.getCurrentRates(APPID, SimpleDateForBob.getCurrentDate());
        model.addAttribute("currentRates", excRates);
        return "rates";
    }

}
