/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package develop;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import rcommon.email.R_EmailSetting;

/**
 *
 * @author renhongxiang
 */
public class EmailTest {
    public boolean doEmailTest(){
        R_EmailSetting setting = R_EmailSetting.getInstance();
        if(setting != null){
            try {
		Properties props = new Properties();
  		props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.socketFactory.port", "465");
//		props.put("mail.smtp.socketFactory.class",
//				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("ereadinglog@gmail.com","Rhxzlq01");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ereadinglog@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("ereadinglog@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
            }catch(Exception q){
                int err = 0;
            }
        }
        return false;
    }
}
