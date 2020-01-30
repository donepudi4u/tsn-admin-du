package org.tsn.app.admin.service.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class EmailHelper  {

	@Autowired
	private JavaMailSender javaMailSender;

	public Boolean sendEmail(Email email) {

		if (email == null || email.getToEmailList().isEmpty()) {
			return Boolean.FALSE;
		}

		SimpleMailMessage msg = new SimpleMailMessage();

		msg.setSubject(email.getSubject());
		msg.setText(email.getBody());

		msg.setTo(StringUtils.split(String.join(",", email.getToEmailList()),","));

		if (email.getCcEmailList() != null && !email.getCcEmailList().isEmpty()) {
			msg.setCc(new String[] { String.join(",", email.getCcEmailList()) });
		}
		if (email.getBccEmailList() != null && !email.getBccEmailList().isEmpty()) {
			msg.setBcc(new String[] { String.join(",", email.getBccEmailList()) });
		}

		javaMailSender.send(msg);

		return Boolean.TRUE;
	}

}
