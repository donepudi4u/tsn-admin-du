package org.tsn.app.admin.meetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meetings")
public class MeetingsController {

	private static final String SEND_MEETING_INVITE = "/send-meeting-invite";
	private static final String CREATE_MEETING 		= "/create-meeting";
	
	@Autowired
	private MeetingService meetingService;
	
	@PostMapping(SEND_MEETING_INVITE)
	public void scheduleECMeeting(@RequestBody MeetingDTO meetingDTO) {
		meetingService.sendECMeetingEmail(meetingDTO);
	}
	
	@PostMapping(CREATE_MEETING)
	public void createMeeting(@RequestBody CreateMeetingWebDTO meetingWebDTO){
		meetingService.createMeeting(meetingWebDTO);
		
	}

}
