package controllers;

import java.util.List;

import models.Evaluacion;
import models.Parametro;
import models.Resultado;
import models.Resultado_Item;
import models.Usuario;
import play.mvc.Controller;
import controllers.Securing.Security;

public class Resultados extends Controller {

    public static void index(Long id) {
    	//obteniendo datos del usuario que ha iniciado sesion
		if(Security.isConnected()) {
			Usuario user = Usuario.find("byEmail", Security.connected()).first();
	        renderArgs.put("user", user.nombre+" "+user.apellido);
	    }
    	Evaluacion evaluacion=Evaluacion.findById(id);
    	Resultado res=evaluacion.resultado;
    	
    	List<Resultado_Item> resumen=Resultado_Item.find("byResultado", res).fetch();
    	List<Parametro> parametros=Parametro.findAll();
        render(evaluacion,resumen,parametros);
    }


}
