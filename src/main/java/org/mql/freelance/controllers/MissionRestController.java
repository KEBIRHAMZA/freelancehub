package org.mql.freelance.controllers;

import java.util.List;

import org.mql.freelance.models.Mission;
import org.mql.freelance.services.FreelanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/missions")
@CrossOrigin("*")
public class MissionRestController {

    private final FreelanceService service;

    public MissionRestController(FreelanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mission> getAll() {
        return service.getAllMissions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mission> getById(@PathVariable int id) {
        Mission m = service.getMissionById(id);
        if (m != null) return ResponseEntity.ok(m);
        return ResponseEntity.notFound().build();
    }

    @GetMapping(params = "status")
    public List<Mission> byStatus(@RequestParam String status) {
        return service.getMissionsByStatus(status);
    }

    @GetMapping(params = "client")
    public List<Mission> byClient(@RequestParam String client) {
        return service.getMissionsByClient(client);
    }

    @GetMapping(params = "keyword")
    public List<Mission> search(@RequestParam String keyword) {
        return service.searchMissions(keyword);
    }

    @GetMapping(params = {"min", "max"})
    public List<Mission> byBudgetRange(@RequestParam double min, @RequestParam double max) {
        return service.getMissionsByBudgetRange(min, max);
    }
}