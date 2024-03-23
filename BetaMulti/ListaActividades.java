import java.util.ArrayList;

public class ListaActividades{
    private int size;

   public ArrayList <Actividad> ListaActividades = new ArrayList<>();

    public void addActividad(Actividad actividad){
        ListaActividades.add(actividad);
        this.size++;
        }
    
    public ArrayList <Actividad> getListaActividades(){
        return ListaActividades;
    }
    public int getSize(){
        return this.size;
    }
}