package com.timebox.mvc.web;

import com.timebox.mvc.model.Task;
import com.timebox.mvc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class TaskController {

    TaskService taskService = new TaskService();

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public ModelAndView display() {
        List<Task> taskList = taskService.findAll();
        ModelMap model = new ModelMap();
        model.addAttribute("task", new Task());
        model.put("taskList", taskList);
        return new ModelAndView("tasks", model);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("task") Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("tasks");
        }
        taskService.submitTask(task);
        ModelMap model = new ModelMap();
        List<Task> taskList = taskService.findAll();
        model.put("taskList", taskList);
        return new ModelAndView("tasks", model);
    }

}
