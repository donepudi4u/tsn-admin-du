package org.tsn.app.admin.events.programs;

import org.tsn.app.admin.base.BaseEntity;

public class Program extends BaseEntity {

	private Long eventId;
	private String programName;
	private String status;
	private Long programCategoryId;
	private Integer programDurationInMinutes;
	private Boolean isGroupProgram;
	private String groupName;
	private String primaryContactName;
	private String primaryContactNumber;
	private Integer programOrder;

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

	public Integer getProgramDurationInMinutes() {
		return programDurationInMinutes;
	}

	public void setProgramDurationInMinutes(Integer programDurationInMinutes) {
		this.programDurationInMinutes = programDurationInMinutes;
	}

	public Boolean getIsGroupProgram() {
		return isGroupProgram;
	}

	public void setIsGroupProgram(Boolean isGroupProgram) {
		this.isGroupProgram = isGroupProgram;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public Integer getProgramOrder() {
		return programOrder;
	}

	public void setProgramOrder(Integer programOrder) {
		this.programOrder = programOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
