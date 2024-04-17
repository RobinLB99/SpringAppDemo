package com.robinlb.demoAppSpringBoot.repository;

import com.robinlb.demoAppSpringBoot.model.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

  @Query("SELECT p FROM Persona p WHERE p.nui = :nui")
  public Persona findForNUI(@Param("nui") String nui);
  
}
