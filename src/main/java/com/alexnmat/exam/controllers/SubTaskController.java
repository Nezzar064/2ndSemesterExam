package com.alexnmat.exam.controllers;

import com.alexnmat.exam.models.DTO.HoursHelper;
import com.alexnmat.exam.models.DTO.ProjectDTO;
import com.alexnmat.exam.models.entities.SubTask;
import com.alexnmat.exam.models.entities.Task;
import com.alexnmat.exam.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/*
@Author: MSN & AFC
 */

@Controller
@RequestMapping("/dashboard/tasks/")
public class SubTaskController {

    private TaskService taskService;

    @Autowired
    public SubTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "{taskId}/subTasks/{subTaskId}")
    public String currentSubTask(@PathVariable("taskId") long taskId, @PathVariable("subTaskId") long subTaskId, Model model) {
        Task task = taskService.findTaskById(taskId);
        ProjectDTO projectDTO = new ProjectDTO(task.getSubProject().getProject().getId());
        model.getAttribute("projects");
        model.addAttribute("currentProject", projectDTO);
        model.addAttribute("currentTask", taskService.findTaskIdAndNameById(taskId));
        model.addAttribute("currentSubTask", taskService.findSubTaskById(subTaskId));
        model.addAttribute("type", 5);
        model.addAttribute("hoursHelper", new HoursHelper());
        return "dashboard";
    }

    @GetMapping(value = "{taskId}/subTasks/createSubTask")
    public String showCreateSubTaskForm(@PathVariable("taskId") long taskId, Model model) {
        model.addAttribute("currentTask", taskService.findTaskIdAndNameById(taskId));
        model.addAttribute("subTask", new SubTask());
        model.addAttribute("type", 11);
        return "dashboard";
    }

    //Model attributes added to bindingResult as well, since we use fragments for these as well.
    @PostMapping(value = "{taskId}/subTasks/addSubTask")
    public String createNewSubTask(@PathVariable("taskId") long taskId, @Valid SubTask subTask, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("currentTask", taskService.findTaskIdAndNameById(taskId));
            model.addAttribute("subTask", subTask);
            model.addAttribute("type", 11);
            return "dashboard";
        }
        model.addAttribute("currentTask", taskService.findTaskIdAndNameById(taskId));
        model.addAttribute("successMessage", "Sub Task successfully created!");
        model.addAttribute("subTask", subTask);
        model.addAttribute("type", 11);
        taskService.saveSubTask(subTask, taskId);
        return "redirect:/dashboard/tasks/" + taskId + "/subTasks/" + subTask.getId();
    }

    @GetMapping(value = "{taskId}/subTasks/{subTaskId}/complete")
    public String completeSubTask(@PathVariable("taskId") long taskId, @PathVariable("subTaskId") long subTaskId, Model model) {
        taskService.completeSubTask(subTaskId);
        return "redirect:/dashboard/tasks/" + taskId;
    }

    @GetMapping(value = "{taskId}/subTasks/{subTaskId}/delete")
    public String deleteSubTask(@PathVariable("taskId") long taskId, @PathVariable("subTaskId") long subTaskId, Model model) {
        taskService.deleteSubTask(taskId);
        return "redirect:/dashboard/tasks/" + taskId;

    }

    @PostMapping(value = "{taskId}/subTasks/{subTaskId}/addHours")
    public String addTotalTimeSpentToSubTask(@PathVariable("taskId") long taskId, @PathVariable("subTaskId") long subTaskId, @Valid HoursHelper hoursHelper, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/dashboard/tasks/" + taskId + "/subTasks/" + subTaskId;
        }
        model.addAttribute("hoursHelper", hoursHelper);
        taskService.updateTotalTimeSpentForSubTask(subTaskId, hoursHelper.getHours());
        taskService.updateTotalTimeSpentForTask(taskId);
        return "redirect:/dashboard/tasks/" + taskId + "/subTasks/" + subTaskId;
    }

}

