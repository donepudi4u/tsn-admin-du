package org.tsn.app.admin.service.notification;

import java.util.List;

public class Email {

	private String subject;
	private String body;
	private List<String> toEmailList;
	private List<String> ccEmailList;
	private List<String> bccEmailList;
	private String fromEmail;
	private String replyEmail;
	private String fromName;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<String> getToEmailList() {
		return toEmailList;
	}

	public void setToEmailList(List<String> toEmailList) {
		this.toEmailList = toEmailList;
	}

	public List<String> getCcEmailList() {
		return ccEmailList;
	}

	public void setCcEmailList(List<String> ccEmailList) {
		this.ccEmailList = ccEmailList;
	}

	public List<String> getBccEmailList() {
		return bccEmailList;
	}

	public void setBccEmailList(List<String> bccEmailList) {
		this.bccEmailList = bccEmailList;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getReplyEmail() {
		return replyEmail;
	}

	public void setReplyEmail(String replyEmail) {
		this.replyEmail = replyEmail;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

}
