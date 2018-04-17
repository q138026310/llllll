package com.dlts.hrms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/html")
public class HtmlAction {

    @RequestMapping("/{module}/{fn}")
    ModelAndView home2(@PathVariable String module, @PathVariable String fn) {
        ModelAndView result = new ModelAndView(module + "/" + fn);
        return result;
    }

}
