package controllers;

import java.text.SimpleDateFormat;
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
		Usuario user = Usuario.find("byEmail", Security.connected()).first();
		//obteniendo datos del usuario que ha iniciado sesion
		if(Security.isConnected()) {
	        
	        renderArgs.put("user", user.nombre+" "+user.apellido);
	    }
		
		
		List <Evaluacion> evaluaciones= Evaluacion.find("byUsuario",user).fetch();
		Collections.reverse(evaluaciones);//dando la vuelta a los datos de la lista
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
		Usuario u=Usuario.find("byEmail", Security.connected()).first();
		Date fecha=new Date(); 
		Dato datos=new Dato();
		datos.nombreSitio=nombreSitio;
		datos.save();
		Contexto contexto=new Contexto();
		contexto.save();
		
		String cadenaFecha = new SimpleDateFormat("yyyy-MM-dd").format(fecha);
	
		Evaluacion evaluacion=new Evaluacion(cadenaFecha, datos, contexto,u);
		evaluacion.save();
		
		redirect("/evaluaciones");

		
	}
	
	public static void delete(Long id){
		
		Evaluacion evaluacion=Evaluacion.findById(id);
		Dato dato=Dato.findById(evaluacion.dato.id);
		Contexto contexto=Contexto.findById(evaluacion.contexto.id);
		//Agrgar eliminacion de los resultados
		evaluacion.delete();
		dato.delete();
		contexto.delete();
    	
    	redirect("/evaluaciones");
		
		
	}
	
	public static void formulario(){
		Usuario user = Usuario.find("byEmail", Security.connected()).first();
		//obteniendo datos del usuario que ha iniciado sesion
		if(Security.isConnected()) {
	        
	        renderArgs.put("user", user.nombre+" "+user.apellido);
	    }
		render();
	}
	
	
}
