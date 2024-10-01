package org.example.entity;


import java.util.Objects;

public class Task extends TaskData
{

    private String project;
    private String description;
    private Priority priority;
    private String assignee;

    private Status status;


    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public Task(String project, String description, String assignee , Status status , Priority priority) {
        super();
        this.project = project;
        this.description = description;
        this.priority = priority;
        this.assignee = assignee;
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignee() {
        return assignee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(project, task.project) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, description);
    }








}

