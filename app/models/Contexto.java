package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Contexto extends Model {
	public String objetivos;
	public String tareas;
	public String pantallas;
	
	
	public Contexto (String o, String t, String p){
		this.objetivos=o;
		this.tareas=t;
		this.pantallas=p;
		
	}
	
	public Contexto(){
		this.objetivos="Debe indicar la finalidad de la evaluación";
		this.tareas="Indique que actividades realiza para evaluar el sistema correspondiente";
		this.pantallas="Especifique las interfaces gráficas con las cuales va a interactuar";
		
	}
    
}
