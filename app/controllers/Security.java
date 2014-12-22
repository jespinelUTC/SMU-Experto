package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Security extends Securing.Security {
	
	static boolean authenticate(String username, String password){
        Usuario user = Usuario.find("byEmail", username).first();

        return user != null && user.password.equals(password);
    }
	
	public static void guardarUsuario(String email, String nombre,String apellido,String password) throws Throwable{
		
		Usuario u=new Usuario(email,nombre,apellido,password);
		u.save();
		Securing.authenticate(email, password,true);
		redirect("/evaluaciones");
	}
	
	
	//error para email existente
	public static void error1(String mail){
		   Usuario user = Usuario.find("byEmail", mail).first();
		   String mensaje;
		   if (user != null){
			   mensaje="ERROR: EMAIL YA UTILIZADO";  
			  render(mensaje);
		   }else{
			   render();
		   }
	}

}
