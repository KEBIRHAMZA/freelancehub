package org.mql.freelance.controllers;

import java.util.List;

import org.mql.freelance.models.Freelancer;
import org.mql.freelance.models.Mission;
import org.mql.freelance.models.Skill;
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
        List<Freelancer> freelancers = service.getAllFreelancers();
        model.addAttribute("title", "Freelancers disponibles");
        model.addAttribute("freelancers", freelancers);
        return "freelancers-list"; 
    }

    @GetMapping("/missions")
    public String listMissions(Model model) {
        List<Mission> missions = service.getAllMissions();
        model.addAttribute("title", "Missions disponibles");
        model.addAttribute("missions", missions);
        return "missions-list"; 
    }

    @GetMapping("/skills")
    public String listSkills(Model model) {
        List<Skill> skills = service.getAllSkills();
        model.addAttribute("title", "Compétences");
        model.addAttribute("skills", skills);
        return "skills-list"; 
    }
}