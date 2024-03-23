import java.util.ArrayList;

public class ListaAlumnos{
    private int size;

   public ArrayList <Alumno> listaAlumnos = new ArrayList<>();

    public void addAsignatura(Alumno Alumno){
        listaAlumnos.add(Alumno);
        this.size++;
    }
    
    public ArrayList <Alumno> getListaAlumnos(){
        return listaAlumnos;
    }
    public int getSize(){
        return this.size;
    }
}