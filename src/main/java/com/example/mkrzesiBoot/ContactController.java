package com.example.mkrzesiBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * In Spring Boot, the controller class is responsible for processing incoming REST API requests,
 * preparing a model, and returning the view to be rendered as a response.
 * The controller classes in Spring are annotated either by the @Controller or the @RestController annotation.
 * @Controller - localhost:8080/ Whitelabel Error Page
 * @RestController - localhost:8080/ returns 'home' ; localhost:8080/home returns Whitelabel Error Page
 */

@RestController
@RequestMapping("/")
public class ContactController {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        List<Contact> contacts = contactRepository.findAll();
        model.put("contacts", contacts);
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact) {
        contactRepository.save(contact);
        return "redirect:/";
    }
}
