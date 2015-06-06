package com.timebox.mvc.web;

import com.timebox.mvc.model.Task;
import com.timebox.mvc.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;
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

        ModelAndView modelAndView = taskController.display();

        assertEquals("tasks", modelAndView.getViewName());
        assertEquals(expectedTaskList, modelAndView.getModelMap().get("taskList"));
    }

    @Test
    public void shouldSubmitTaskForUser() {
        BindingResult bindingResult = mock(BindingResult.class);
        Task task = new Task("", "");

        ModelAndView modelAndView = taskController.add(task, bindingResult);

        assertEquals("tasks", modelAndView.getViewName());
        verify(mockTaskService).submitTask(task);

    }


}