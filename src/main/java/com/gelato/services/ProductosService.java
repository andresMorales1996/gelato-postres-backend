package com.gelato.services;

import com.gelato.models.*;
import com.gelato.repositories.CategoriasRepository;
import com.gelato.repositories.PorcionesRepository;
import com.gelato.repositories.ProductosRepository;
import com.gelato.repositories.RellenosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import java.util.List;

@Service
public class ProductosService {

  @Autowired
  private ProductosRepository productosRepository;

  @Autowired
  private CategoriasRepository categoriasRepository;

  @Autowired
  private PorcionesRepository porcionesRepository;

  @Autowired
  private RellenosRepository rellenosRepository;

  // MÉTODO LISTAR PRODUCTOS
  public List<Productos> getAllProductos() {
    return productosRepository.findAll();
  }

  // MÉTODO BUSCAR PRODUCTO POR ID
  public Productos getProducto(Long id) {
    return productosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
  }

  // MÉTODO AGREGAR PRODUCTO
  public Productos createProducto(Productos producto) {
    return productosRepository.save(producto);
  }

  // MÉTODO ACTUALIZAR PRODUCTO
  public Productos updateProducto(Long id, Productos update) {
    Productos producto = getProducto(id);
    if (producto != null) {
      producto.setNombre_producto(update.getNombre_producto());
      producto.setDescripcion_producto(update.getDescripcion_producto());
      producto.setEstado_producto(update.getEstado_producto());
      producto.setImagen_producto(update.getImagen_producto());
      producto.setPrecio_producto(update.getPrecio_producto());
      producto.setCategoria(update.getCategoria());
      producto.setPorcion(update.getPorcion());
      producto.setRelleno(update.getRelleno());
      return productosRepository.save(producto);
    } else {
      return null;
    }
  }

  // MÉTODO ELIMINAR PRODUCTO
  public void deleteProducto(Long id) {
    Productos producto = getProducto(id);
    productosRepository.delete(producto);
  }

  public List<Categorias> getAllCategorias() {
    return categoriasRepository.findAll();
  }

  public List<Porciones> getAllPorciones() {
    return porcionesRepository.findAll();
  }

  public List<Rellenos> getAllRellenos() {
    return rellenosRepository.findAll();
  }

  // METODO GUARDAR IMAGEN
  public void saveImage(Long id, MultipartFile file) throws IOException {
    Productos producto = getProducto(id);
    if (producto != null) {
      // Ruta donde se guardará la imagen
      String uploadDir = "uploads/";
      Path uploadPath = Paths.get(uploadDir);

      // Crea el directorio si no existe
      if (!uploadPath.toFile().exists()) {
        uploadPath.toFile().mkdirs();
      }

      // Guarda el archivo en el sistema de archivos
      File imageFile = new File(uploadPath.toFile(), file.getOriginalFilename());
      try (FileOutputStream fos = new FileOutputStream(imageFile)) {
        fos.write(file.getBytes());
      }

      // Actualiza la entidad Producto con la ruta de la imagen
      producto.setImagePath(imageFile.getAbsolutePath());
      productosRepository.save(producto);
    }
  }

}
