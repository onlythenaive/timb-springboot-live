package ru.tsystems.javaschool.lectures.springboot;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/")
public class IndexViewController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(path = "/index")
    public String show(Model model, @RequestParam(name= "message", defaultValue = "Hello") String message) {
        Collection<Person> persons = personRepository.findAll();
        model.addAttribute("message", message);
        model.addAttribute("persons", persons);
        return "index";
    }
}
