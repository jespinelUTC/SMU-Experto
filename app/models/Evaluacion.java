package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Evaluacion extends Model {
	public String fecha;
	public String estado;
	@ManyToOne
	public Dato dato;
	@ManyToOne
	public Contexto contexto;
	@ManyToOne
	public Usuario usuario;
	@ManyToOne
	public Resultado resultado;
	
	public Evaluacion(String f, Dato d, Contexto c, Usuario u, Resultado r){
		this.fecha=f;
		this.dato=d;
		this.contexto=c;
		this.usuario=u;
		this.resultado=r;
	}
	
	
    
}
