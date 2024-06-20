package com.gerenciador.gerenciador.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gerenciador.gerenciador.model.Team;
import com.gerenciador.gerenciador.repository.TeamRepository;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team findById(long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public void deleteById(long id) {
        teamRepository.deleteById(id);
    }
}
