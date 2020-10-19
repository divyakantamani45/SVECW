package com.rest.dto;

import com.rest.dto.MemberDetails;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement

public class EventDetails {
	@Id
	@GeneratedValue
	private int eventId;
	private String eventName;
	private Date startDate;
	private Date endDate;
	
	@ManyToMany(mappedBy="eventDetails",fetch = FetchType.LAZY)
	private Set<Participants> participants = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "MemberEvents",
            joinColumns = {@JoinColumn(name = "eventId")},
            inverseJoinColumns = {@JoinColumn(name = "memberId")}
    )
    private Set<MemberDetails> memberDetails = new HashSet<>();
	
	public EventDetails() {
		
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Set<MemberDetails> getMemberDetails() {
		return memberDetails;
	}
	public void setMemberDetails(Set<MemberDetails> memberDetails) {
		this.memberDetails = memberDetails;
	}
	
	public Set<Participants> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<Participants> participants) {
		this.participants = participants;
	}
	@Override
	public String toString() {
		return "EventDetails [eventId=" + eventId + ", eventName=" + eventName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", participants=" + participants + ", memberDetails=" + memberDetails + "]";
	}
	
}
