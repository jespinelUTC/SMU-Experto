package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Evaluacion extends Model {
	String fecha;
	Dato dato;
	Contexto contexto;
	
	public Evaluacion(String f, Dato d, Contexto c){
		this.fecha=f;
		this.dato=d;
		this.contexto=c;
		
	}
	
    
}
