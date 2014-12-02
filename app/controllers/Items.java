package controllers;

import java.util.List;

import javax.persistence.Query;

import models.Item;
import models.Parametro;
import play.db.jpa.JPA;
import play.mvc.*;

public class Items extends Controller {
	
    public static void index(Long idParametro ) {
    	Parametro par= Parametro.findById(idParametro);
    	//User.find(“byUsername”, usr).first();
    	
    	List <Item> it= Item.find(" parametro_id= ?", idParametro).fetch();   
        render(par,it);
    }
    public static void crearItem(Long idItem) {
		render(idItem);
	}

}
