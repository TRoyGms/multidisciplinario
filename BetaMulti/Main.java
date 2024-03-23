import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Variables globales
    private static ListaAsignaturas listaMaterias = new ListaAsignaturas();
    private static ListaGrupos listaGrupos = new ListaGrupos();
    private static ListaAlumnos listaAlumnos = new ListaAlumnos();
    private static ListaActividades listaActividades = new ListaActividades();

    public static void main(String[] args) {
        crearObjetos();
    }

    public static void crearObjetos() {
        Scanner entrada = new Scanner(System.in);

        Maestro Maestra = new Maestro("Berenice", "db3101");
        Usuario Administradora = new Admin("Administradora", "0000");

        ListaUsuarios userList = new ListaUsuarios();
        userList.addUser(Maestra);
        userList.addUser(Administradora);

        ListaAsignaturas listaMaterias = new ListaAsignaturas();
        ListaGrupos listaGrupos = new ListaGrupos();
        ListaAlumnos listaAlumnos = new ListaAlumnos();
        ListaActividades listaActividades = new ListaActividades();

        choose_user(userList, listaMaterias, listaGrupos, listaAlumnos, listaActividades);
    }

    public static void choose_user(ListaUsuarios userList, ListaAsignaturas listaMaterias, ListaGrupos listaGrupos, ListaAlumnos listaAlumnos, ListaActividades listaActividades) {
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            System.out.println("Seleccione un perfil\n1.Profesora\n2.Administradora.");
            option = entrada.nextInt();
            if (option == 1) {
                loginTeacher(userList, listaMaterias, listaGrupos, listaAlumnos, listaActividades);

            } else {
                loginAdmin(userList, listaMaterias, listaGrupos, listaAlumnos, listaActividades);
            }
        } while (option < 1 || option > 2);
    }

    public static void loginTeacher(ListaUsuarios userList, ListaAsignaturas listaMaterias, ListaGrupos listaGrupos, ListaAlumnos listaAlumnos, ListaActividades listaActividades) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenida Profesora Berenice \nIngrese su contraseña");
        String password = entrada.nextLine();
        if (userList.getUserList().get(0).login("Berenice", password)) {
            VerTeacherMenu();
        }
    }

    public static void loginAdmin(ListaUsuarios userList, ListaAsignaturas listaMaterias, ListaGrupos listaGrupos, ListaAlumnos listaAlumnos, ListaActividades listaActividades) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bienvenida Administradora \nIngrese su contraseña");
        String password = entrada.nextLine();
        if (userList.getUserList().get(1).login("Administradora", password)) {
            VerAdminMenu();
        }
    }
    public static void VerTeacherMenu() {
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            // Imprime el menú para la profesora
            System.out.println("Menú para Profesora Berenice");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("0. Salir");
    
            option = entrada.nextInt();
    
            switch (option) {
                case 1:
                    // Implementación de la opción 1
                    break;
                case 2:
                    // Implementación de la opción 2
                    break;
                case 0:
                    System.out.println("Saliendo del menú para Profesora Berenice...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (option != 0);
    }
    public static void VerAdminMenu(){
        Scanner entrada = new Scanner(System.in);
        int option;
        do{
            System.out.println("Seleccione una opcion, ya sea para Crear, Editar o Eliminar\n\n1.Asignautra \n2.Grupos\n3.Alumnos\n4.Actividades.");
            option=entrada.nextInt();
            switch(option){
                case 1:VerMenuAsignatura(listaMaterias, listaGrupos, listaActividades);
                break;
                case 2:VerMenuGrupos(listaGrupos, listaAlumnos);
                break;
                case 3: VerMenuAlumnos(listaAlumnos);
                break;
                case 4:VerMenuActividades(listaActividades);
                break;
                case 0:
                System.out.println("Saliendo del menú para Administradora...");
                break;
            default:
                System.out.println("Opción inválida. Inténtelo de nuevo.");
        }
    } while (option != 0);
}
                                                                        //opcion 1         <<<< ASIGNATURA
    public static void VerMenuAsignatura(ListaAsignaturas listaMaterias, ListaGrupos listaGrupos, ListaActividades listaActividades){
        Scanner entrada = new Scanner(System.in);
        int option;
        do{
           // System.out.println()            <<<<<<         //Imprimir array de Asignaturas existentes
            System.out.println("Seleccione una opcion \n1.Crear nueva Asignatura \n2.Editar nombre de una asignatura existente \n3.Eliminar una asignatura existente \n4.Agregar grupo a la Asignatura \n5. Eliminar grupo de la asignatura");
            option = entrada.nextInt();
        switch(option){
                case 1: CrearNuevaAsignatura(listaMaterias);
                break;
                case 2: EditarNombreAsignatura(listaMaterias);
                break;
                case 3: EliminarAsignatura(listaMaterias);
                break;
                case 4: AgregarGrupo(listaGrupos, listaMaterias);
                break;
                case 5: EliminarGrupoenAsignatura(listaMaterias, listaGrupos);
                break;
                case 6: AgregarActividadenAsignatura(listaMaterias, listaActividades);
                break;
                case 7: EliminarActividadenAsignatura(listaMaterias, listaActividades);
            }       
        }while(option < 1 || option > 7);
    }
                                                                        //OPCION 2      <<<<<     GRUPOS
    public static void VerMenuGrupos(ListaGrupos listaGrupos, ListaAlumnos listaAlumnos){
        Scanner entrada = new Scanner(System.in);
        int option;
          do{
           // System.out.println()            <<<<<<         //Imprimir array de GRUPOS
            System.out.println("Seleccione una opcion \n1.Crear nuevo Grupo \n2.Editar nombre de un grupo existente \n3.Eliminar grupo existente \n4.Agregar Alumnos existentes \n5. Eliminar Alumno del grupo");
            option = entrada.nextInt();
        switch(option){
                case 1:CrearNuevoGrupo(listaGrupos);
                break;
                case 2:EditarNombreGrupo( listaGrupos);
                break;
                case 3: EliminarGrupo(listaGrupos);
                break;
                case 4:AgregarAlumnoaGrupo( listaGrupos);
                break;
                case 5:EliminarAlumnodelGrupo(listaGrupos, listaAlumnos);
            }       
        }while(option < 1 || option > 5);
    }

                                                                     //OPCION 3      <<<<<     ALUMNOS
    public static void VerMenuAlumnos(ListaAlumnos listaAlumnos){
        Scanner entrada = new Scanner(System.in);
        int option;
        do{
           // System.out.println()            <<<<<<         //Imprimir array de ALUMNOS
            System.out.println("Seleccione una opcion \n1.Crear nuevo Alumno \n2.Editar nombre de Alumno \3.Eliminar Alumno");
            option = entrada.nextInt();
        switch(option){
                case 1:CrearAlumno(listaAlumnos);
                break;
                case 2:EditarAlumno(listaAlumnos);
                break;
                case 3: EliminarAlumno(listaAlumnos);
            }       
        }while(option < 1 || option > 3);

    }

                                                                     //OPCION 4      <<<<<     ACTIVIDADES
    public static void VerMenuActividades(ListaActividades listaActividades){
        Scanner entrada = new Scanner(System.in);
        int option;
        do{
           // System.out.println()            <<<<<<         //Imprimir array de ACTIVIDADES

            System.out.println("Seleccione una opcion \n1.Crear nueva Asignatura \n2.Editar nombre de una asignatura existente \3.Eliminar una asignatura existente");
            option = entrada.nextInt();
        switch(option){
                case 1:CrearActividad(listaActividades);
                break;
                case 2:EditarActividad(listaActividades);
                break;
                case 3: EliminarActividad(listaActividades);
            }       
        }while(option < 1 || option > 3);
    }


    public static void CrearNuevaAsignatura(ListaAsignaturas listaAsignaturas){
        Scanner entrada = new Scanner(System.in);
        String groupName;
        int ans;
        do{
            System.out.println("Ingrese nombre del Grupo");   
            groupName = entrada.nextLine();   
    ////        //busqueda secuencial 
            boolean flag = buscarAsignatura(groupName, listaAsignaturas);  
            System.out.println("¿Desea crear una nueva asignatura? \n1. Si \n2. Volver al menú principal");
            ans = entrada.nextInt();
        }while(ans == 1);
        VerAdminMenu();

    }

    public static void EditarNombreAsignatura(ListaAsignaturas listaAsignaturas){

    }
    public static void EliminarAsignatura(ListaAsignaturas listaAsignaturas){

    }
    public static void AgregarGrupo( ListaGrupos listaGrupos, ListaAsignaturas listaAsignaturas){

    }
    public static void EliminarGrupoenAsignatura(ListaAsignaturas listaAsignaturas, ListaGrupos listaGrupos){

    }
    public static void AgregarActividadenAsignatura(ListaAsignaturas listaAsignaturas, ListaActividades listaActividades){

    }
    public static void EliminarActividadenAsignatura(ListaAsignaturas listaAsignaturas, ListaActividades listaActividades){

    }
    public static void CrearNuevoGrupo(ListaGrupos listaGrupos){

    }
    public static void EditarNombreGrupo(ListaGrupos listaGrupos){

    }
    public static void EliminarGrupo(ListaGrupos listaGrupos){

    }
    public static void AgregarAlumnoaGrupo(ListaGrupos listaGrupos){

    }
    public static void EliminarAlumnodelGrupo(ListaGrupos listaGrupos, ListaAlumnos listaAlumnos){

    }
    public static void CrearAlumno( ListaAlumnos listaAlumnos){

    }
    public static void EditarAlumno(ListaAlumnos listaAlumnos){

    }
    public static void EliminarAlumno(ListaAlumnos listaAlumnos){

    }
    public static void CrearActividad(ListaActividades listaActividades){

    }  
    public static void EditarActividad(ListaActividades listaActividades){

    }
   
    public static void EliminarActividad(ListaActividades listaActividades){

    }
    public static boolean buscarAsignatura(String nombreMateria, ListaAsignaturas listaAsignaturas){
        boolean flag=false;
        for(int i=0; i<listaAsignaturas.getSize();i++){
            if ( nombreMateria.equals(listaAsignaturas.getListaAsignaturas().get(0).getNombre())){
                flag = true;
            }
        }
        return flag;
    }
    public static boolean buscarGrupo(ListaGrupos listaGrupos, String nombreGrupo){
        boolean flag=false;
        for(int i=0; i<listaGrupos.getSize();i++){
            if ( nombreGrupo.equals(listaGrupos.getListaGrupos().get(0).getNombre())){
                flag = true;
            }
        }
        return flag;

    }
    public static boolean buscarAlumno(ListaAlumnos listaAlumnos, String nombreAlumno){
        boolean flag=false;
        for(int i=0; i<listaAlumnos.getSize();i++){
            if ( nombreAlumno.equals(listaAlumnos.getListaAlumnos().get(0).getNombre())){
                flag = true;
            }
        }
        return flag;

    }
    public static boolean buscarActividad(ListaActividades listaActividades, String nombreActividad){
        boolean flag=false;
        for(int i=0; i<listaActividades.getSize();i++){
            if ( nombreActividad.equals(listaActividades.getListaActividades().get(0).getNombre())){
                flag = true;
            }
        }
        return flag;

    }

}