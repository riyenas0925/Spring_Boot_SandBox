package dev.riyenas.sandbox.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/")
    public @ResponseBody String test() {
        return "Hello Riyenas";
    }
}
