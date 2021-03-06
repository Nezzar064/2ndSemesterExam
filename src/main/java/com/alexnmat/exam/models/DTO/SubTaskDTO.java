package com.alexnmat.exam.models.DTO;

import java.time.LocalDate;

/*
@Author: MSN
 */

public class SubTaskDTO {

    //DTO's used for DTO Projection by JPA

    private long id;
    private String subTaskName;
    private LocalDate utilStartDate;
    private LocalDate utilEndDate;
    private Boolean completed;
    private double allocatedHours;
    private double totalTimeSpent;

    public SubTaskDTO(long id, String subTaskName, LocalDate utilStartDate, LocalDate utilEndDate, Boolean completed) {
        this.id = id;
        this.subTaskName = subTaskName;
        this.utilStartDate = utilStartDate;
        this.utilEndDate = utilEndDate;
        this.completed = completed;
    }

    public SubTaskDTO(long id, double allocatedHours, double totalTimeSpent) {
        this.id = id;
        this.allocatedHours = allocatedHours;
        this.totalTimeSpent = totalTimeSpent;
    }

    public double getAllocatedHours() {
        return allocatedHours;
    }

    public void setAllocatedHours(double allocatedHours) {
        this.allocatedHours = allocatedHours;
    }

    public double getTotalTimeSpent() {
        return totalTimeSpent;
    }

    public void setTotalTimeSpent(double totalTimeSpent) {
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
