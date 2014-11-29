package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Security extends Securing.Security {
	
	static boolean authenticate(String username, String password){
        Usuario user = Usuario.find("byEmail", username).first();

        return user != null && user.password.equals(password);
    }
	
	public static void guardarUsuario(String email, String nombre,String apellido,String password){
		Usuario u=new Usuario(email,nombre,apellido,password);
		u.save();
		redirect("/secure/login");
	}

}
