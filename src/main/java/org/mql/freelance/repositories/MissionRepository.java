package org.mql.freelance.repositories;

import java.util.List;

import org.mql.freelance.models.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MissionRepository extends JpaRepository<Mission, Integer> {

    List<Mission> findByStatus(String status);

    List<Mission> findByClient(String client);

    List<Mission> findByBudgetLessThanEqual(double maxBudget);

    List<Mission> findByBudgetBetween(double min, double max);

    @Query("SELECT m FROM Mission m WHERE m.title LIKE %:keyword% OR m.description LIKE %:keyword%")
    List<Mission> findByKeyword(String keyword);
}