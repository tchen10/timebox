package com.timebox.mvc.service;

import com.timebox.mvc.mappers.TaskMapper;
import com.timebox.mvc.model.Task;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class TaskServiceTest {

    private TaskService taskService;

    @Mock
    private SqlSession sqlSession;
    @Mock
    private TaskMapper taskMapper;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        when(sqlSession.getMapper(TaskMapper.class)).thenReturn(taskMapper);
        taskService = new TaskService(sqlSession);
    }

    @Test
    public void shouldSaveTask() {
        final Task task = new Task("first task", "1:00");

        taskService.submitTask(new Task("first task", "1:00"));

        verify(taskMapper).insert(argThat(new TaskMatcher(task)));
        verify(sqlSession).commit();

    }

    private class TaskMatcher extends ArgumentMatcher<Task> {
        private Task task;

        public TaskMatcher(Task task) {
            this.task = task;
        }

        @Override
        public boolean matches(Object o) {
            Task entry = (Task) o;
            return task.getDescription().equals(entry.getDescription()) &&
                    task.getDuration() == entry.getDuration();
        }
    }
}