package com.ueg.nutshellbackend.application.repository;

import com.ueg.nutshellbackend.application.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
