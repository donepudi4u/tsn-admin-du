package org.tsn.app.admin.meetings;

import java.time.LocalDateTime;
import java.util.List;

public class CreateMeetingWebDTO {

	private String meetingSubject;
	private LocalDateTime meetingStartTime;
	private LocalDateTime meetingEndTime;
	private String meetingLocation;
	private String meetingType;
	private List<Long> invitees;
	private String meetingAgenda;

	public String getMeetingSubject() {
		return meetingSubject;
	}

	public void setMeetingSubject(String meetingSubject) {
		this.meetingSubject = meetingSubject;
	}

	public LocalDateTime getMeetingStartTime() {
		return meetingStartTime;
	}

	public void setMeetingStartTime(LocalDateTime meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}

	public LocalDateTime getMeetingEndTime() {
		return meetingEndTime;
	}

	public void setMeetingEndTime(LocalDateTime meetingEndTime) {
		this.meetingEndTime = meetingEndTime;
	}

	public String getMeetingLocation() {
		return meetingLocation;
	}

	public void setMeetingLocation(String meetingLocation) {
		this.meetingLocation = meetingLocation;
	}

	public String getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	public List<Long> getInvitees() {
		return invitees;
	}

	public void setInvitees(List<Long> invitees) {
		this.invitees = invitees;
	}

	public String getMeetingAgenda() {
		return meetingAgenda;
	}

	public void setMeetingAgenda(String meetingAgenda) {
		this.meetingAgenda = meetingAgenda;
	}

}
