package org.keegsands.sportball.repository;

import org.keegsands.sportball.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Integer> {
}
