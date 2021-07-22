package pl.javatstart.strona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StronaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StronaApplication.class, args);
        EmailService mailService = context.getBean(EmailService.class);
      //  mailService.sendMail("alt.z9-7o4u4kzb@yopmail.com", "Ważna wiadomość!", "To jest <b>treść</b> wiadomości");
    }

}
