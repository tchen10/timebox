package com.timebox.mvc.mappers;

import com.timebox.mvc.model.Task;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TaskMapperTest extends MapperTestBase {

    private TaskMapper taskMapper;
    private Task task;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        taskMapper = getSqlSession().getMapper(TaskMapper.class);
        taskMapper.deleteAll();
        task = new Task("task", "1:00");
    }

    @Test
    public void shouldInsertTask() throws Exception {
        taskMapper.insert(task);
        Long taskID = task.getTaskId();

        ResultSet resultSet = execute("SELECT task_id, description, duration FROM task where task_id = " + taskID + ";");
        resultSet.next();

        assertThat(resultSet.getLong("task_id"), is(taskID));
        assertThat(resultSet.getString("description"), is("task"));
        assertThat(resultSet.getString("duration"), is("1:00"));
    }

    @Test
    public void shouldGetTaskById() {
        taskMapper.insert(task);

        Task result = taskMapper.getById(task.getTaskId());

        assertThat(result.getDuration(), is("1:00"));
        assertThat(result.getDescription(), is("task"));
    }

    @Test
    public void shouldFindAllTasks() throws SQLException {
        taskMapper.insert(task);
        taskMapper.insert(task);

        taskMapper.findAll();

        ResultSet resultSet = execute("SELECT count(*) AS task_count FROM task;");
        resultSet.next();

        assertThat(resultSet.getInt("task_count"), is(2));
    }

    @Test
    public void shouldUpdateTask() {
        taskMapper.insert(task);

        task.setDescription("new task");
        task.setDuration("2:00");

        taskMapper.update(task);

        assertThat(task.getDescription(), is("new task"));
    }

    @Test
    public void shouldDeleteAllTasks() throws SQLException {
        taskMapper.insert(task);

        taskMapper.deleteAll();

        ResultSet resultSet = execute("SELECT count(*) AS task_count FROM task;");
        resultSet.next();

        assertThat(resultSet.getInt("task_count"), is(0));
    }
}