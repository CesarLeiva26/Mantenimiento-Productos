package pe.youtube.MantenimientoProductos.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.youtube.MantenimientoProductos.Model.Producto;
import pe.youtube.MantenimientoProductos.Service.ProductoService;

@Controller
@AllArgsConstructor
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("")
    public String frmProductos(Model model) {
        model.addAttribute("listaProductos", productoService.listarProductos());
        return "frmProductos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("producto", new Producto());
        return "frmRegistroProducto";
    }
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        if (producto.getIdproductos() == null) {
            productoService.registrarProductos(producto);
        } else {
            productoService.actualizarProducto(producto);
        }
        return "redirect:/producto";
    }
    @GetMapping("/actualizar")
    public String mostrarFormularioActualizar(@RequestParam Integer idproducto, Model model) {
        Producto producto = productoService.buscarProductoPorId(idproducto);
        model.addAttribute("producto", producto);
        return "frmRegistroProducto";
    }
    @PostMapping("/actualizar")
    public String actualizarProducto(@ModelAttribute Producto producto) {
        productoService.actualizarProducto(producto);
        return "redirect:/producto";
    }
    @GetMapping("/eliminar")
    public String eliminarProducto(@RequestParam Integer idproducto) {
        productoService.eliminarProducto(idproducto);
        return "redirect:/producto";
    }
}