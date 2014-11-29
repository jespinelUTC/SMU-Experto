package models;

import javax.persistence.Entity;

import net.sf.oval.constraint.Email;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model{
	
	@Email public String email;
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
