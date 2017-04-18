package ru.tsystems.javaschool.lectures.springboot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@Lazy(false)
public class PersonBootstrap {

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    public void bootstrap() {
        Person ilia = new Person();
        ilia.setFirstname("Ilia");
        ilia.setLastname("Gubarev");
        Person max = new Person();
        max.setFirstname("Max");
        max.setLastname("Frai");
        personRepository.save(ilia);
        personRepository.save(max);
    }
}
