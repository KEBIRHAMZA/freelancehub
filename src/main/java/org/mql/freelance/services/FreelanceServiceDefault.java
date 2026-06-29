package org.mql.freelance.services;

import java.util.List;
import java.util.Optional;

import org.mql.freelance.models.Freelancer;
import org.mql.freelance.models.Mission;
import org.mql.freelance.models.Skill;
import org.mql.freelance.repositories.FreelancerRepository;
import org.mql.freelance.repositories.MissionRepository;
import org.mql.freelance.repositories.SkillRepository;
import org.springframework.stereotype.Service;

@Service
public class FreelanceServiceDefault implements FreelanceService {

    private FreelancerRepository freelancerRepo;
    private MissionRepository missionRepo;
    private SkillRepository skillRepo;

    public FreelanceServiceDefault(FreelancerRepository freelancerRepo,
                                   MissionRepository missionRepo,
                                   SkillRepository skillRepo) {
        this.freelancerRepo = freelancerRepo;
        this.missionRepo = missionRepo;
        this.skillRepo = skillRepo;
    }

    @Override
    public List<Freelancer> getAllFreelancers() {
        return freelancerRepo.findAll();
    }

    @Override
    public Freelancer getFreelancerById(int id) {
        Optional<Freelancer> f = freelancerRepo.findById(id);
        if(f.isPresent()) return f.get();
        return null;
    }

    @Override
    public List<Freelancer> searchFreelancersByName(String keyword) {
        return freelancerRepo.findByKeyword(keyword);
    }

    @Override
    public List<Freelancer> getFreelancersBySkill(String skillName) {
        return freelancerRepo.findBySkillName(skillName);
    }

    @Override
    public List<Freelancer> getFreelancersByMaxRate(double maxRate) {
        return freelancerRepo.findByDailyRateLessThanEqual(maxRate);
    }

    @Override
    public List<Mission> getAllMissions() {
        return missionRepo.findAll();
    }

    @Override
    public Mission getMissionById(int id) {
        Optional<Mission> m = missionRepo.findById(id);
        if(m.isPresent()) return m.get();
        return null;
    }

    @Override
    public List<Mission> getMissionsByStatus(String status) {
        return missionRepo.findByStatus(status);
    }

    @Override
    public List<Mission> getMissionsByClient(String client) {
        return missionRepo.findByClient(client);
    }

    @Override
    public List<Mission> searchMissions(String keyword) {
        return missionRepo.findByKeyword(keyword);
    }

    @Override
    public List<Mission> getMissionsByBudgetRange(double min, double max) {
        return missionRepo.findByBudgetBetween(min, max);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepo.findAll();
    }

    @Override
    public List<Skill> getSkillsByCategory(String category) {
        return skillRepo.findByCategory(category);
    }
}