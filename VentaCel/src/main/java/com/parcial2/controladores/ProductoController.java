package com.parcial2.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.parcial2.entidades.Producto;
import com.parcial2.repositorios.RepoMarca;
import com.parcial2.repositorios.RepoProducto;

@Controller
@RequestMapping(value="producto")
public class ProductoController {

	@Autowired
	RepoProducto repoProducto;
	@Autowired
	RepoMarca repoMarca;
	
	@RequestMapping(value="/index")
	public String inicio() {
		return "index";
	}
	
	@GetMapping("/pro") // Ruta listado
	public String listado(Model model) {
		model.addAttribute("productos", repoProducto.findAll());
		return "inicioP";
	}
	
	@GetMapping(value="/registroP")   //Nuevo
	public String formumario(Model model) {
		model.addAttribute("marca", repoMarca.findAll());
		model.addAttribute("producto", repoProducto.findAll());
		return "/producto";
	}
	
	@PostMapping(value = "/registrarP")  //Add
	public String registrarP(@Valid @ModelAttribute("producto") Producto producto, RedirectAttributes flash) {
			if(producto.getId()>0) {
				flash.addFlashAttribute("warning","exito, producto actualizado!");
			}else {
				flash.addFlashAttribute("exito","exito, producto guardado");
			}
			repoProducto.save(producto);
		return "redirect:/producto/pro";
	}

	@GetMapping(value="/editarP/{id}") //Edit
	public String formumarioEP(@PathVariable(value="id") int id, Model model) {
		Producto p = new Producto();
		p=repoProducto.getOne(id);
		model.addAttribute("producto", p);
		model.addAttribute("marca", repoMarca.findAll());
		return "/actualizarP";
	}
}
