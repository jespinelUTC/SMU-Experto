package controllers;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import models.Contexto;
import models.Dato;
import models.Evaluacion;
import models.Item;
import models.Parametro;
import models.Resultado;
import models.Resultado_Item;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.With;
import controllers.Securing.Security;

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
		
		Resultado resultado=new Resultado();
		resultado.save();
		
		datos.nombreSitio=nombreSitio;
		datos.save();
		
		Contexto contexto=new Contexto();
		contexto.save();
		
		String cadenaFecha = new SimpleDateFormat("yyyy-MM-dd").format(fecha);
	
		Evaluacion evaluacion=new Evaluacion(cadenaFecha, datos, contexto,u,resultado);
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
	
	public static void formulario(String plataforma, String url,String objetivo, String tareas, String pantallas, Long idEvaluacion){
		
		
		
		//System.out.println(plataforma+" "+url+" "+objetivo+ " "+tareas+ " "+pantallas+ " "+idEvaluacion);
		
		//obteniendo datos del usuario que ha iniciado sesion
		if(Security.isConnected()) {
			Usuario user = Usuario.find("byEmail", Security.connected()).first();
	        renderArgs.put("user", user.nombre+" "+user.apellido);
	    }
		
		Evaluacion evaluacion=Evaluacion.findById(idEvaluacion);
		Contexto contexto=evaluacion.contexto;
		Dato dato=evaluacion.dato;
		
		contexto.objetivos=objetivo;
		contexto.tareas=tareas;
		contexto.pantallas=pantallas;
		contexto.save();
		dato.plataforma=plataforma;
		dato.url=url;
		dato.save();
		

		
		
		
		
		List<Parametro> parametros=Parametro.all().fetch();
		List<Item> items = Item.all().fetch();
		

		
		render(parametros,items,evaluacion);
	}
	
public static void calificar(String res, Long id){
	
	Evaluacion evaluacion=Evaluacion.findById(id);
	Resultado resultado=evaluacion.resultado;
	
	String[] arrayResultados=res.split("/");
	
	for (int i=0;i<arrayResultados.length;i++){
		//System.out.println(arrayResultados[i]);
		
		String auxCalificacion=arrayResultados[i].substring(0,1);
		int calificacion=Integer.parseInt(auxCalificacion);
		
		String auxIdItem=arrayResultados[i].substring(2);
		Long idItem=Long.parseLong(auxIdItem);
		
		Item item1=Item.findById(idItem);
		
		//Resultado r, Item i, int c
		Resultado_Item res_item=new Resultado_Item(resultado,item1,calificacion);
		res_item.save();
		

	}
	

	
}
	
	
}
