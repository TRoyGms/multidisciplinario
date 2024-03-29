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
        Admin Administradora = new Admin("Administradora", "fz1607");

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
            System.out.println("Seleccione una opcion \n1.Crear nuevo Alumno \n2.Editar nombre de Alumno \n3.Eliminar Alumno\n4. Atras");
            option = entrada.nextInt();
        switch(option){
                case 1:CrearAlumno(listaAlumnos);
                break;
                case 2:EditarAlumno(listaAlumnos);
                break;
                case 3: EliminarAlumno(listaAlumnos);
                break;
                case 4:VerAdminMenu();
            }       
        }while(option < 1 || option > 4);
    }

    public static void CrearAlumno( ListaAlumnos listaAlumnos){
        Scanner entrada = new Scanner(System.in);       
        if(listaAlumnos.getSize()==0){
            Alumno alumno = new Alumno();
            System.out.println("Ingrese Nombre(s) del alumno");
            String nombre = entrada.nextLine();
            System.out.println("Ingrese apellidos");
            String apellidos = entrada.nextLine();
            System.out.println("Ingrese numero de lista");
            int num_lista = entrada.nextInt(); 
            alumno.setNombre(nombre);
            alumno.setApellidos(apellidos);
            alumno.setnumLista(num_lista);
            listaAlumnos.addAlumno(alumno);
            VerMenuAlumnos(listaAlumnos);
        }else{
            int opcion;
            System.out.println("Ingrese Nombre(s) del alumno");
            String nombre = entrada.nextLine();
            for(int i=0; i<listaAlumnos.getSize(); i++){
                if(nombre.equals(listaAlumnos.getListaAlumnos().get(i).getNombre())){
                    System.out.println("Ya existe un alumno con nombre(s): '"+nombre+"'', sus apellidos son: '"+listaAlumnos.getListaAlumnos().get(i).getApellidos()+"'");
                    System.out.println("Y numero de lista "+listaAlumnos.getListaAlumnos().get(i).getnumLista());
                    do{
                        System.out.println("Desea crear nuevo alumno con el mismo nombre y diferentes apellidos o numero de lista? \n1.Si \n2.No");
                        opcion=entrada.nextInt();
                        if (opcion==1){
                        Alumno alumno = new Alumno();
                        System.out.println("Ingrese Apellidos de "+nombre);
                        String apellidos = entrada.nextLine();
                        System.out.println("Ingrese numero de lista para "+nombre+" "+apellidos);
                        int num_lista = entrada.nextInt();
                        alumno.setNombre(nombre);
                        alumno.setApellidos(apellidos);
                        alumno.setnumLista(num_lista);
                        listaAlumnos.addAlumno(alumno);
                    }
                }while(opcion<1 || opcion>2);
                }
            }
        }VerMenuAlumnos(listaAlumnos);
    }
    public static void EditarAlumno(ListaAlumnos listaAlumnos){
        Scanner entrada = new Scanner(System.in);
        String name;
        if (listaAlumnos.getSize()==0) {
            System.out.println("Aun no existen alumnos, redirigiendo a crear nuevo alumno");
            CrearAlumno(listaAlumnos);            
        }else{
            System.out.println("Lista de alumnos existentes en la base de datos: \n"+listaAlumnos.getListaAlumnos());
            System.out.println("Ingrese nombre del alumno a editar");
            name= entrada.nextLine();
            for(int i=0;i<listaAlumnos.getSize();i++){
                if (name.equals(listaAlumnos.getListaAlumnos().get(i).getNombre())) {
                    System.out.println("Ingrese nuevo(s) nombre(s) del alumno");
                    name = entrada.nextLine();
                    System.out.println("Ingrese nuevos apellidos para "+name);
                    String apellidos= entrada.nextLine();
                    System.out.println("Ingrese nuevo numero de lista para: "+name+" "+apellidos);  
                    int num_lista= entrada.nextInt();
                    listaAlumnos.getListaAlumnos().get(i).setNombre(name);     
                    listaAlumnos.getListaAlumnos().get(i).setApellidos(apellidos);
                    listaAlumnos.getListaAlumnos().get(i).setnumLista(num_lista);          
                }
            }VerAdminMenu();
        }
    }
    public static void EliminarAlumno(ListaAlumnos listaAlumnos){
        Scanner entrada = new Scanner(System.in);
        String name;
        int opcion;
        if (listaAlumnos.getSize()==0) {
            System.out.println("Aun no existen alumnos, redirigiendo a crear nuevo alumno");
            CrearAlumno(listaAlumnos);            
        }else{
            System.out.println("Lista de alumnos existentes en la base de datos: \n"+listaAlumnos.getListaAlumnos());
            System.out.println("Ingrese nombre del alumno a eliminar");
            name= entrada.nextLine();
            for(int i=0;i<listaAlumnos.getSize();i++){
                if (name.equals(listaAlumnos.getListaAlumnos().get(i).getNombre())) {
                    do{
                        System.out.println("Esta segura de eliminar al alumno: "+listaAlumnos.getListaAlumnos().get(i)+"? \n1.SI \n2.NO");
                        opcion=entrada.nextInt();
                        if (opcion==1) {
                            listaAlumnos.remove(i);                            
                        }
                    }while(opcion<1 || opcion >2);
                }
            }  
        }VerAdminMenu();
    }

                                                                     //OPCION 4      <<<<<     ACTIVIDADES
    public static void VerMenuActividades(ListaActividades listaActividades){
        Scanner entrada = new Scanner(System.in);
        int option;
        do{
            for(int i=0;i<listaActividades.getSize();i++){
                System.out.println(listaActividades.getListaActividades().get(i).getNombreAct()+"\n");
            }
            System.out.println("Seleccione una opcion \n1.Crear nueva Asignatura \n2.Editar nombre de una asignatura existente \3.Eliminar una asignatura existente\n4. Menú principal");
            option = entrada.nextInt();
        switch(option){
                case 1:CrearActividad(listaActividades);
                break;
                case 2:EditarActividad(listaActividades);
                break;
                case 3: EliminarActividad(listaActividades);
                break;
                case 4:VerAdminMenu();
            }       
        }while(option < 1 || option > 4);
    }
    public static void CrearActividad(ListaActividades listaActividades){
        Scanner entrada = new Scanner(System.in);
        if (listaActividades.getSize()==0) {
            Actividad actividad = new Actividad();
            System.out.println("Ingrese nombre de la actividad");
            String name = entrada.nextLine();
            actividad.setNombreAct(name);
            listaActividades.addActividad(actividad);      
        }else{
            System.out.println("Ingrese nombre de la actividad");
            String name = entrada.nextLine();
            for(int i=0; i<listaActividades.getSize();i++){
                if(name.equals(listaActividades.getListaActividades().get(i).getNombreAct())){
                    int opcion;
                    System.out.println("Ya existe una actividad llamada: "+name);
                    do{
                        System.out.println("Seleccione una opcion\n1.Menu actividades \n2.Menu principal");
                        opcion=entrada.nextInt();
                        if(opcion==1){
                            VerMenuActividades(listaActividades);
                        }else{
                            VerAdminMenu();
                        }
                    }while(opcion<1 || opcion > 2);
                }else{
                    Actividad actividad = new Actividad();
                    actividad.setNombreAct(name);
                    listaActividades.addActividad(actividad);
                }
            }
        }VerMenuActividades(listaActividades);
    }  
    public static void EditarActividad(ListaActividades listaActividades){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        for(int i=0;i<listaActividades.getSize();i++){
            System.out.println((i+1)+": "+listaActividades.getListaActividades().get(i).getNombreAct()+"\n");
        }
        do{
            System.out.println("Seleccione el numero de la actividad a editar");
            opcion = entrada.nextInt();
            opcion--;
            System.out.println("Ingrese nuevo nombre para la actividad: "+listaActividades.getListaActividades().get(opcion).getNombreAct());
            String newname=entrada.nextLine();
            listaActividades.getListaActividades().get(opcion).setNombreAct(newname);
        }while(opcion<1 || opcion>listaActividades.getSize()+1);
        VerMenuActividades(listaActividades);
    }
    public static void EliminarActividad(ListaActividades listaActividades){
        Scanner entrada = new Scanner(System.in);
        int actaeliminar;

        for(int i=0;i<listaActividades.getSize();i++){
            System.out.println((i+1)+listaActividades.getListaActividades().get(i).getNombreAct()+"\n");
        }
        System.out.println("Seleccione el numero de la actividad a eliminar");
        actaeliminar = entrada.nextInt();
        listaActividades.removeAt(actaeliminar);
        VerMenuActividades(listaActividades);        
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
        Scanner entrada = new Scanner(System.in);

    }
    public static void EliminarAsignatura(ListaAsignaturas listaAsignaturas){
        Scanner entrada = new Scanner(System.in);

    }
    public static void AgregarGrupo( ListaGrupos listaGrupos, ListaAsignaturas listaAsignaturas){
        Scanner entrada = new Scanner(System.in);
    }
    public static void EliminarGrupoenAsignatura(ListaAsignaturas listaAsignaturas, ListaGrupos listaGrupos){
        Scanner entrada = new Scanner(System.in);
    }
    public static void AgregarActividadenAsignatura(ListaAsignaturas listaAsignaturas, ListaActividades listaActividades){
        Scanner entrada = new Scanner(System.in);
    }
    public static void EliminarActividadenAsignatura(ListaAsignaturas listaAsignaturas, ListaActividades listaActividades){
        Scanner entrada = new Scanner(System.in);
    }
    public static void CrearNuevoGrupo(ListaGrupos listaGrupos){
        Scanner entrada = new Scanner(System.in);
    }
    public static void EditarNombreGrupo(ListaGrupos listaGrupos){
        Scanner entrada = new Scanner(System.in);
    }
    public static void EliminarGrupo(ListaGrupos listaGrupos){
        Scanner entrada = new Scanner(System.in);
    }
    public static void AgregarAlumnoaGrupo(ListaGrupos listaGrupos){
        Scanner entrada = new Scanner(System.in);
    }
    public static void EliminarAlumnodelGrupo(ListaGrupos listaGrupos, ListaAlumnos listaAlumnos){
        Scanner entrada = new Scanner(System.in);
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
            if ( nombreActividad.equals(listaActividades.getListaActividades().get(0).getNombreAct())){
                flag = true;
            }
        }
        return flag;

    }

}