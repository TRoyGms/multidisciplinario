import java.util.ArrayList;

public class ListaUsuarios {

    public ArrayList <Usuario> ListaUsuarios = new ArrayList<>();

    public void addUser(Usuario usuario){
        ListaUsuarios.add(usuario);
        }
    
    public ArrayList <Usuario> getUserList(){
        return ListaUsuarios;
    }


}
