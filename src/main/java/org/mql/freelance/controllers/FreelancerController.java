package org.mql.freelance.controllers;

import org.mql.freelance.services.FreelanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreelancerController {

    private final FreelanceService service;

    public FreelancerController(FreelanceService service) {
        this.service = service;
    }

    @GetMapping("/freelancers")
    public String listFreelancers(Model model) {
        model.addAttribute("title", "Freelancers disponibles");
        model.addAttribute("freelancers", service.getAllFreelancers());
        return "freelancers-list"; // → templates/freelancers-list.html
    }

    @GetMapping("/missions")
    public String listMissions(Model model) {
        model.addAttribute("title", "Missions disponibles");
        model.addAttribute("missions", service.getAllMissions());
        return "missions-list"; // → templates/missions-list.html
    }

    @GetMapping("/skills")
    public String listSkills(Model model) {
        model.addAttribute("title", "Compétences");
        model.addAttribute("skills", service.getAllSkills());
        return "skills-list"; // → templates/skills-list.html
    }
}