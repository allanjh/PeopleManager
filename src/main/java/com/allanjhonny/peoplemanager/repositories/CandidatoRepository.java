package com.allanjhonny.peoplemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allanjhonny.peoplemanager.domain.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Integer>{

}
