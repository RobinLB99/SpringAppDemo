package com.robinlb.demoAppSpringBoot.controller;

import com.robinlb.demoAppSpringBoot.model.Persona;
import com.robinlb.demoAppSpringBoot.service.PersonaServicio;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/Personas")
public class PersonaController {
  
  private final PersonaServicio servicio;

  @Autowired
  public PersonaController(PersonaServicio servicio) {
    this.servicio = servicio;
  }
  
  @GetMapping("/Agregar")
  public String goToAddPerson(Model model) {
    model.addAttribute("persona", new Persona());
    return "AgregarPersona";
  }
  
  @PostMapping("/crear")
  public String create(@ModelAttribute Persona persona) {
    servicio.guardarPersona(persona);
    return "redirect:/Personas/listar";
  }
  
  @PostMapping("/eliminar/{id}")
  public void deleteById(@PathVariable Long id) {
    servicio.eliminarPersona(id);
  }
  
  @GetMapping("/buscar/{id}")
  public Persona findById(@PathVariable Long id) {
    return servicio.buscarPersonaPorId(id);
  }
  
  @GetMapping("/buscarPorNUI/{nui}")
  public String findByNUI(@PathVariable String nui, Model model) {
    Persona persona = servicio.buscarPersonaPorNUI(nui);
    model.addAttribute("persona", persona);
    return "#";
  }
  
  @GetMapping("/listar")
  public String findAll(Model model) {
    List<Persona> personas = servicio.listaPersonas();
    model.addAttribute("personas", personas);
    return "Personas";
  }
  
  @GetMapping("/contar")
  public Long contarPersonas() {
    return servicio.contarPersonas();
  }
  
}
