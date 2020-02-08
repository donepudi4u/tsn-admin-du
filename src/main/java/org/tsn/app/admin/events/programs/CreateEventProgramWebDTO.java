package org.tsn.app.admin.events.programs;

import java.util.List;

import org.tsn.app.admin.base.BaseDTO;

public class CreateEventProgramWebDTO extends BaseDTO {

	private Long eventId;
	private String programName;
	private Long programCategoryId;
	private int durationInMinutes;
	private String groupName;
	private Boolean isGroupProgram;
	private List<ParticipantDTO> participants;
	private String primaryContactName;
	private String primaryContactNumber;
	private Integer programOrderInEvent;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public Long getProgramCategoryId() {
		return programCategoryId;
	}

	public void setProgramCategoryId(Long programCategoryId) {
		this.programCategoryId = programCategoryId;
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Boolean getIsGroupProgram() {
		return isGroupProgram;
	}

	public void setIsGroupProgram(Boolean isGroupProgram) {
		this.isGroupProgram = isGroupProgram;
	}

	public List<ParticipantDTO> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ParticipantDTO> participants) {
		this.participants = participants;
	}

	public String getPrimaryContactName() {
		return primaryContactName;
	}

	public void setPrimaryContactName(String primaryContactName) {
		this.primaryContactName = primaryContactName;
	}

	public String getPrimaryContactNumber() {
		return primaryContactNumber;
	}

	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}

	public Integer getProgramOrderInEvent() {
		return programOrderInEvent;
	}

	public void setProgramOrderInEvent(Integer programOrderInEvent) {
		this.programOrderInEvent = programOrderInEvent;
	}

}
