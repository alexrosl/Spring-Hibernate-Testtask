package ru.alexrosl.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import ru.alexrosl.ResourceNotFoundException;
import ru.alexrosl.model.Part;
import ru.alexrosl.service.PartService;

import java.util.List;

@Controller
public class PartController {
    private int pageSize = 10;

    @Autowired
    PartService service;

    @RequestMapping("/list")
    public ModelAndView partList(@RequestParam(required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Part> list = service.list();

        Integer total = 0;
        if (list.size() > 0) {
            total = list.stream().
                    filter(Part::getRequired).
                    map(Part::getQuantity).
                    min(Integer::compare).get();
        }
        PagedListHolder<Part> pagedListHolder = new PagedListHolder<Part>(list);
        pagedListHolder.setPageSize(pageSize);
        int pageCount = pagedListHolder.getPageCount();

        if(page==null || page < 1) {
            page = 1;
        }

        if(page>pageCount){
            pagedListHolder.setPage(pageCount - 1);
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
        }

        modelAndView.getModelMap().addAttribute("list", pagedListHolder.getPageList());
        modelAndView.getModelMap().addAttribute("total", total);
        modelAndView.getModelMap().addAttribute("page", page);
        modelAndView.getModelMap().addAttribute("maxPages", pageCount);

        return modelAndView;
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
