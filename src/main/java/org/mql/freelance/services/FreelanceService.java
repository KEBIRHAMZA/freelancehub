package org.mql.freelance.services;

import java.util.List;

import org.mql.freelance.models.Freelancer;
import org.mql.freelance.models.Mission;
import org.mql.freelance.models.Skill;

public interface FreelanceService {

    // === Freelancers ===
    List<Freelancer> getAllFreelancers();
    Freelancer getFreelancerById(int id);
    List<Freelancer> searchFreelancersByName(String keyword);
    List<Freelancer> getFreelancersBySkill(String skillName);
    List<Freelancer> getFreelancersByMaxRate(double maxRate);

    // === Missions ===
    List<Mission> getAllMissions();
    Mission getMissionById(int id);
    List<Mission> getMissionsByStatus(String status);
    List<Mission> getMissionsByClient(String client);
    List<Mission> searchMissions(String keyword);
    List<Mission> getMissionsByBudgetRange(double min, double max);

    // === Skills ===
    List<Skill> getAllSkills();
    List<Skill> getSkillsByCategory(String category);
}