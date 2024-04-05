import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String apellidos;
    private int num_lista;
    private List<Actividad> actividades = new ArrayList<Actividad>();
    private int sizeActs;

    public Alumno(){}

    public List<Actividad> getActividad() {return actividades;}
    
    public void setActividad(Actividad actividad) {
        this.actividades.add(actividad);
        this.sizeActs++;
    }

    public int getsizeAct(){
        return this.sizeActs;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellidos() {return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}

    public int getnumLista() {return num_lista;}
    public void setnumLista(int num_lista) { this.num_lista = num_lista;} 
}   