package com.alexnmat.exam.models.DTO;

import java.time.LocalDate;

public class SubTaskDTO {

    private long id;
    private String subTaskName;
    private LocalDate utilStartDate;
    private LocalDate utilEndDate;
    private Boolean completed;
    private long allocatedHours;
    private int totalTimeSpent;

    public SubTaskDTO(long id, String subTaskName, LocalDate utilStartDate, LocalDate utilEndDate, Boolean completed) {
        this.id = id;
        this.subTaskName = subTaskName;
        this.utilStartDate = utilStartDate;
        this.utilEndDate = utilEndDate;
        this.completed = completed;
    }

    public SubTaskDTO(long id, long allocatedHours, int totalTimeSpent) {
        this.id = id;
        this.allocatedHours = allocatedHours;
        this.totalTimeSpent = totalTimeSpent;
    }

    public long getAllocatedHours() {
        return allocatedHours;
    }

    public void setAllocatedHours(long allocatedHours) {
        this.allocatedHours = allocatedHours;
    }

    public int getTotalTimeSpent() {
        return totalTimeSpent;
    }

    public void setTotalTimeSpent(int totalTimeSpent) {
        this.totalTimeSpent = totalTimeSpent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubTaskName() {
        return subTaskName;
    }

    public void setSubTaskName(String subTaskName) {
        this.subTaskName = subTaskName;
    }

    public LocalDate getUtilStartDate() {
        return utilStartDate;
    }

    public void setUtilStartDate(LocalDate utilStartDate) {
        this.utilStartDate = utilStartDate;
    }

    public LocalDate getUtilEndDate() {
        return utilEndDate;
    }

    public void setUtilEndDate(LocalDate utilEndDate) {
        this.utilEndDate = utilEndDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
