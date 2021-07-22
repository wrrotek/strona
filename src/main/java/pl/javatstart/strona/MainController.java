package pl.javatstart.strona;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/oNas")
    public String aboutUs() {
        return "oNas";
    }

    @GetMapping("/kontakt")
    public String contact() {
        return "kontakt";
    }

    @PostMapping("/wyslij")
    public String sendMail(@RequestParam String reciever, @RequestParam String sender, @RequestParam String content) {
        return "redirect:/";
    }
}
