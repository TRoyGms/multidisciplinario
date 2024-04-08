import java.util.ArrayList;

public class Materia {
    private String nombre;
    private ArrayList<Grupo> grupos;
    private ArrayList<Actividad> actividades;


    public Materia(String nombreAsignatura) {
        this.nombre = nombreAsignatura;       // Inicializar el nombre de la asignatura
        this.grupos = new ArrayList<>();      // Inicializar la lista de grupos
        this.actividades = new ArrayList<>(); // Inicializar la lista de actividades
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreAsignatura() {
        return this.nombre;
    }

    public void addGrupo(Grupo grupo) {
        if (grupos == null) {
            grupos = new ArrayList<>();
        }
        // Verificar si el grupo ya está presente en la asignatura
        if (!grupos.contains(grupo)) {
            this.grupos.add(grupo);
        } else {
            System.out.println("El grupo ya está en la asignatura.");
        }
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
        if (this.actividades == null) {
            this.actividades = new ArrayList<>(); // Inicializar la lista de actividades si es nula
        }
        this.actividades.add(actividad);
    }

    public ArrayList<Actividad> getListaActividades() {
        return this.actividades;
    }

    public ArrayList<Grupo> getListaGrupos() {
        return this.grupos;
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