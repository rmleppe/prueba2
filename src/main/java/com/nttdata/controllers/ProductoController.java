package com.nttdata.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.CategoriaProducto;
import com.nttdata.models.Producto;
import com.nttdata.services.CategoriaProductoService;
import com.nttdata.services.CategoriaService;
import com.nttdata.services.ProductoService;



@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	CategoriaProductoService categoriaproductoService;
	
	
	@RequestMapping("")
	public String producto(@ModelAttribute("producto") Producto producto,
			Model model) {
		
		model.addAttribute("listaProductos", productoService.obtenerListaProductos());
		model.addAttribute("listaCategoria", categoriaService.obtenerListaCategorias());
		model.addAttribute("listaCategoriaProducto", categoriaproductoService.obtenerListaCategoriaProductos());
		productoService.findAllProductosNombres();
		
		List<Producto> lProductos=productoService.obtenerUsuarioWhereId(1L);
		List<CategoriaProducto> lProductosCategorias=categoriaproductoService.obtenerCategoriaProductoCategoriaWhereId(1L);
		return "producto/producto";
	}
	
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("producto") Producto producto)
	{
		
		
		productoService.insertarProducto(producto);
		
		return "redirect:/producto";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarProducto(@RequestParam("id") Long id) {
		
		Producto producto = productoService.buscarProductoId(id);
		
		if(producto !=null) {
			productoService.eliminarProductoObjeto(producto);
		}
		
		return "redirect:/producto";
	}
	
	@RequestMapping("/{id}/editar")
    public String edit(@PathVariable("id") Long id, Model model) {
    	System.out.println("editar");
    	Producto producto = productoService.buscarProductoId(id);
    	if(producto !=null) {
    		model.addAttribute("listaCategorias", categoriaService.obtenerListaCategorias());
		       model.addAttribute("producto", producto);
		       return "/producto/editar";
		}
		
		return "redirect:/producto";
    }
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
    	System.out.println("Update");
        if (result.hasErrors()) {
            return "/producto/editar";
        } else {
        	productoService.updateProducto(producto);
            return "redirect:/producto";
        }
    }
	
	
	
}
