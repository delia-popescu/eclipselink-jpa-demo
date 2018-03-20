package com.db.jpaDemo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.db.jpaDemo.util.Status;

@Entity
@NamedQuery(name="findTasksByStatus", query="select t from Task t where t.status = :status")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "globalSequence")
	private Long id;

	private String taskDescription;

	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID", nullable=false, updatable=false)
	private Project project;
	
	@OneToOne
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
	private Employee employee;
	
	private Status status;

	public Long getId() {
		return id;
	}

	public Task setId(Long id) {
		this.id = id;
		return this;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public Task setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
		return this;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Task setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Task setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public Task setEmployee(Employee employee) {
		this.employee = employee;
		return this;
	}

	public Project getProject() {
		return project;
	}

	public Task setProject(Project project) {
		this.project = project;
		return this;
	}

	public Status getStatus() {
		return status;
	}

	public Task setStatus(Status status) {
		this.status = status;
		return this;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskDescription=" + taskDescription + ", startDate=" + startDate + ", endDate="
				+ endDate + ", project id=" + project.getId() + ", employee=" + employee + ", status=" + status + "]";
	}

}
