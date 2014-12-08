package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class Dato extends Model {
	public String fecha;
	public String plataforma;
	public String url;
	public String nombreSitio;
	
	//Constructor
	public Dato(String f, String p,String url,String n){
		this.fecha=f;
		this.plataforma=p;
		this.url=url;
		this.nombreSitio=n;
		
	}
	
	public Dato(){
		this.fecha="dd/mm/aaaa";
		this.plataforma="web, móvil, desktop";
		this.url="htttp://www.ejemplo.com";
		this.nombreSitio="SITIO EJEMPLO";
		
	}
	

	
    
}
