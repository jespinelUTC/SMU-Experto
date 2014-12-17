package controllers;

import java.util.List;

import models.Parametro;
import play.mvc.*;

public class Parametros extends Controller {
		
    public static void index() {
    	List<Parametro> par =Parametro.findAll();
        render(par);
    }
    /*
     * Metodo para la creacion de un Nuevo Parametro
     */
    public static void nuevoParametro(String nombre, String informacion) {
		Parametro par = new Parametro(nombre, informacion);
		par.save();		
		index();
	}
    public static void eliminarParametro(Long idParam) {
		Parametro eliminar = Parametro.findById(idParam);
		String msg;
		try {
			eliminar.delete();
			msg="Se elimino correctamente";
		} catch (Exception e) {
			e.printStackTrace();
			msg="No se ha podido eliminar";
		}		
		index(msg);
	}
    public static void index(String msg) {
    	List<Parametro> par =Parametro.findAll();
		render(msg,par);
	}
}
