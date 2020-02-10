package org.tsn.app.admin.events.programs.nominations;

import java.util.List;

import org.tsn.app.admin.base.BaseDTO;
import org.tsn.app.admin.events.programs.participants.ParticipantDTO;

public class CreateProgramNominationWebDTO extends BaseDTO {

	private String programCategory;
	private Boolean singleContestent;
	private List<ParticipantDTO> participants;
	private Integer programDuration;
	private String groupName;
	private String primaryContactName;
	private String primaryContactNumber;
	private String programTitle;
	private String comments;
	private String status;

	public String getProgramCategory() {
		return programCategory;
	}

	public void setProgramCategory(String programCategory) {
		this.programCategory = programCategory;
	}

	public Boolean getSingleContestent() {
		return singleContestent;
	}

	public void setSingleContestent(Boolean singleContestent) {
		this.singleContestent = singleContestent;
	}

	public List<ParticipantDTO> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ParticipantDTO> participants) {
		this.participants = participants;
	}

	public Integer getProgramDuration() {
		return programDuration;
	}

	public void setProgramDuration(Integer programDuration) {
		this.programDuration = programDuration;
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

	public String getProgramTitle() {
		return programTitle;
	}

	public void setProgramTitle(String programTitle) {
		this.programTitle = programTitle;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
