package controllers;

import java.util.List;

import controllers.Securing.Security;
import models.Parametro;
import models.Usuario;
import play.mvc.*;
@With(Securing.class)
public class Parametros extends Controller {
		
    public static void index() {
    	if(Security.isConnected()) {
            Usuario user = Usuario.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.nombre+" "+user.apellido);
        }
    	List<Parametro> par =Parametro.findAll();
        render(par);
    }
    /*
     * Metodo para la creacion de un Nuevo Parametro
     */
    public static void nuevoParametro(String nombre, String informacion) {
    	
    	//Para mostrar el usuario conectado
    	if(Security.isConnected()) {
            Usuario user = Usuario.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.nombre+" "+user.apellido);
        }
    	 
    	
		Parametro par = new Parametro(nombre, informacion);
		par.save();		
		redirect("/parametros");
	}
    public static void eliminarParametro(Long idParam) {
		Parametro eliminar = Parametro.findById(idParam);		
		try {
			eliminar.delete();
			flash.success("No Error.");
			//msg="Se elimino correctamente";
		} catch (Exception e) {
			e.printStackTrace();
			flash.success("Error.");
			//msg="No se ha podido eliminar";
		}		
		redirect("/parametros");
	}      
}
