package com.allanjhonny.peoplemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allanjhonny.peoplemanager.domain.Representante;

@Repository
public interface RepresentanteRepository extends JpaRepository<Representante,Integer>{

}
