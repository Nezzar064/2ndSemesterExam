package com.alexnmat.exam.controllers;

import com.alexnmat.exam.models.DTO.ProjectDTO;
import com.alexnmat.exam.models.entities.SubProject;
import com.alexnmat.exam.service.ProjectService;
import com.alexnmat.exam.service.StatisticsService;
import com.alexnmat.exam.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard/projects/")
public class StatisticsController {

    private StatisticsService statisticsService;
    private ProjectService projectService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService, ProjectService projectService) {
        this.statisticsService = statisticsService;
        this.projectService = projectService;
    }

    @GetMapping("{projectId}/statistics")
    public String showStatisticsForProject(@PathVariable("projectId") long projectId, Model model) {
        ProjectDTO projectDTO = projectService.findProjectNameAndId(projectId);
        List<SubProject> subProjects = projectService.findByProjectId(projectId).getSubProjects();
        model.addAttribute("statistics", statisticsService.findHoursForProject(projectId));
        model.addAttribute("subProjects", subProjects);
        model.addAttribute("type", 6);
        model.addAttribute("currentProject", projectDTO);
        return "dashboard";
    }
}
