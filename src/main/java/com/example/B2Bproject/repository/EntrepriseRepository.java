package com.example.B2Bproject.repository;

import com.example.B2Bproject.entity.EntrepriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EntrepriseRepository extends JpaRepository<EntrepriseEntity,Long> {
}
