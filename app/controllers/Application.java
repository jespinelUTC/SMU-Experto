package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import org.junit.Before;

import controllers.Securing.Security;
import models.*;


public class Application extends Controller {
	


    public static void index() {
    	//obteniendo datos del usuario que ha iniciado sesion
    			if(Security.isConnected()) {
    	            Usuario user = Usuario.find("byEmail", Security.connected()).first();
    	            renderArgs.put("user", user.nombre+" "+user.apellido);
    	        }
    	
    	
        render();
    }
    
    public static void slider() { 	
        render();
    }

}