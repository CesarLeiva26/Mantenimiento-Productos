package pe.youtube.MantenimientoProductos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.youtube.MantenimientoProductos.Model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findAllByIdproductos(Integer idproducto);
}
