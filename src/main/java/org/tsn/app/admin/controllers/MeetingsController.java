package org.tsn.app.admin.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsn.app.admin.dto.MeetingDTO;

@RestController
@RequestMapping("/meetings")
public class MeetingsController {

	@PostMapping("/schedule-ec-meeting")
	public void scheduleECMeeting(@RequestBody MeetingDTO meetingDTO) {
		System.out.println("Request Received.. will be creating meeting soon!!");

	}

}
