package com.gelato.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "estado_pago")

public class EstadoPago {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_estado_pago;

  @Column(name = "nombre_estado:pago", nullable = false)
  private String nombre_estado_pago;
}
