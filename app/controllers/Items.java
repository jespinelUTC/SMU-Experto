package controllers;

import java.util.List;

import javax.persistence.Query;

import models.Item;
import models.Parametro;
import play.db.jpa.JPA;
import play.mvc.*;

public class Items extends Controller {
	
    public static void index(Long idParametro ) {
    	Query query = JPA.em().createQuery("select * from item where parametro_id="+idParametro);
        Parametro par= Parametro.findById(idParametro);
    	//User.find(“byUsername”, usr).first();
    	List <Item> it = query.getResultList();
    	System.out.print("La consulta"+it);
        render(par);
    }
    public static void crearItem(Long idItem) {
		render(idItem);
	}

}
