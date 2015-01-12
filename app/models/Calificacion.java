package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Calificacion extends Model {
	String detalle;
	int valor;
	public Calificacion(String detalle, int valor) {
		super();
		this.detalle = detalle;
		this.valor = valor;
	}	
}
