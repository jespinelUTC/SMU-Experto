package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Dato extends Model {
	public Date fecha;
	public String plataforma;
	public String agenteUsuario;
	public String url;
	public String nombreSitio;
	
	//Constructor
	public Dato(Date f, String p,String a,String url,String n){
		this.fecha=f;
		this.plataforma=p;
		this.agenteUsuario=a;
		this.url=url;
		this.nombreSitio=n;
		
	}
	
	
    
}
