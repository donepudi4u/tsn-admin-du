package org.tsn.app.admin.meetings;

import java.util.Date;

import org.tsn.app.admin.base.BaseEntity;

public class Meeting extends BaseEntity {

	private Date meetingStartDateTime;
	private Date meetingEndDateTime;
	private String subject;
	private String meetingAgenda;
	private String status;

	public Date getMeetingStartDateTime() {
		return meetingStartDateTime;
	}

	public void setMeetingStartDateTime(Date meetingStartDateTime) {
		this.meetingStartDateTime = meetingStartDateTime;
	}

	public Date getMeetingEndDateTime() {
		return meetingEndDateTime;
	}

	public void setMeetingEndDateTime(Date meetingEndDateTime) {
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
