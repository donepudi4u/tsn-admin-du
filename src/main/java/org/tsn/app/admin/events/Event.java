package org.tsn.app.admin.events;

import java.time.LocalDateTime;
import java.util.Date;

import org.tsn.app.admin.base.BaseEntity;

public class Event extends BaseEntity {

	private String eventName;
	private Date eventDate;
	private LocalDateTime eventStartDateTime;
	private LocalDateTime eventEndDateTime;
	private String LocationAddress;
	private String eventStatus;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public LocalDateTime getEventStartDateTime() {
		return eventStartDateTime;
	}

	public void setEventStartDateTime(LocalDateTime eventStartDateTime) {
		this.eventStartDateTime = eventStartDateTime;
	}

	public LocalDateTime getEventEndDateTime() {
		return eventEndDateTime;
	}

	public void setEventEndDateTime(LocalDateTime eventEndDateTime) {
		this.eventEndDateTime = eventEndDateTime;
	}

	public String getLocationAddress() {
		return LocationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		LocationAddress = locationAddress;
	}

	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
	

}
