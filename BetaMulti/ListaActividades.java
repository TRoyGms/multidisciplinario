import java.util.ArrayList;

public class ListaActividades {
    private int size = 0;
    private ArrayList<Actividad> listaActividades;

    public ListaActividades() {
        this.listaActividades = new ArrayList<>();
    }

    public void addActividad(Actividad actividad) {
        listaActividades.add(actividad);
        this.size++;
    }

    public ArrayList<Actividad> getListaActividades() {
        return listaActividades;
    }

    public int getSize() {
        return this.size;
    }

    public void removeAt(int index) {
        if (index >= 0 && index < listaActividades.size()) {
            listaActividades.remove(index);
            this.size--;
        }
    }

    public Actividad buscarActividad(String nombreActividad) {
        // Iterar sobre la lista de actividades y buscar la actividad por su nombre
        for (Actividad actividad : listaActividades) {
            if (actividad.getNombreAct().equals(nombreActividad)) {
                return actividad; // Devolver la actividad si se encuentra
            }
        }
        return null; // Devolver null si la actividad no se encuentra
    }
}
