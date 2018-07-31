package tournament.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping(value = {"", "/", "index.html"})
    public String home() {
        return "index";
    }

}
