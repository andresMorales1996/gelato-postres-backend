package com.gelato.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rellenos")
public class Rellenos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID_relleno;

  @Column(name = "nombre_relleno", nullable = false)
  private String nombre_relleno;

  @Column(name = "precio_relleno", nullable = false)
  private double precio_relleno;

  //  RELACIONES
//    @OneToOne(mappedBy = "relleno", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private Productos productos;
//
//    @ManyToOne
//    @JoinColumn(name = "relleno_ID_relleno")
//    private Relleno relleno;
//
//    @OneToMany(mappedBy = "relleno", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<Personalizar> personalizar;

}
