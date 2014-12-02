package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

/*
 * Esta clase define el modelo de los parametros
 */
@Entity
public class Parametro extends Model {
    public String nombre;
    public String informacion;    
	public Parametro(String nombre, String informacion) {
		super();
		this.nombre = nombre;
		this.informacion = informacion;		
	}    
}
