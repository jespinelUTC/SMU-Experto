package controllers;

import models.Usuario;

import org.junit.Before;

import controllers.Secure.Security;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Evaluaciones extends Controller{
	
	 
	public static void index(){
		
		//obteniendo datos del usuario que ha iniciado sesion
				if(Security.isConnected()) {
		            Usuario user = Usuario.find("byEmail", Security.connected()).first();
		            renderArgs.put("user", user.nombre+" "+user.apellido);
		        }
		
		
		render();
	}

}
