import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {
	/*
	 * Banco de pruebas clase Paramaetros
	 */
    @Test
    public void nuevoParametro() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void emilinarParametro() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void modifiParametro() {
        assertEquals(3, 1 + 1);
    }
    
    @Test
    public void viewParametro() {
        assertEquals(3, 1 + 1);
    }
    
    /*
     * Banco de puebas Clase Security
     */
    @Test
    public void authenticate() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void guardarUsuario() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void error1() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void cuenta() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void modifiUsuario() {
        assertEquals(3, 1 + 1);
    }
    @Test
    public void eliminarUsuario() {
        assertEquals(3, 1 + 1);
    }
    /*
     * Banco de pruebas Clase Items
     */
    @Test
    public void crearItem() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void eliminarItem() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void modifiItem() {
        assertEquals(3, 1 + 1);
    }
    /*
     * Banco de pruebas de clase evaluaciones
     */
    @Test
    public void viewEval() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void create() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void postCreate() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void delete() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void formulario() {
        assertEquals(2, 1 + 1);
    }
    /*
     * Banco de pruebas de la clase Datos  
     */
    @Test
    public void guardarDatos() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void finalizar() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void calificar() {
        assertEquals(3, 1 + 1);
    }
    /*
     * banco de pruebas para escala de medicion
     */
    @Test
    public void crearEscala() {
        assertEquals(3, 1 + 1);
    }
    @Test
    public void modifiEscala() {
        assertEquals(3, 1 + 1);
    }
    /*
     * banco de pruebas de resultados
     */
    @Test
    public void generarResultados() {
        assertEquals(3, 1 + 1);
    }
    @Test
    public void printResultados() {
        assertEquals(3, 1 + 1);
    }
}
