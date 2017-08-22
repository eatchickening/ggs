
package io.checken.ggs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wung 2017/8/22.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        return "index";
    }
}
