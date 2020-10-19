package com.rest.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.rest.dto.MemberDetails;;

@Entity
@XmlRootElement

public class TaskDetails {
	@Id
	@GeneratedValue
	private int taskId;
	private String taskName;
	private Date givenDate;
	private Date endDate;
	private String verdict;
	
	@ManyToOne
	@JoinColumn(name="memberId")
	private MemberDetails memberDetails;
	
	public TaskDetails() {
		
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public MemberDetails getMemberDetails() {
		return memberDetails;
	}
	public void setMemberDetails(MemberDetails memberDetails) {
		this.memberDetails = memberDetails;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Date getGivenDate() {
		return givenDate;
	}
	public void setGivenDate(Date givenDate) {
		this.givenDate = givenDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getVerdict() {
		return verdict;
	}
	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}
	@Override
	public String toString() {
		return "TaskDetails [taskId=" + taskId + ", taskName=" + taskName + ", givenDate=" + givenDate + ", endDate="
				+ endDate + ", verdict=" + verdict + ", memberDetails=" + memberDetails + "]";
	}
	
	
	
}
