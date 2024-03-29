import java.util.ArrayList;

public class ListaAlumnos{
    private int size=0;

   public ArrayList <Alumno> listaAlumnos = new ArrayList<>();

    public void addAlumno(Alumno Alumno){
        listaAlumnos.add(Alumno);
        this.size++;
    }
    
    public ArrayList <Alumno> getListaAlumnos(){
        return listaAlumnos;
    }
    public int getSize(){
        return this.size;
    }
    public void remove(int index){
        listaAlumnos.remove(index);

    }
}