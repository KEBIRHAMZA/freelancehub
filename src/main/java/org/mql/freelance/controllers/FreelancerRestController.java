package org.mql.freelance.controllers;

import java.util.List;

import org.mql.freelance.models.Freelancer;
import org.mql.freelance.services.FreelanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * Conventions REST :
 * GET    /api/freelancers            → liste complète
 * GET    /api/freelancers/{id}       → freelancer par id (PathVariable)
 * GET    /api/freelancers?name=xxx   → recherche par nom (RequestParam)
 * GET    /api/freelancers?skill=xxx  → recherche par compétence
 * GET    /api/freelancers?maxRate=x  → recherche par tarif max
 * POST   /api/freelancers            → créer un freelancer (RequestBody)
 */
@RestController
@RequestMapping("/api/freelancers")
@CrossOrigin("*")
public class FreelancerRestController {

    private final FreelanceService service;

    public FreelancerRestController(FreelanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Freelancer> getAll() {
        return service.getAllFreelancers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Freelancer> getById(@PathVariable int id) {
        Freelancer f = service.getFreelancerById(id);
        if (f != null) return ResponseEntity.ok(f);
        return ResponseEntity.notFound().build();
    }

    @GetMapping(params = "name")
    public List<Freelancer> searchByName(@RequestParam String name) {
        return service.searchFreelancersByName(name);
    }

    @GetMapping(params = "skill")
    public List<Freelancer> searchBySkill(@RequestParam String skill) {
        return service.getFreelancersBySkill(skill);
    }

    @GetMapping(params = "maxRate")
    public List<Freelancer> searchByMaxRate(@RequestParam double maxRate) {
        return service.getFreelancersByMaxRate(maxRate);
    }
}