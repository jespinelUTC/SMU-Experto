package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import controllers.Securing.Security;
import models.Dato;
import models.Usuario;
import play.mvc.*;

public class Datos extends Controller {
	
	 static Dato d1;

    public static void index() {
    	
    	//obteniendo datos del usuario que ha iniciado sesion
    			if(Security.isConnected()) {
    	            Usuario user = Usuario.find("byEmail", Security.connected()).first();
    	            renderArgs.put("user", user.nombre+" "+user.apellido);
    	        }
    			if(d1 == null)
    				d1=new Dato();
    			
    	Dato d=d1;
        render(d);
    }
    
    public static void guardarDatos(String fecha, String plataforma,String url,String nombreSitio){
		d1=new Dato(plataforma,url,nombreSitio);
		d1.save();
		index();
		
	}
    
    public static void finalizar(){
    	Long id=d1.id;
    	d1=Dato.findById(id);
    	d1.delete();
    	d1=new Dato();
    	index();
    }

    


}
