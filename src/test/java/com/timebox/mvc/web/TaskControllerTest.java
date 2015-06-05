package com.timebox.mvc.web;

import com.timebox.mvc.model.Task;
import com.timebox.mvc.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class TaskControllerTest {

    @Mock
    TaskService mockTaskService;

    TaskController taskController;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        taskController = new TaskController();
        taskController.taskService = mockTaskService;
    }

    @Test
    public void shouldDisplayAllTasks() {
        List<Task> expectedTaskList = new ArrayList<>();
        when(mockTaskService.findAll()).thenReturn(expectedTaskList);

        ModelAndView modelAndView = taskController.displayTasks();

        assertEquals("tasks", modelAndView.getViewName());
        assertEquals(expectedTaskList, modelAndView.getModelMap().get("taskList"));
    }


}