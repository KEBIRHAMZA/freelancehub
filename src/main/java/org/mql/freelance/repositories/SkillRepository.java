package org.mql.freelance.repositories;

import java.util.List;

import org.mql.freelance.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

    List<Skill> findByCategory(String category);

    List<Skill> findByNameContainingIgnoreCase(String name);
}