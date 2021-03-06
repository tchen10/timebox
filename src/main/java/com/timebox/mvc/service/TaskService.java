package com.timebox.mvc.service;

import com.timebox.mvc.mappers.MyBatisUtil;
import com.timebox.mvc.mappers.TaskMapper;
import com.timebox.mvc.model.Task;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TaskService {

    private SqlSession sqlSession;
    private TaskMapper taskMapper;

    public TaskService() {
        this(MyBatisUtil.getSqlSessionFactory().openSession());
    }

    public TaskService(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
        this.taskMapper = sqlSession.getMapper(TaskMapper.class);
    }

    public void submitTask(Task task) {
        taskMapper.insert(task);
        sqlSession.commit();
    }

    public Task getTaskById(long id) {
        return taskMapper.getById(id);
    }

    public List<Task> findAll() {
        return taskMapper.findAll();
    }

    public void deleteAll() {
        taskMapper.deleteAll();
        sqlSession.commit();
    }


}
