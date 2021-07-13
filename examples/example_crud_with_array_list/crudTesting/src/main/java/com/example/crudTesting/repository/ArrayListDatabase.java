package com.example.crudTesting.repository;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.crudTesting.bean.Libro;

public class ArrayListDatabase {
	
	ArrayList<Libro> libros = new ArrayList<Libro>();
	
	public ArrayListDatabase() {
		libros.add(new Libro(1, "HARRY POTTER Y EL PRISIONERO DE AZKABAN", "J.K.ROWLING", "SALAMANDRA", "26/09/2016 00:00:00", "INFANTIL"));
		libros.add(new Libro(2, "EL GRAN LABERINTO", "FERNANDO SABATER PEREZ", "ARIEL", "20/09/2016 00:00:00", "FICCION"));
		libros.add(new Libro(3, "ROMEO Y JULIETA", "WILLIAM SHAKESPEARE", "SALAMANDRA", "22/09/2016 00:00:00", "ROMANTICA"));
	}
	
	public ArrayList<Libro> getLibros() {
		return libros;
	}
	
	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
	public void addLibro(Libro libro) {
		this.libros.add(libro);
	}
	
	public void deleteBook(int id) {
		Iterator<Libro> it = libros.iterator();
		
		while(it.hasNext()) {
			Libro li = it.next();
			if(li.getId() == id) {
				it.remove();
				break;
			}
		}
	}
	
	public Libro getLibro(int id) {
		Iterator<Libro> it = libros.iterator();
		
		while(it.hasNext()) {
			Libro li = it.next();
			
			if(li.getId() == id) {
				return li;
			}
		}
		
		return null;
	}
	
	public void updateBook(Libro libro) {
		Iterator<Libro> it = libros.iterator();
		
		while(it.hasNext()) {
			Libro li = it.next();
			
			if(li.getId() == libro.getId()) {
				li.setTitulo(libro.getTitulo());
				li.setAutor(libro.getAutor());
				li.setEditorial(libro.getEditorial());
				li.setFecha(libro.getFecha());
				li.setTematica(libro.getTematica());
			}
				
		}
	}
}
