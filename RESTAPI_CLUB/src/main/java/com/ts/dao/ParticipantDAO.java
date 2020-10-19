package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.dto.Participants;
import com.ts.db.HibernateTemplate;

public class ParticipantDAO {
	
	private SessionFactory factory = null;
	
	public int register(Participants participant) {
		System.out.println(participant); 
		return HibernateTemplate.addObject(participant);
	}
	
	public static List<Participants> getAllParticipants() {
		List<Participants> participants=(List)HibernateTemplate.getObjectListByQuery("From Participants");
		System.out.println("Inside All participants ..."+participants);
		return participants;
	}

	public Participants getPatByUserPass(String email, String password) {
		
		Participants participant = (Participants)HibernateTemplate.getObjectByUserPass(email,password);
		System.out.println("In DAO"+participant);
		return participant;
	}
	
	
}
