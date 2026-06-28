package org.mql.freelance.repositories;

import java.util.List;

import org.mql.freelance.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

    // Recherche par catégorie exacte
    List<Skill> findByCategory(String category);

    // Recherche par fragment de nom (insensible à la casse)
    List<Skill> findByNameContainingIgnoreCase(String name);
}