import java.util.ArrayList;

public class ListaAsignaturas{
    private int size;

    public ArrayList <Materia> ListaAsignaturas = new ArrayList<>();

    public void addAsignatura(Materia Materia){
        ListaAsignaturas.add(Materia);
        this.size++;
        }
    
    public ArrayList <Materia> getListaAsignaturas(){
        return ListaAsignaturas;
    } 
    public int getSize(){
        return this.size;
    }
}