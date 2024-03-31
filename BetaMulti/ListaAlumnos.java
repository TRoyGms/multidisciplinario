import java.util.ArrayList;

public class ListaAlumnos {
    private int size = 0;
    private ArrayList<Alumno> listaAlumnos;

    public ListaAlumnos() {
        this.listaAlumnos = new ArrayList<>();
    }

    public void addAlumno(Alumno alumno) {
        listaAlumnos.add(alumno);
        this.size++;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public int getSize() {
        return this.size;
    }

    public void remove(int index) {
        if (index >= 0 && index < listaAlumnos.size()) {
            listaAlumnos.remove(index);
            this.size--;
        }
    }

    public Alumno buscarAlumno(String nombreAlumno) {
        // Iterar sobre la lista de alumnos y buscar el alumno por su nombre
        for (Alumno alumno : listaAlumnos) {
            if (alumno.getNombre().equals(nombreAlumno)) {
                return alumno; // Devolver el alumno si se encuentra
            }
        }
        return null; // Devolver null si el alumno no se encuentra
    }
}
