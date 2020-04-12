package es.diegofpb.lametric.emtmad.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web")
@Slf4j
public class WebController {

    @GetMapping
    public ModelAndView getPrivacyPolicy(){
        return new ModelAndView("policy.html");
    }

}
