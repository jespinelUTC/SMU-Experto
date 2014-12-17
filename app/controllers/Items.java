package controllers;

import java.util.List;

import models.Item;
import models.Parametro;
import play.mvc.*;

public class Items extends Controller {
	
    public static void index(Long idParametro ) {
    	Parametro par= Parametro.findById(idParametro);
    	//User.find(“byUsername”, usr).first();
    	//List<Item> itms =Item.findAll();    	
    	List <Item> itms= Item.find("parametro_id= ?", idParametro).fetch();    	
        render(par,itms);
    }
    public static void crearItem(Long idParam,String pregunta) {
    	Parametro p =  Parametro.findById(idParam); 
    	Item nuevo = new Item(pregunta, p);
    	nuevo.save();
		index(idParam);
	}
    public static void eliminarItem(Long idItem) {
		Item borrado= Item.findById(idItem); 
		Long aux = borrado.parametro.id;
		borrado.delete();
		index(aux);
	}
}
