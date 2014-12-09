package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class Dato extends Model {
	public String plataforma;
	public String url;
	public String nombreSitio;
	
	//Constructor
	public Dato(String p,String url,String n){
		this.plataforma=p;
		this.url=url;
		this.nombreSitio=n;
		
	}
	
	public Dato(){
		this.plataforma="web, móvil, desktop";
		this.url="htttp://www.ejemplo.com";
		this.nombreSitio="SITIO EJEMPLO";
		
	}
	

	
    
}
