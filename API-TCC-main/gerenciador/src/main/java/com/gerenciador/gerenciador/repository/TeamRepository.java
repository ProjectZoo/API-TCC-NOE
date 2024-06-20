package com.gerenciador.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gerenciador.gerenciador.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findById(long id);
}
