package org.tsn.app.admin.meetings;

public interface MeetingService {

	Boolean sendECMeetingEmail(MeetingDTO meetingDTO);
	
	void createMeeting(CreateMeetingWebDTO createMeetingWebDTO);

}
