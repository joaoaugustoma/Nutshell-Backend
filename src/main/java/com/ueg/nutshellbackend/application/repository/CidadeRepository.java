package com.ueg.nutshellbackend.application.repository;

import com.ueg.nutshellbackend.application.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("SELECT cidade from Cidade cidade join fetch cidade.estado estado join fetch estado.pais where cidade.id = :idCidade")
    public Cidade acharPeloId(Long idCidade);

}
