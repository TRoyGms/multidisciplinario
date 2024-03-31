import java.util.ArrayList;

public class ListaGrupos {
    private ArrayList<Grupo> listaGrupos;
    private int size;

    public ListaGrupos() {
        this.listaGrupos = new ArrayList<>();
        this.size = 0;
    }

    public void addGrupo(Grupo grupo) {
        listaGrupos.add(grupo);
        this.size++;
    }

    public ArrayList<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    public int getSize() {
        return this.size;
    }

    public void removeAt(int i) {
        if (i >= 0 && i < listaGrupos.size()) {
            listaGrupos.remove(i);
            this.size--;
        }
    }

    public Grupo buscarGrupo(String nombreGrupo) {
        for (Grupo grupo : listaGrupos) {
            if (grupo.getNombre().equals(nombreGrupo)) {
                return grupo; // Devolver el grupo si se encuentra
            }
        }
        return null; // Devolver null si el grupo no se encuentra
    }
}
