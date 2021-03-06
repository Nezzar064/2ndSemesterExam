package com.alexnmat.exam.models.entities;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/*
@Author: MSN & AFC
 */

@Entity
@Table(name = "sub_task")
public class SubTask implements Serializable {

    private static final long serialVersionUID = 1L;

    //NotNull, NotEmpty etc. used for validiation

    //Sequence Generator. Enables us to start every entity with id 1.

    @Id
    @SequenceGenerator(name = "sub_task_id_seq", sequenceName = "sub_task_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_task_id_seq")
    @Column(name = "sub_task_id")
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    private Task task;

    @Column(name = "sub_task_name")
    @NotEmpty(message = "Please provide a name!")
    private String subTaskName;

    //DateTimeFormat used for JPA to specify date format, since we are using LocalDate
    @Column(name = "start_date")
    @NotNull(message = "Please provide a date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate utilStartDate;

    @Column(name = "end_date")
    @NotNull(message = "Please provide a date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate utilEndDate;

    @Column(name = "completed")
    private Boolean completed;

    @NotEmpty(message = "Please provide a description!")
    @Length(max = 250, message = "Description cannot be longer than 250 characters!")
    @Column(name = "description")
    private String description;

    @Column(name = "allocated_hours")
    private double allocatedHours;

    @Column(name = "total_time_spent")
    private double totalTimeSpent;

    public SubTask() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalTimeSpent() {
        return totalTimeSpent;
    }

    public void setTotalTimeSpent(double totalTimeSpent) {
        this.totalTimeSpent = totalTimeSpent;
    }

    public double getAllocatedHours() {
        return allocatedHours;
    }

    public void setAllocatedHours(double allocatedHours) {
        this.allocatedHours = allocatedHours;
    }
}
