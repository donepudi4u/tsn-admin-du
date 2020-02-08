package org.tsn.app.admin.events;

import java.time.LocalDateTime;
import java.util.Date;

import org.tsn.app.admin.base.BaseDTO;

public class EventDTO extends BaseDTO {
	
	private String eventName;
	private Date eventDate;
	private LocalDateTime eventStartDateTime;
	private LocalDateTime eventEndDateTime;
	private String LocationAddress;
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
