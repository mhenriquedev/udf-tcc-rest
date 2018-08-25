package com.udf.tcc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udf.tcc.models.Crianca;

@Repository
public interface CriancaRepository extends JpaRepository<Crianca, Long> {

}