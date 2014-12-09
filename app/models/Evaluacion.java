package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Evaluacion extends Model {
	public String fecha;
	public Dato dato;
	public Contexto contexto;
	
	public Evaluacion(String f, Dato d, Contexto c){
		this.fecha=f;
		this.dato=d;
		this.contexto=c;
		
	}
	
    
}
