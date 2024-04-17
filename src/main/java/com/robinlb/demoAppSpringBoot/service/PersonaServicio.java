package com.robinlb.demoAppSpringBoot.service;

import com.robinlb.demoAppSpringBoot.model.Persona;
import com.robinlb.demoAppSpringBoot.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServicio {

  private final PersonaRepository repositorio;

  @Autowired
  public PersonaServicio(PersonaRepository repositorio) {
    this.repositorio = repositorio;
  }
  
  public void guardarPersona(Persona persona) {
    repositorio.save(persona);
  }
  
  public void eliminarPersona(Long id) {
    repositorio.deleteById(id);
  }
  
  @Transactional(readOnly = true)
  public Persona buscarPersonaPorId(Long id) {
    return repositorio.findById(id).orElse(null);
  }
  
  @Transactional(readOnly = true)
  public Persona buscarPersonaPorNUI(String nui) {
    return repositorio.findForNUI(nui);
  }
  
  @Transactional(readOnly = true)
  public List<Persona> listaPersonas() {
    return (List<Persona>) repositorio.findAll();
  }
  
  @Transactional(readOnly = true)
  public Long contarPersonas() {
    return repositorio.count();
  }

}
