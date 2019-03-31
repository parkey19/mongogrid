package io.parkey19.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by parkey19 on 2018. 11. 19..
 */
@Controller
public class RootController implements ErrorController {

    @GetMapping({"/", "/error"})
    public String getUsers() {
        return "/index.html";
    }

    @GetMapping({"/vi"})
    public String getVideo() {
        return "video.html";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
