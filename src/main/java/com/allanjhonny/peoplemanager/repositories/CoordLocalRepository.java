package com.allanjhonny.peoplemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allanjhonny.peoplemanager.domain.CoordenadorLocal;

@Repository
public interface CoordLocalRepository extends JpaRepository<CoordenadorLocal,Integer>{

}
