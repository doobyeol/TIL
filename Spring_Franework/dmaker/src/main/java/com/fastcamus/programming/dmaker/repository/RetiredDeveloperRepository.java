package com.fastcamus.programming.dmaker.repository;

import com.fastcamus.programming.dmaker.entity.Developer;
import com.fastcamus.programming.dmaker.entity.RetiredDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Spring != , JPA 기능
public interface RetiredDeveloperRepository extends JpaRepository<RetiredDeveloper, Long> {
    // JPA 기능을 활용하여 DB 저장하는 인터페이스
}
