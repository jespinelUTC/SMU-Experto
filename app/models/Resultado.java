package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class Resultado extends Model{
	
	//para indicar el estado de la evaluacion
	public String resultado;
	
	
	public Resultado(){
		
		
	}
	

}
