package ru.alexrosl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PartController {

    @RequestMapping("/list")
    public String greeting(Model model) {
        model.addAttribute("name", "alex");
        return "list";
    }

}
