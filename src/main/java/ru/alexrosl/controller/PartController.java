package ru.alexrosl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.alexrosl.SimpleDBAccess;

@Controller
public class PartController {

    SimpleDBAccess access;

    @Autowired
    public PartController(SimpleDBAccess access) {
        this.access = access;
    }

    @RequestMapping("/list")
    public String greeting(ModelMap map) {
        map.addAttribute("name", access.getVersion());
        return "list";
    }

}
