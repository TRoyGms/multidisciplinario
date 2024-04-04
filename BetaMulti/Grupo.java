import java.util.ArrayList;

public class Grupo {
    private String nombre;
    private ArrayList<Alumno> alumnos;

    public Grupo(String nombreGrupo) {
        this.nombre = nombreGrupo;
        this.alumnos = new ArrayList<>(); // Inicializar la lista de alumnos
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addAlumno(Alumno alumno) {
        if (this.alumnos == null) {
            this.alumnos = new ArrayList<>(); // Inicializar la lista de alumnos si es nula
        }
        this.alumnos.add(alumno);
    }

    public Alumno buscarAlumno(String nombreAlumno) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equals(nombreAlumno)) {
                return alumno; // Devuelve el alumno si se encuentra
            }
        }
        return null; // Devuelve null si el alumno no se encuentra
    }

    public void removeAlumno(Alumno alumno) {
        this.alumnos.remove(alumno); // Elimina el alumno de la lista
    }
}