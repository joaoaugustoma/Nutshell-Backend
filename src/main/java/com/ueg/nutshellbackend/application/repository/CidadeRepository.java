package com.ueg.nutshellbackend.application.repository;

import com.ueg.nutshellbackend.application.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
