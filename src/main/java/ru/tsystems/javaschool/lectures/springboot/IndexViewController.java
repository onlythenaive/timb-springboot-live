package ru.tsystems.javaschool.lectures.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class IndexViewController {

    @RequestMapping(path = "/index")
    public String show() {
        System.out.print("test");
        return "index";
    }
}
