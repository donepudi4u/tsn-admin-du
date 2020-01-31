package org.tsn.app.admin.meetings;

import org.springframework.stereotype.Component;

@Component
public class MeetingMapper {

	public Meeting map(CreateMeetingWebDTO createMeetingWebDTO) {
		
		Meeting meeting = new Meeting();
		meeting.setSubject(createMeetingWebDTO.getMeetingSubject());
		meeting.setMeetingAgenda(createMeetingWebDTO.getMeetingAgenda());
		meeting.setMeetingStartDateTime(createMeetingWebDTO.getMeetingStartTime());
		meeting.setMeetingEndDateTime(createMeetingWebDTO.getMeetingEndTime());
	

		return meeting;
	}

}
