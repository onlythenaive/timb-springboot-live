package ru.tsystems.javaschool.lectures.springboot;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data/samples")
public class SampleController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Person> getPerson() {
        return personRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person create(@RequestBody Person person) {
        personRepository.save(person);
        return person;
    }
}
