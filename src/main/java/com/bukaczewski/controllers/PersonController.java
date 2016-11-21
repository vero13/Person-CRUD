package com.bukaczewski.controllers;

import com.bukaczewski.model.entity.Person;
import com.bukaczewski.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value =  {"/", "/persons"}, method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("persons", this.personService.listPersons());
        return "persons/list";
    }

    @RequestMapping(value = "/persons/new", method = RequestMethod.GET)
    public String newPerson(){ return "persons/new";  }

    @RequestMapping(value = "/persons/create", method = RequestMethod.POST)
    public String createPerson(@ModelAttribute("person") Person person,
                               final RedirectAttributes redirectAttributes){
        this.personService.createPerson(person);
        redirectAttributes.addFlashAttribute("message", "Person added successfully!");
        return "redirect:/persons";
    }

    @RequestMapping(value = "/persons/delete/{id}", method = RequestMethod.GET)
    public String deletePerson(@PathVariable("id") long id,
                               final RedirectAttributes redirectAttributes){
        this.personService.deletePerson(id);
        redirectAttributes.addFlashAttribute("message", "Person is deleted!");
        return "redirect:/persons";
    }

    @RequestMapping(value = "/persons/edit/{id}", method = RequestMethod.GET)
    public String editPerson(@PathVariable long id, Model model) {
        Person person = personService.getPersonById(id);
        model.addAttribute("personForm", person);
        return "persons/edit";
    }

    @RequestMapping(value = "/persons/update", method = RequestMethod.POST)
    public String updatePerson(@ModelAttribute("person") Person person,
                               final RedirectAttributes redirectAttributes){
        this.personService.updatePerson(person);
        redirectAttributes.addFlashAttribute("message", "Person updated successfully!");
        return "redirect:/persons";
    }
}
