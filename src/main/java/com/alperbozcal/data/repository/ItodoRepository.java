package com.alperbozcal.data.repository;

import com.alperbozcal.data.entity.todoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItodoRepository extends JpaRepository<todoEntity, Long> {
}