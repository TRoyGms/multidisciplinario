import java.util.ArrayList;

public class ListaAsignaturas {
    private int size;
    private ArrayList<Materia> listaAsignaturas;

    public ListaAsignaturas() {
        this.size = 0;
        this.listaAsignaturas = new ArrayList<>();
    }

    public void addAsignatura(Materia materia) {
        listaAsignaturas.add(materia);
        this.size++;
    }

    public ArrayList<Materia> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public int getSize() {
        return this.size;
    }

    public void removeAt(int i) {
        if (i >= 0 && i < listaAsignaturas.size()) {
            listaAsignaturas.remove(i);
            this.size--;
        }
    }

    public Materia buscarAsignatura(String nombreAsignatura) {
        // Iterar sobre la lista de asignaturas y buscar la asignatura por su nombre
        for (Materia materia : listaAsignaturas) {
            if (materia.getNombre().equals(nombreAsignatura)) {
                return materia; // Devolver la asignatura si se encuentra
            }
        }

        return null; // Devolver null si la asignatura no se encuentra
    }
}
