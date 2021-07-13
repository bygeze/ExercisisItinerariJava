package com.example.crudTesting.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crudTesting.bean.Libro;
import com.example.crudTesting.bean.Usuario;
import com.example.crudTesting.repository.ArrayListDatabase;

@Controller
@RequestMapping("")
public class TestController {
	
	/*
	 * Configurar base de datos
	 */
	ArrayListDatabase db = new ArrayListDatabase();
	Usuario usuario;
	
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("titulo", "Formulario de Acceso");
		return "login";
	}
	
	
	/*
	 * Recibir los datos enviados por el formulario empaquetados en una clase
	 * Se crea un bean.
	 */
	
	@PostMapping("/")
	public String listado(Model model, 
						  Usuario usuario) {
		
		if(usuario.getUsername().equals("gustavo") && usuario.getPassword().equals("1234")) {
			model.addAttribute("usuario", usuario);
			this.usuario = usuario;
			
			ArrayList<Libro> libros = db.getLibros();
			model.addAttribute("libros", libros);
			
			model.addAttribute("button", "Insertar libro");
			model.addAttribute("action", "/insertBook");
			
			return "consulta";
		} else {
			model.addAttribute("titulo", "Formulario de Acceso");
			return "login";
		}
	}
	
	/*  
	 * Recibir los datos enviados por el formulario uno a uno
	 *

	@PostMapping("/")
	public String listado(Model model, 
						  @RequestParam String username,
						  @RequestParam String password) {
		
		if(username.equals("gustavo") && password.equals("1234")) {
			return "consulta";
		} else {
			return "login";
		}
	}
	
	*/
	
	@PostMapping("/insertarLibro")
	public String insertar(Libro libro, Model model) {
		db.addLibro(libro);
		
		ArrayList<Libro> libros = db.getLibros();
		
		model.addAttribute("usuario", this.usuario);
		model.addAttribute("libros", libros);
		
		model.addAttribute("button", "Insertar libro");
		model.addAttribute("action", "/insertBook");
		
		return "consulta";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String borrar(@PathVariable int id, Model model) {
		db.deleteBook(id);
		
		ArrayList<Libro> libros = db.getLibros();
		
		model.addAttribute("libros", libros);
		
		model.addAttribute("usuario", this.usuario);
		
		model.addAttribute("button", "Insertar libro");
		model.addAttribute("action", "/insertBook");
		
		return "consulta";
	}
	
	@GetMapping("/modifyBook/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Libro libro = db.getLibro(id);
		
		ArrayList<Libro> libros = db.getLibros();
		
		model.addAttribute("libros", libros);
		model.addAttribute("libro", libro);
		
		model.addAttribute("usuario", this.usuario);
		
		model.addAttribute("button", "Actualiza libro");
		model.addAttribute("action", "/modifyBook");
		
		return "consulta";
	}
	
	@PostMapping("/modifyBook")
	public String modificarPost(Libro libro, Model model) {
		db.updateBook(libro);
		
		ArrayList<Libro> libros = db.getLibros();
		
		model.addAttribute("libros", libros);
		model.addAttribute("libro", null);
		
		model.addAttribute("usuario", this.usuario);
		
		model.addAttribute("button", "Insertar libro");
		model.addAttribute("action", "/insertBook");
		
		return "consulta";
	}
	
	
}
