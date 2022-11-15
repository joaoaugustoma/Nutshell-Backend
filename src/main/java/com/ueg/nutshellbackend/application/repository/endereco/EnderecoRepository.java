package com.ueg.nutshellbackend.application.repository.endereco;

import com.ueg.nutshellbackend.application.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
