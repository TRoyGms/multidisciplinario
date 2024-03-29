import java.util.ArrayList;

public class ListaActividades{
    private int size;

   public ArrayList <Actividad> listaActividades = new ArrayList<>();

    public void addActividad(Actividad actividad){
        listaActividades.add(actividad);
        this.size++;
        }
    
    public ArrayList <Actividad> getListaActividades(){
        return listaActividades;
    }
    public int getSize(){
        return this.size;
    }
    public void removeAt(int index){
        listaActividades.remove(index);
    }
}