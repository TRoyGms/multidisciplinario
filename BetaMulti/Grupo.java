import java.util.ArrayList;

public class Grupo {
    private String nombre;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Actividad> actEnGrupo;
    private int sizeG = 0;
    private int actSize;

    public int getActSize(){
        return this.actSize;
    }

    public void addActividadG(Actividad tarea){
        if(actEnGrupo == null){
            this.actEnGrupo.add(tarea);
            this.actSize++;
        }else{
            for(int i =0;i<getActSize();i++){
                if((tarea.getNombreAct()).equals(getActividadenG().get(i).getNombreAct())){           
                    System.out.println("La actividad ya existe en este grupo");
                }else{
                    this.actEnGrupo.add(tarea);
                    this.actSize--;
                }
            }
        }
    }

    public void removeActG(int index){
        actEnGrupo.remove(index);
        this.actSize--;  
    }

    public ArrayList<Actividad> getActividadenG(){
        return this.actEnGrupo;
    }

    public Grupo(String nombreGrupo) {
        this.nombre = nombreGrupo;
        this.alumnos = new ArrayList<>(); // Inicializar la lista de alumnos
        this.actEnGrupo = new ArrayList<>();
    }

    public int getSizeG(){
        return this.sizeG;
    }

    public ArrayList<Alumno> getAlumnos() {
        return this.alumnos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addAlumno(Alumno alumno) {
        if (alumnos == null) {
            alumnos = new ArrayList<>();
        }
        if (!alumnos.contains(alumno)) {
            this.alumnos.add(alumno);
            this.sizeG++;
        } else {
            System.out.println("El alumno ya está en el grupo.");
        }
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
        this.sizeG--;
    }
    
}