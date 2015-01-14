package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Resultado_Item extends Model {
	public int calificacion;
	@ManyToOne
	public Resultado resultado;
	@ManyToOne
	public Item item;
	
	
	
	public Resultado_Item(Resultado r, Item i, int c){
		this.resultado=r;
		this.item=i;
		this.calificacion=c;
		
	}
    
}
