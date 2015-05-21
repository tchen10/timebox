package com.timebox.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/task")
public class TaskController {

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String getTasksPage() {
        return "tasksPage";
    }
}
