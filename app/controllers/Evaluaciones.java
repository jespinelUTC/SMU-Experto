package controllers;

import java.util.Date;

import models.Contexto;
import models.Dato;
import models.Evaluacion;
import models.Usuario;

import org.junit.Before;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import java.util.*;

import controllers.Securing.Security;
import play.mvc.Controller;
import play.mvc.With;

@With(Securing.class)
public class Evaluaciones extends Controller{
	
	 
	public static void index(){
		
		
		
		//obteniendo datos del usuario que ha iniciado sesion
		if(Security.isConnected()) {
            Usuario user = Usuario.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.nombre+" "+user.apellido);
        }
		
		List <Evaluacion> evaluaciones= Evaluacion.find("order by id desc").fetch();
		render(evaluaciones);
	}
	
	
	public static void create(){
		
		
		
		//obteniendo datos del usuario que ha iniciado sesion
				if(Security.isConnected()) {
		            Usuario user = Usuario.find("byEmail", Security.connected()).first();
		            renderArgs.put("user", user.nombre+" "+user.apellido);
		        }
				render();
		
	}
	
	public static void postCreate(String nombreSitio){
		
		Date fecha=new Date(); 
		Dato datos=new Dato();
		datos.nombreSitio=nombreSitio;
		datos.save();
		Contexto contexto=new Contexto();
		contexto.save();
		
		Evaluacion evaluacion=new Evaluacion(fecha.toString(), datos, contexto);
		evaluacion.save();
		
		redirect("/evaluaciones");

		
	}
	
	
}
