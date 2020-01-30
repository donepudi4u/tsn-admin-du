package org.tsn.app.admin.meetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meetings")
public class MeetingsController {

	@Autowired
	private MeetingService meetingService;
	
	@PostMapping("/schedule-ec-meeting")
	public void scheduleECMeeting(@RequestBody MeetingDTO meetingDTO) {
		meetingService.sendECMeetingEmail(meetingDTO);
	}

}
