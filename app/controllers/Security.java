package controllers;

import models.Usuario;
import play.mvc.With;

public class Security extends Securing.Security {

	static boolean authenticate(String username, String password) {
		Usuario user = Usuario.find("byEmail", username).first();

		return user != null && user.password.equals(password);
	}

	public static void guardarUsuario(String email, String nombre,
			String apellido, String password) throws Throwable {
			Usuario usuario=Usuario.find("byEmail",email).first();
		if(usuario==null){
			Usuario u = new Usuario(email, nombre, apellido, password);
			u.save();
			flash("confirmacion", "Bienvenid@ "+nombre+" ya puede evaluar aplicaciones.");
			Securing.authenticate(email, password, true);
			
			
		}else{
			flash("repetido", "No se pudo crear la cuenta, intente con otra dirección de Email");
			redirect("/login");
		}
		
		
	}

	
	public static void modificarUsuario(String nombre,String apellido,String password, String passwordNuevo) throws Throwable{
		
		 Usuario user1 = Usuario.find("byEmail", Security.connected()).first();
		 if(password.equals(user1.password)){
			 user1.nombre=nombre;
			 user1.apellido=apellido;
			 user1.password=passwordNuevo;
			 user1.save();
			 flash("confirmacion","Datos Actualizados Exitosamente");
		 }else{
			 flash("error","Contraseña Incorrecta - No se pudo Actualizar");
		 }
		redirect("/cuenta");
	}
	
	


	// error para email existente
	public static void error1(String mail) {
		Usuario user = Usuario.find("byEmail", mail).first();
		String mensaje;
		if (user != null) {
			mensaje = "ERROR: EMAIL YA UTILIZADO";
			render(mensaje);
		} else {
			render();
		}

	}

	public static void cuenta() {
		Usuario user1 = Usuario.find("byEmail", Security.connected()).first();
		// obteniendo datos del usuario que ha iniciado sesion
		if (Security.isConnected()) {

			renderArgs.put("user", user1.nombre + " " + user1.apellido);
		}

		render(user1);
	}

}
