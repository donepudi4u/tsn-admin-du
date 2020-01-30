package org.tsn.app.admin.meetings;

import java.time.LocalDate;
import java.util.List;

public class CreateMeetingWebDTO {

	private String meetingSubject;
	private LocalDate meetingStartTime;
	private LocalDate meetingEndTime;
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

	public LocalDate getMeetingStartTime() {
		return meetingStartTime;
	}

	public void setMeetingStartTime(LocalDate meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}

	public LocalDate getMeetingEndTime() {
		return meetingEndTime;
	}

	public void setMeetingEndTime(LocalDate meetingEndTime) {
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
