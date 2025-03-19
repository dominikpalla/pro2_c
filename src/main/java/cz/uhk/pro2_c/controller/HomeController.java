package cz.uhk.pro2_c.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "<h1>test</h1>";
    }

}
