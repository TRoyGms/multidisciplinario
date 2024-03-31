import java.util.ArrayList;

public class Materia {
    private String nombre;
    private ArrayList<Grupo> grupos;
    private ArrayList<Actividad> actividades;

    public Materia(String nombreAsignatura) {
        this.nombre = nombreAsignatura; // Inicializar el nombre de la asignatura
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreAsignatura() {
        return this.nombre;
    }

    public void addGrupo(Grupo grupo) {
        if (this.grupos == null) {
            this.grupos = new ArrayList<>(); // Inicializar la lista de grupos si es nula
        }
        this.grupos.add(grupo);
    }

    public Grupo buscarGrupo(String nombreGrupo) {
        for (Grupo grupo : this.grupos) {
            if (grupo.getNombre().equals(nombreGrupo)) {
                return grupo;
            }
        }
        return null;
    }

    public void removeGrupo(Grupo grupo) {
        this.grupos.remove(grupo);
    }

    public void addActividad(Actividad actividad) {
        this.actividades.add(actividad);
    }

    public Actividad buscarActividad(String nombreActividad) {
        for (Actividad actividad : this.actividades) {
            if (actividad.getNombreAct().equals(nombreActividad)) {
                return actividad;
            }
        }
        return null;
    }

    public void removeActividad(Actividad actividad) {
        this.actividades.remove(actividad);
    }
}