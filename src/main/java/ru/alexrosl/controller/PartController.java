package ru.alexrosl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createNewForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.getModelMap().addAttribute("newPart", new Part());
        return modelAndView;
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView createNewAction(@ModelAttribute Part newPart) {
        service.add(newPart);
        return new ModelAndView("redirect:list");
    }

}
