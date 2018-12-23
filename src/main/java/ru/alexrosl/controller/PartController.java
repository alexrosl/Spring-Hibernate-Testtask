package ru.alexrosl.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

        Integer total = list.stream().
                filter(Part::getRequired).
                map(Part::getQuantity).
                min(Integer::compare).get();

        map.addAttribute("list", list);
        map.addAttribute("total", total);
        return "list";
    }

    @RequestMapping(value="/search")
    public ModelAndView searchPart(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView();
        Part part = service.get(name);
        String result;
        if (part == null) {
            result = "notfound";

        } else {
            result = "update";
            modelAndView.getModelMap().addAttribute("part", part);
        }
        modelAndView.setViewName(result);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createNewForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.getModelMap().addAttribute("newPart", new Part());
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.getModelMap().addAttribute("part", service.get(id));
        return modelAndView;
    }

    @RequestMapping(value = "/submitNew", method = RequestMethod.POST)
    public ModelAndView createNewAction(@ModelAttribute Part newPart) {
        service.add(newPart);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "/submitUpdate", method = RequestMethod.POST)
    public ModelAndView updateAction(@ModelAttribute Part newPart) {
        service.update(newPart);
        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "/delete")
    public ModelAndView delete(@RequestParam int id) {
        service.delete(id);
        return new ModelAndView("redirect:list");
    }

}
