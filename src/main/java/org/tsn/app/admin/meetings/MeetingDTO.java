package org.tsn.app.admin.meetings;

import java.util.Date;

public class MeetingDTO {

	private Date meetingStartDateTime;
	private Date meetingEndDateTime;
	private String subject;
	private String meetingAgenda;

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

}
