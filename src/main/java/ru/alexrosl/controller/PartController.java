package ru.alexrosl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexrosl.model.Part;
import ru.alexrosl.service.PartService;

import java.util.List;

@Controller
public class PartController {

    @Autowired
    PartService service;

    @RequestMapping("/list")
    public String greeting(ModelMap map) {
        List<Part> list = service.list();

        map.addAttribute("list", list);
        return "list";
    }

}
