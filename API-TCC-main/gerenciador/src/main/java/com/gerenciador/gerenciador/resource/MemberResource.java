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
import com.gerenciador.gerenciador.model.Member;
import com.gerenciador.gerenciador.repository.MemberRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/members")
@Api(value="API REST Members")
@CrossOrigin(origins="*")
public class MemberResource {
    
    @Autowired
    MemberRepository memberRepository;
    
    @GetMapping
    @ApiOperation(value="Retorna uma lista de membros")
    public List<Member> listMembers() {
        return memberRepository.findAll();
    }
    
    @GetMapping("/{id}")
    @ApiOperation(value="Retorna um membro específico pelo ID")
    public Member getMember(@PathVariable(value="id") long id) {
        return memberRepository.findById(id).orElse(null);
    }
    
    @PostMapping
    @ApiOperation(value="Salva um membro")
    public Member saveMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }
    
    @DeleteMapping
    @ApiOperation(value="Deleta um membro")
    public void deleteMember(@RequestBody Member member) {
        memberRepository.delete(member);
    }
    
    @PutMapping
    @ApiOperation(value="Atualiza um membro")
    public Member updateMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }
}
