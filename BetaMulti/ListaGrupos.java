import java.util.ArrayList;
public class ListaGrupos{

    public ArrayList <Grupo> ListaGrupos = new ArrayList<>();

    private int size;
    public void addGrupo(Grupo grupo){
        ListaGrupos.add(grupo);
        this.size++;
        }
    
    public ArrayList <Grupo> getListaGrupos(){
        return ListaGrupos;
    } 
    public int getSize(){
        return this.size;
    }
}