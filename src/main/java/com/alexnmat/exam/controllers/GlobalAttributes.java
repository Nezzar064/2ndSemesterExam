package com.alexnmat.exam.controllers;

import com.alexnmat.exam.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/*
@Author: MSN
 */

@ControllerAdvice
public class GlobalAttributes {

    private ProjectService projectService;

    @Autowired
    public GlobalAttributes(ProjectService projectService) {
        this.projectService = projectService;
    }

    //Used multiple places, so added as a global model attribute instead of injecting projectService in everything.
    @ModelAttribute()
    public void addGlobalAttributes(Model model) {
        model.addAttribute("projects", projectService.findProjectNamesAndIds());
    }
}