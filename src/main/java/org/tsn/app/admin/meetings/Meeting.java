package org.tsn.app.admin.meetings;

import java.time.LocalDateTime;

import org.tsn.app.admin.base.BaseEntity;

public class Meeting extends BaseEntity {

	private LocalDateTime meetingStartDateTime;
	private LocalDateTime meetingEndDateTime;
	private String subject;
	private String meetingAgenda;
	private String status;

	public LocalDateTime getMeetingStartDateTime() {
		return meetingStartDateTime;
	}

	public void setMeetingStartDateTime(LocalDateTime meetingStartDateTime) {
		this.meetingStartDateTime = meetingStartDateTime;
	}

	public LocalDateTime getMeetingEndDateTime() {
		return meetingEndDateTime;
	}

	public void setMeetingEndDateTime(LocalDateTime meetingEndDateTime) {
		this.meetingEndDateTime = meetingEndDateTime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMeetingAgenda() {
		return meetingAgenda;
	}

	public void setMeetingAgenda(String meetingAgenda) {
		this.meetingAgenda = meetingAgenda;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
