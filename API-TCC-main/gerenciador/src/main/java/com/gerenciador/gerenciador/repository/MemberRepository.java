package com.gerenciador.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gerenciador.gerenciador.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findById(long id);
}
