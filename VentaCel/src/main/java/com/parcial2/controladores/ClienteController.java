package com.parcial2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.parcial2.entidades.Cliente;
import com.parcial2.repositorios.RepoCliente;
import com.parcial2.repositorios.RepoVenta;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	RepoCliente repoCliente;
	@Autowired
	RepoVenta repoVenta;

	@GetMapping("/cliente") // Ruta listado
	public String listado(Model model) {
		model.addAttribute("clientes", repoCliente.findAll());
		return "index";
	}

	@GetMapping(value = "/registro") // Ruta nuevo
	public String formumario(Model model) {
		return "registroC";
	}

	@PostMapping(value = "/registrar") // Ruta registrar
	public String registrar(@ModelAttribute("cliente") Cliente c, RedirectAttributes flash) {
		if (c.getId() > 0) {
			flash.addFlashAttribute("exito", "Cliente Actualizado con éxito");
		} else {
			flash.addFlashAttribute("warning", "Guardado Cliente...");
		}
		repoCliente.save(c);
		return "redirect:/cliente";
	}

	@GetMapping(value = "/editar/{id}")
	public String editar(@PathVariable(value = "id") int id, Model model) {
		Cliente c = new Cliente();
		c = repoCliente.getOne(id);
		model.addAttribute("cliente", c);
		return "actualizarC";
	}

}
