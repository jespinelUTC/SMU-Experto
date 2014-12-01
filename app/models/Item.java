package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Item extends Model {
	public String pregunta;
	@ManyToOne
	public Parametro parametro;
	public Item(String pregunta, Parametro parametro) {
		super();
		this.pregunta = pregunta;
		this.parametro=parametro;
	}
}
