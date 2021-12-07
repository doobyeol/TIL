package com.fastcamus.programming.dmaker.repository;

import com.fastcamus.programming.dmaker.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Spring != , JPA 기능
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    // JPA 기능을 활용하여 DB 저장하는 인터페이스
    Optional<Developer> findByMemberId(String memberId);
}
