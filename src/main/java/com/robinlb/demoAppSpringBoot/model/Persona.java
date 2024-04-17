package com.robinlb.demoAppSpringBoot.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class Persona implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Nonnull
  @Column(name = "nombres")
  private String nombres;

  @Nonnull
  @Column(name = "apellidos")
  private String apellidos;

  @Nonnull
  @Column(name = "nui")
  private String nui;

  @Nonnull
  @Column(name = "telefono")
  private String telefono;

  @Nonnull
  @Column(name = "email")
  private String email;

  @Nonnull
  @Temporal(TemporalType.DATE)
  @Column(name = "nacimiento")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date fecha_nacimiento;

  public Persona() {
  }

}
