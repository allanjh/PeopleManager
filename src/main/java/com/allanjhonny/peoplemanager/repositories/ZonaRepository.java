package com.allanjhonny.peoplemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allanjhonny.peoplemanager.domain.Zona;

@Repository
public interface ZonaRepository extends JpaRepository<Zona,Integer>{

}
