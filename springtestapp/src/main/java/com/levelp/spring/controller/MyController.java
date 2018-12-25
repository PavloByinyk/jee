package com.levelp.spring.controller;

import com.levelp.spring.model.Idea;
import com.levelp.spring.service.IdeasService;
import com.levelp.spring.service.IdeasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;

@Controller
public class MyController {

    @Autowired
    IdeasService service;

    @RequestMapping(value = {"/hello", "/"}, method = RequestMethod.GET)
    public String hello(ModelMap map){

//        Idea idea = generateIdea();
//        service.addIdea(idea);
        List<Idea> list = service.list();
        map.addAttribute("list", list);
        return "index";
    }

    @RequestMapping(value = "/create")
    public String createNewForm(ModelMap map){
        map.addAttribute("newIdea", new Idea());
        return "create";
    }

    @RequestMapping(value = "/submitNew", method = RequestMethod.POST)
    public String createNewIdea(@ModelAttribute(value = "newIdea") Idea idea){
        service.addIdea(idea);
        return "redirect:hello";
    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateIdeaForm(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.getModelMap().addAttribute("idea", service.getIdea(id));
        return modelAndView;
    }

    @RequestMapping(value = "/submitUpdate", method = RequestMethod.POST)
    public String updateIdea(@ModelAttribute(value = "idea") Idea idea){
        service.updateIdea(idea);
        return "redirect:hello";
    }

    @RequestMapping(value = "/delete")
    public String deleteIdea(@RequestParam(value = "id") int id){
        service.deleteIdea(id);
        return "redirect:hello";
    }












//    private Idea generateIdea() {
//        Random random = new Random();
//        Idea idea = new Idea();
//        idea.setLikes(random.nextInt(20));
//        idea.setDislikes(random.nextInt(20));
//        idea.setCapture(generateText(random, 100));
//        idea.setContent(generateText(random, 1000));
//        return idea;
//    }

//    private String generateText(Random random, int i) {
//        int lenght = random.nextInt(i - 10) + 10;
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int j = 0; j < lenght; j++) {
//            stringBuilder.append((char) (random.nextInt(26) + 97));
//
//            if(i % 10 == 9){
//                stringBuilder.append(" ");
//            }
//        }
//        return stringBuilder.toString();
//    }

}
