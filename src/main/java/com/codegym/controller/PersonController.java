package com.codegym.controller;

import com.codegym.moduls.Person;
import com.codegym.moduls.Role;
import com.codegym.service.IPersonService;
import com.codegym.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/blogMusic/")
public class PersonController {


    @Autowired
    IPersonService iPersonService;
    @Autowired
    IRoleService iRoleService;

    @ModelAttribute
    public ArrayList<Role> listRole() {
        return (ArrayList<Role>) iRoleService.findAll();
    }

    @GetMapping("/createPerson")
    public ModelAndView showCreatePerson() {
        ModelAndView modelAndView = new ModelAndView("/createPerson");
        modelAndView.addObject("person", new Person());
        return modelAndView;
    }

    @PostMapping("/createPerson")
    public ModelAndView createPerson(@RequestParam MultipartFile uppAvatar, @ModelAttribute Person person) {
        String nameImg = uppAvatar.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppAvatar.getBytes(),
                    new File("C:\\CodeGym\\Module4\\CaseStudyMussic\\casestudy4-mxhmusic\\src\\main\\webapp\\avatar/" + nameImg));
            String urlImg = "/avatar/" + nameImg;
            person.setAvatar(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iPersonService.savePerson(person);
        return new ModelAndView("redirect:/blogMusic/showAdmin");
    }

    @GetMapping("/editPerson/{id}")
    public ModelAndView showEditPerson(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/editPerson", "listRole", iRoleService.findAll());
        modelAndView.addObject("listPerson", iPersonService.findByIdPerson(id));
        return modelAndView;
    }

    @PostMapping("/editPerson/{id}")
    public ModelAndView editPerson(@RequestParam MultipartFile uppAvatar, @ModelAttribute Person person) {
        String nameImg = uppAvatar.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppAvatar.getBytes(), new File("C:\\CodeGym\\Module4\\CaseStudy\\BlogMusic2\\src\\main\\webapp\\avatar/" + nameImg));
            String urlImg = "/avatar/" + nameImg;
            person.setAvatar(urlImg);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iPersonService.savePerson(person);
        return new ModelAndView("redirect:/blogMusic/showAdmin");

    }

    @GetMapping("/deletePerson/{id}")
    public ModelAndView deletePerson(@PathVariable int id) {
        iPersonService.removePerson(id);
        return new ModelAndView("redirect:/blogMusic/showAdmin");
    }


}
