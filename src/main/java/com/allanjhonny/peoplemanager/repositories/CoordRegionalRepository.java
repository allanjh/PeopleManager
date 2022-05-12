package com.allanjhonny.peoplemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allanjhonny.peoplemanager.domain.CoordenadorRegional;

@Repository
public interface CoordRegionalRepository extends JpaRepository<CoordenadorRegional,Integer>{

}
