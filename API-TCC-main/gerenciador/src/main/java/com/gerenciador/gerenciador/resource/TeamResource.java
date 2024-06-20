package com.gerenciador.gerenciador.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gerenciador.gerenciador.model.Team;
import com.gerenciador.gerenciador.repository.TeamRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/teams")
@Api(value="API REST Teams")
@CrossOrigin(origins="*")
public class TeamResource {
    
    @Autowired
    TeamRepository teamRepository;
    
    @GetMapping
    @ApiOperation(value="Retorna uma lista de times")
    public List<Team> listTeams() {
        return teamRepository.findAll();
    }
    
    @GetMapping("/{id}")
    @ApiOperation(value="Retorna um time específico pelo ID")
    public Team getTeam(@PathVariable(value="id") long id) {
        return teamRepository.findById(id).orElse(null);
    }
    
    @PostMapping
    @ApiOperation(value="Salva um time")
    public Team saveTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }
    
    @DeleteMapping
    @ApiOperation(value="Deleta um time")
    public void deleteTeam(@RequestBody Team team) {
        teamRepository.delete(team);
    }
    
    @PutMapping
    @ApiOperation(value="Atualiza um time")
    public Team updateTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }
}
