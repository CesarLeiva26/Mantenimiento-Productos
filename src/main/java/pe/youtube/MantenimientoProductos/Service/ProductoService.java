package pe.youtube.MantenimientoProductos.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.youtube.MantenimientoProductos.Model.Producto;
import pe.youtube.MantenimientoProductos.Repository.ProductoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService {

    private ProductoRepository productoRepository;
    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }
    public Producto registrarProductos (Producto producto){
        return productoRepository.save(producto);
    }
    public Producto buscarProductoPorId(Integer idProducto) {
        return productoRepository.findById(idProducto)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID: " + idProducto));
    }
    public Producto actualizarProducto(Producto producto){
        return productoRepository.save(producto);
    }
    public void eliminarProducto (Integer idproducto){
        productoRepository.deleteById(idproducto);
    }
}