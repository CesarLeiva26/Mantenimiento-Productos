package pe.youtube.MantenimientoProductos.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbproductos")
public class Producto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idproductos;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "precio")
    private Double precio;
    public Double calcularGanancias() {
        return stock * precio;
    }
}