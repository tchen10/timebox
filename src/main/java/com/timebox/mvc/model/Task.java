package com.timebox.mvc.model;


public class Task {
    private Long taskId;
    private String description;
    private String duration;

    public Task() {

    }

    public Task(String description, String duration) {
        this.description = description;
        this.duration = duration;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
