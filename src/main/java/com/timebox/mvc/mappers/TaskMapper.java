package com.timebox.mvc.mappers;

import com.timebox.mvc.model.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TaskMapper {

    @Insert(
            "INSERT INTO task (description, duration) " +
                    "VALUES (#{task.description}, #{task.duration})"
    )
    @Options(keyProperty = "task.taskId", keyColumn = "task_id", useGeneratedKeys = true)
    Integer insert(@Param(value = "task")Task task);

    @Select(
            "SELECT task_id, description, duration " +
                    "FROM task " +
                    "WHERE task_id = #{taskId}"
    )
    Task getById(Long taskId);

    @Select(
            "SELECT task_id, description, duration FROM task"
    )
    @Results(value = {
            @Result(property="taskId", column="task_id"),
            @Result(property="description"),
            @Result(property="duration"),
    })
    public List<Task> findAll();

    @Update(
            "UPDATE task " +
                    "SET description=#{task.description}, duration=#{task.duration}" +
                    "WHERE task_id=#{task.taskId}"
    )
    public void update(@Param(value = "task") Task task);

    @Delete(
            "DELETE FROM task"
    )
    @Options(flushCache = true)
    public void deleteAll();

}
