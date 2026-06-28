package org.mql.freelance.repositories;

import java.util.List;
import java.util.Optional;

import org.mql.freelance.models.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FreelancerRepository extends JpaRepository<Freelancer, Integer> {

    // Recherche par spécialité
    List<Freelancer> findBySpecialty(String specialty);

    // Recherche par email (unique)
    Optional<Freelancer> findByEmail(String email);

    // Freelancers dont le tarif est inférieur ou égal à un plafond
    List<Freelancer> findByDailyRateLessThanEqual(double maxRate);

    // JPQL : recherche par fragment de nom
    @Query("SELECT f FROM Freelancer f WHERE f.name LIKE %:keyword%")
    List<Freelancer> findByKeyword(String keyword);

    // JPQL : freelancers ayant une compétence donnée (par nom de skill)
    @Query("SELECT f FROM Freelancer f JOIN f.skills s WHERE s.name = :skillName")
    List<Freelancer> findBySkillName(String skillName);
}