package net.frank.framework.mail;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

public final class VelocityEmailTemplate {

	protected final transient Logger logger = LoggerFactory.getLogger(getClass());

	private JavaMailSender javaMailSender;
	private VelocityEngine velocityEngine;
	private String encoding;
	private String from;

	public boolean send(String templateLocation,
			Map<String, Object> paramMap, String title,
			String toEmail){
		String [] toEmails = new String[1];
		toEmails[0]=toEmail;
		return send(templateLocation,paramMap,title,toEmails,null,null);
	}

	public synchronized boolean send(String templateLocation,
			Map<String, Object> paramMap, String title,
			String[] toEmails, String toCc, String[] toBcc) {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		try {
			helper.setFrom(from);
			helper.setSubject(title);
			helper.setTo(toEmails);
			if(toCc!=null)
				helper.setCc(toCc);
			if(toBcc!=null)
				helper.setBcc(toBcc);
			helper.setText(getMessage(templateLocation,paramMap));
			javaMailSender.send(msg);
		} catch (MessagingException e) {
			logger.error("Email message error(s).[" + title + "] - "
					+ e.getMessage());
			return false;
		} catch (MailException me) {
			logger.error("Send email failure.[" + title + "] - "
					+ me.getMessage());
			return false;
		}
		return true;
	}

	public String getMessage(String templateLocation,
			Map<String, Object> paramMap) {
		return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
				templateLocation, encoding, paramMap);
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
}
