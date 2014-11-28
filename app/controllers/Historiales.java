package controllers;

import controllers.Secure.Security;
import models.Usuario;
import play.mvc.Controller;

public class Historiales extends Controller{
	

	public static void index(){
		
		//obteniendo datos del usuario que ha iniciado sesion
		if(Security.isConnected()) {
            Usuario user = Usuario.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.nombre+" "+user.apellido);
        }
		
		
		render();
	}

}
