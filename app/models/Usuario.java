package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Usuario extends Model{
	
	public String email;
	public String nombre;
	public String apellido;
	public String password;
	
	public Usuario(String e,String n,String a, String p){
		this.email=e;
		this.nombre=n;
		this.apellido=a;
		this.password=p;
		
	}
	

}
