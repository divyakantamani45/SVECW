package com.rest.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement

public class MemberDetails {
	@Id
	@GeneratedValue
	private int memberId;
	private String name;
	private String collegeId;
	private String branch;
	private String phone;
	private String email;
	private String password;
	private String role;
	private String category;
	
	@OneToMany(mappedBy="memberDetails",fetch = FetchType.LAZY)
	private Set<TaskDetails> taskDetails = new HashSet<>();
	
	@ManyToMany(mappedBy="memberDetails",fetch = FetchType.LAZY)
	private Set<EventDetails> eventDetails = new HashSet<>();
	
	public MemberDetails() {
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTaskDetails(Set<TaskDetails> taskDetails) {
		this.taskDetails = taskDetails;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<TaskDetails> getTasksDetails() {
		return taskDetails;
	}
	public Set<TaskDetails> getTaskDetails() {
		return taskDetails;
	}
	public Set<EventDetails> getEventDetails() {
		return eventDetails;
	}
	public void setEventDetails(Set<EventDetails> eventDetails) {
		this.eventDetails = eventDetails;
	}
	@Override
	public String toString() {
		return "MemberDetails [memberId=" + memberId + ", name=" + name + ", collegeId=" + collegeId + ", branch="
				+ branch + ", phone=" + phone + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", category=" + category + ", taskDetails=" + taskDetails + ", eventDetails=" + eventDetails + "]";
	}
		
}
