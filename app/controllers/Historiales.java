package controllers;

import java.util.List;

import models.Evaluacion;
import models.Usuario;
import play.mvc.Controller;
import controllers.Securing.Security;

public class Historiales extends Controller{
	

	public static void index(){
		
		//obteniendo datos del usuario que ha iniciado sesion
		if(Security.isConnected()) {
            Usuario user = Usuario.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.nombre+" "+user.apellido);
        }
		
		List <Evaluacion> evaluaciones=Evaluacion.find("order by id desc").fetch(5);

		render(evaluaciones);
	}

}
