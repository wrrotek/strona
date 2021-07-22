package pl.javatstart.strona;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
    //
//    Properties emailProperties;
//    Session mailSession;
//    MimeMessage emailMessage;
//
//    String emailHost = "smtp.gmail.com";
//    String emailPort = "587";// gmail's smtp port
//    String fromUser = "gmail email here";// your gmail id
//    String fromUserEmailPassword = "password here";
//    String[] toEmails = { "joe@javapapers.com" };
//
//    public void setMailServerProperties() {
//        emailProperties = System.getProperties();
//        emailProperties.put("mail.smtp.port", emailPort);
//        emailProperties.put("mail.smtp.auth", "true");
//        emailProperties.put("mail.smtp.starttls.enable", "true");
//    }
//
//    public void createEmailMessage(String emailSubject, String emailBody)
//            throws AddressException, MessagingException {
//        mailSession = Session.getDefaultInstance(emailProperties, null);
//        emailMessage = new MimeMessage(mailSession);
//        for (int i = 0; i < toEmails.length; i++) {
//            emailMessage.addRecipient(Message.RecipientType.TO,
//                    new InternetAddress(toEmails[i]));
//        }
//        emailMessage.setSubject(emailSubject);
//        emailMessage.setContent(emailBody, "text/html");// for a html email
//        // emailMessage.setText(emailBody);// for a text email
//
//    }
//
//    public void sendEmail() throws AddressException, MessagingException {
//        Transport transport = mailSession.getTransport("smtp");
//        transport.connect(emailHost, fromUser, fromUserEmailPassword);
//        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
//        transport.close();
//    }
//
    private JavaMailSender javaMailSender;
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public void sendMail(String reciever, String sender, String content) {
        logger.debug("Wysyłam maila do {}", reciever);
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setFrom(sender);
            helper.setTo(reciever);
            helper.setText(content, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.warn("Błąd podczas wysyłania wiadomości", e);
        }

        logger.debug("Mail do {} wysłany poprawnie", reciever);
    }
}
