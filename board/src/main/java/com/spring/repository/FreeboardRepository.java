package com.spring.repository;

import com.spring.model.Freeboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeboardRepository extends JpaRepository<Freeboard, Long> {
}
