package com.six2d.controller;

import com.six2d.entity.DsSection;
import com.six2d.service.DsSectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SectionPageController {
    Logger logger = LoggerFactory.getLogger(SectionController.class);

    @Autowired
    DsSectionService dsSectionService;

    @GetMapping("/section/edit")
    public String jumpToEdit(@RequestParam("id") Integer id,
                             @RequestParam("name") String name,
                             @RequestParam("pId") Integer pId,
                             Model model) {
        logger.info("编辑部门({})", name);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("pId", pId);
        model.addAttribute("sections", dsSectionService.getDsSection());
        return "section/edit";
    }

    @GetMapping("/section/add")
    public String jumpToAdd() {
        return "section/add";
    }
}
