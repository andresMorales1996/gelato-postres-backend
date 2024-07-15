package com.gelato.controllers;

import com.gelato.models.MetodoPagos;
import com.gelato.services.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metodoPagos/v1")
public class MetodoPagosController {

  @Autowired
  private MetodoPagoService metodoPagoService;

  @GetMapping("allMetodoPagos")
  public List<MetodoPagos> getAllMetodosPago() {
    return metodoPagoService.getAllMetodosPago();
  }

  @GetMapping("/metodoPago{id}")
  public MetodoPagos getMetodoPagoById(@PathVariable Long id) {
    return metodoPagoService.getMetodoPago(id);
  }

  @PostMapping("/createMetodoPago")
  public MetodoPagos createMetodoPago(@RequestBody MetodoPagos metodoPagos) {
    return metodoPagoService.createMetodoPago(metodoPagos);
  }

  @PutMapping("/updateMetodoPago/{id}")
  public MetodoPagos updateMetodoPago(@PathVariable Long id, @RequestBody MetodoPagos metodoPagosDetails) {
    return metodoPagoService.updateMetodoPago(id, metodoPagosDetails);
  }

  @DeleteMapping("/deleteMetodoPago/{id}")
  public void deleteMetodoPago(@PathVariable Long id) {
    metodoPagoService.deleteMetodoPago(id);
  }

}
