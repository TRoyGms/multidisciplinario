import java.util.Scanner;

public class Main {
    // ARRAYS globales
    private static ListaAsignaturas listaMaterias = new ListaAsignaturas();
    private static ListaGrupos listaGrupos = new ListaGrupos();
    private static ListaAlumnos listaAlumnos = new ListaAlumnos();
    private static ListaActividades listaActividades = new ListaActividades();

    public static void main(String[] args) {   
        crearObjetos();
    }

    public static void crearObjetos() {
        Maestro Maestra = new Maestro("Berenice", "1");
        Admin Administradora = new Admin("Administradora", "0");

        ListaUsuarios userList = new ListaUsuarios();
        userList.addUser(Administradora);
        userList.addUser(Maestra);
        choose_user(userList);
    }

    public static void choose_user(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            System.out.println("Seleccione un perfil:\n1. Profesora.\n2. Administradora.");
            option = entrada.nextInt();
            if (option == 1) {
                loginTeacher(userList);

            } else {
                loginAdmin(userList);
            }
        } while (option < 1 || option > 2);
    }

    public static void loginTeacher(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenida Profesora Berenice \nIngrese su contraseña:");
        String password = entrada.nextLine();
        int i = 0;
        while (i < 3) {
            if (password.equals(userList.getUserList().get(1).getPassword())){ 
            VerTeacherMenu(userList);
        } i++;}
        // Si no se encontró al maestro o las credenciales son incorrectas
        System.out.println("Usuario o contraseña incorrectos.");
    }

    public static void loginAdmin(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bienvenida Administradora \nIngrese su contraseña:");
        String password = entrada.nextLine();

        int i = 0;
        while (i < 3) {
            if (password.equals(userList.getUserList().get(0).getPassword())){ 
            VerAdminMenu(userList);
        } i++;}
        // Si no se encontró al administrador o las credenciales son incorrectas
        System.out.println("Usuario o contraseña incorrectos.");
    }

    public static void VerTeacherMenu(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        int option;
        for (int i=0; i<listaGrupos.getSize(); i++){
            System.out.println((i+1)+". " + listaGrupos.getListaGrupos().get(i).getNombre());
        }
        do {
            // Imprime el menú para la profesora
            System.out.println("Bienvenida Profesora Berenice");
            System.out.println("Seleccione un Grupo:");
            option = entrada.nextInt();
            option--;
            //listaGrupos.getListaGrupos().get(option).getListaActividades();
           
        
            
        } while (option < 1 || option > 2);
    }
    public static void VerAdminMenu(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int option;
        do{
            System.out.println("Seleccione una opcion, ya sea para Crear, Editar o Eliminar\n1.Asignautra \n2.Grupos\n3.Alumnos\n4.Actividades.\n0.Cambiar de Usuario");
            option=entrada.nextInt();
            switch(option){
                case 1: VerMenuAsignatura(userList);
                break;
                case 2: VerMenuGrupos(userList);
                break;
                case 3: VerMenuAlumnos(userList);
                break;
                case 4: VerMenuActividades(userList);
                break;
                case 0: loginTeacher(userList);
                break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (option < 0 || option > 4);
    }
                                                                        //opcion 1         <<<< ASIGNATURA
    public static void VerMenuAsignatura(ListaUsuarios userList){        // Apartado de ROY!, TERMINAR ESTO
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            System.out.println("Asignaturas existentes:");
            for(int i = 0; i<listaMaterias.getSize(); i++){
                System.out.println(listaMaterias.getListaAsignaturas().get(i).getNombreAsignatura());
            }

            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear nueva Asignatura");
            System.out.println("2. Editar nombre de una asignatura existente");
            System.out.println("3. Eliminar una asignatura existente");
            System.out.println("4. Agregar grupo a la Asignatura");
            System.out.println("5. Eliminar grupo de la asignatura");
            System.out.println("6. Agregar actividad a la Asignatura");
            System.out.println("7. Eliminar actividad de la asignatura");
            System.out.println("0. Volver al menú principal");

            option = entrada.nextInt();

            switch (option) {
                case 1:
                    CrearNuevaAsignatura(userList);       //Funcional
                    break;
                case 2:
                    EditarNombreAsignatura(userList);          //Funcional
                    break;
                case 3:
                    EliminarAsignatura(userList);              //Funcional
                    break;
                case 4:
                    AgregarGrupoenAsignatura(userList);           //Funcional "Falta 2da revision"
                    break;
                case 5:
                    EliminarGrupoenAsignatura(userList);          //Funcional "Sin revision siendo ejecutado"
                    break;
                case 6:
                    AgregarActividadenAsignatura(userList);          //Funcional "Sin revision siendo ejecutado"
                    break;
                case 7:
                    EliminarActividadenAsignatura(userList);         //Funcional "Sin revision siendo ejecutado"
                    break;
                case 0:
                    VerAdminMenu(userList);
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (option < 0 || option > 7);
    }
                                                                        //OPCION 2      <<<<<     GRUPOS
    public static void VerMenuGrupos(ListaUsuarios userList){       // Apartado de ROY!, TERMINAR ESTO
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            // Mostrar lista de grupos existentes
            System.out.println("Grupos existentes:");
            for (Grupo grupo : listaGrupos.getListaGrupos()) {
                System.out.println("- " + grupo.getNombre());
            }

            // Mostrar opciones del menú
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear nuevo Grupo");
            System.out.println("2. Editar nombre de un grupo existente");
            System.out.println("3. Eliminar grupo existente");
            System.out.println("4. Agregar Alumnos existentes");
            System.out.println("5. Eliminar Alumno del grupo");
            System.out.println("0. Volver al menú principal");

            option = entrada.nextInt();

            switch (option) {
                case 1:
                    CrearNuevoGrupo(userList);       //Funcional
                    break;
                case 2:
                    EditarNombreGrupo(userList);         //Funcional
                    break;
                case 3:
                    EliminarGrupo(userList);                 //Funcional
                    break;
                case 4:
                    AgregarAlumnoaGrupo(userList);                //Funcional "Falta 2da revision"
                    break;
                case 5:
                    EliminarAlumnodelGrupo(userList);              //Funcional "Falta 2da revision"
                    break;
                case 0:
                    VerAdminMenu(userList);
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (option < 0 || option > 5);
    }

                                                                     //OPCION 3      <<<<<     ALUMNOS
    public static void VerMenuAlumnos(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            // Mostrar lista de alumnos existentes
            System.out.println("Alumnos existentes:");
            for (Alumno alumno : listaAlumnos.getListaAlumnos()) {
                System.out.println("- " + alumno.getNombre() + " " + alumno.getApellidos() + " " + alumno.getnumLista());
            }

            // Mostrar opciones del menú
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear nuevo Alumno");
            System.out.println("2. Editar nombre de Alumno");
            System.out.println("3. Eliminar Alumno");
            System.out.println("0. Atrás");

            option = entrada.nextInt();

            switch (option) {
                case 1:
                    CrearAlumno(userList);
                    break;
                case 2:
                    EditarAlumno(userList);
                    break;
                case 3:
                    EliminarAlumno(userList);
                    break;
                case 0:
                    VerAdminMenu(userList);
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (option <0 || option > 3);
    }

    public static void CrearAlumno(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);       
        if(listaAlumnos.getSize()==0) {
            Alumno alumno = new Alumno();
            System.out.println("Ingrese Nombre(s) del alumno: ");
            String nombre = entrada.nextLine();
            System.out.println("Ingrese apellidos de " + nombre);
            String apellidos = entrada.nextLine();
            System.out.println("Ingrese numero de lista de " + nombre + " " + apellidos);
            int num_lista = entrada.nextInt();
            alumno.setNombre(nombre);
            alumno.setApellidos(apellidos);
            alumno.setnumLista(num_lista);
            listaAlumnos.addAlumno(alumno);
            VerMenuAlumnos(userList);
        }else{
            int opcion;
            System.out.println("Ingrese Nombre(s) del alumno");
            String nombre = entrada.nextLine();
            for(int i=0; i<listaAlumnos.getSize(); i++){                                           
                if(nombre.equals(listaAlumnos.getListaAlumnos().get(i).getNombre())){
                    System.out.println("Ya existe un alumno con nombre(s): " + nombre + "sus apellidos son: " + listaAlumnos.getListaAlumnos().get(i).getApellidos());
                    System.out.println("Y numero de lista: " + listaAlumnos.getListaAlumnos().get(i).getnumLista());
                    do{
                        System.out.println("Desea crear nuevo alumno con el mismo nombre y diferentes apellidos o numero de lista? \n1.Si \n2.No");
                        opcion=entrada.nextInt();
                        if (opcion==1){
                        Alumno alumno = new Alumno();
                        System.out.println("Ingrese Apellidos de: " + nombre);
                        String apellidos = entrada.nextLine();
                        System.out.println("Ingrese numero de lista para: " + nombre + " " + apellidos);
                        int num_lista = entrada.nextInt();
                        alumno.setNombre(nombre);
                        alumno.setApellidos(apellidos);
                        alumno.setnumLista(num_lista);
                        listaAlumnos.addAlumno(alumno);
                    }
                }while(opcion<1 || opcion>2);
                }else{
                    Alumno alumno = new Alumno();
                    System.out.println("Ingrese apellidos de " + nombre);
                    String apellidos = entrada.nextLine();
                    System.out.println("Ingrese numero de lista de " + nombre + " " + apellidos);
                    int num_lista = entrada.nextInt();
                    alumno.setNombre(nombre);
                    alumno.setApellidos(apellidos);
                    alumno.setnumLista(num_lista);
                    listaAlumnos.addAlumno(alumno);
                    VerMenuAlumnos(userList);
                }
            }
        }
        VerMenuAlumnos(userList);
    }
    public static void EditarAlumno(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        String name;
        if (listaAlumnos.getSize()==0) {
            System.out.println("Aun no existen alumnos, redirigiendo a crear nuevo alumno");
            CrearAlumno(userList);            
        }else{
            System.out.println("Lista de alumnos existentes en la base de datos: \n" + listaAlumnos.getListaAlumnos());
            System.out.println("Ingrese nombre del alumno a editar: ");
            name= entrada.nextLine();
            for(int i=0;i<listaAlumnos.getSize();i++){
                if (name.equals(listaAlumnos.getListaAlumnos().get(i).getNombre())) {
                    System.out.println("Ingrese nuevo(s) nombre(s) del alumno");
                    name = entrada.nextLine();
                    System.out.println("Ingrese nuevos apellidos para: " + name);
                    String apellidos= entrada.nextLine();
                    System.out.println("Ingrese nuevo numero de lista para: " + name + " " + apellidos);
                    int num_lista= entrada.nextInt();
                    listaAlumnos.getListaAlumnos().get(i).setNombre(name);     
                    listaAlumnos.getListaAlumnos().get(i).setApellidos(apellidos);
                    listaAlumnos.getListaAlumnos().get(i).setnumLista(num_lista);          
                }
            }VerAdminMenu(userList);
        }
    }
    public static void EliminarAlumno(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        String name;
        int opcion;
        if (listaAlumnos.getSize()==0) {
            System.out.println("Aun no existen alumnos, redirigiendo a crear nuevo alumno");
            CrearAlumno(userList);            
        }else{
            System.out.println("Lista de alumnos existentes en la base de datos: \n"+listaAlumnos.getListaAlumnos());
            System.out.println("Ingrese nombre del alumno a eliminar");
            name= entrada.nextLine();
            for(int i=0;i<listaAlumnos.getSize();i++){
                if (name.equals(listaAlumnos.getListaAlumnos().get(i).getNombre())) {
                    do{
                        System.out.println("Esta segura de eliminar al alumno: " + listaAlumnos.getListaAlumnos().get(i) + "? \n1.SI \n2.NO");
                        opcion=entrada.nextInt();
                        if (opcion==1) {
                            listaAlumnos.remove(i);                            
                        }
                    }while(opcion<1 || opcion >2);
                }
            }  
        }VerAdminMenu(userList);
    }

                                                                     //OPCION 4      <<<<<     ACTIVIDADES
    public static void VerMenuActividades(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int option;
        do{
            for(int i=0;i<listaActividades.getSize();i++){
                System.out.println(listaActividades.getListaActividades().get(i).getNombreAct()+"\n");
            }
            System.out.println("Seleccione una opcion \n1. Crear nueva Asignatura \n2. Editar nombre de una asignatura existente \n3. Eliminar una asignatura existente\n0. Menú principal");
            option = entrada.nextInt();
        switch(option){
                case 1:CrearActividad(userList);
                break;
                case 2:EditarActividad(userList);
                break;
                case 3: EliminarActividad(userList);
                break;
                case 0:VerAdminMenu(userList);
            }       
        }while(option < 1 || option > 4);
    }
    public static void CrearActividad(ListaUsuarios userList){
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
                    System.out.println("Ya existe una actividad llamada: " + name);
                    do{
                        System.out.println("Seleccione una opcion\n1. Menu actividades \n2. Menu principal");
                        opcion=entrada.nextInt();
                        if(opcion==1){
                            VerMenuActividades(userList);
                        }else{
                            VerAdminMenu(userList);
                        }
                    }while(opcion<1 || opcion > 2);
                }else{
                    Actividad actividad = new Actividad();
                    actividad.setNombreAct(name);
                    listaActividades.addActividad(actividad);
                }
            }
        }VerMenuActividades(userList);
    }  
    public static void EditarActividad(ListaUsuarios userList){
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
        VerMenuActividades(userList);
    }
    public static void EliminarActividad(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int actaeliminar;

        for(int i=0;i<listaActividades.getSize();i++){
            System.out.println((i+1)+listaActividades.getListaActividades().get(i).getNombreAct()+"\n");
        }
        System.out.println("Seleccione el numero de la actividad a eliminar");
        actaeliminar = entrada.nextInt();
        listaActividades.removeAt(actaeliminar);
        VerMenuActividades(userList);        
    }


    public static void CrearNuevaAsignatura(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        String nombreAsignatura;
        int opcion;
        do {
            System.out.println("Ingrese nombre de la nueva asignatura:");
            nombreAsignatura = entrada.nextLine();

            // Verificar si la asignatura ya existe en la lista
            if (listaMaterias.buscarAsignatura(nombreAsignatura) != null) {
                System.out.println("La asignatura ya existe.");
            } else {
                // Crear una nueva asignatura y agregarla a la lista
                Materia nuevaAsignatura = new Materia(nombreAsignatura);
                listaMaterias.addAsignatura(nuevaAsignatura);
                System.out.println("Nueva asignatura creada correctamente.");
            }

            // Preguntar al usuario si desea crear otra asignatura
            System.out.println("¿Desea crear otra asignatura? (1. Sí / 0. No)");
            opcion = entrada.nextInt();
            entrada.nextLine(); // Limpiar el buffer del scanner
        } while (opcion == 1);
        VerMenuAsignatura(userList);

    }
    
    public static void EditarNombreAsignatura(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la asignatura que desea editar:");
        String nombreAsignatura = entrada.nextLine();
        System.out.println("Ingrese el nuevo nombre para la asignatura:");
        String nuevoNombre = entrada.nextLine();

        // Iterar sobre la lista de asignaturas y buscar la asignatura por su nombre
        for (Materia materia : listaMaterias.getListaAsignaturas()) {
            if (materia.getNombreAsignatura().equals(nombreAsignatura)) {
                // Si se encuentra la asignatura, actualizar su nombre
                materia.setNombre(nuevoNombre);
                System.out.println("Nombre de la asignatura actualizado correctamente.");
                return;
            }
        }
        
        // Si no se encuentra la asignatura, mostrar un mensaje de error
        System.out.println("La asignatura especificada no existe.");
        VerMenuAsignatura(userList);
    }

    public static void EliminarAsignatura(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        for(int i =0;i<listaMaterias.getSize();i++){
            System.out.println(listaMaterias.getListaAsignaturas().get(i).getNombreAsignatura());

        }
        System.out.println("Ingrese el nombre de la asignatura que desea eliminar:");
        String nombreAsignatura = entrada.nextLine();

        // Iterar sobre la lista de asignaturas y buscar la asignatura por su nombre
        for (int i = 0; i < listaMaterias.getSize(); i++) {
            if (listaMaterias.getListaAsignaturas().get(i).getNombreAsignatura().equals(nombreAsignatura)) {
                // Si se encuentra la asignatura, eliminarla de la lista
                listaMaterias.removeAt(i);
                System.out.println("Asignatura eliminada correctamente.");
                return;
            }
        }

        // Si no se encuentra la asignatura, mostrar un mensaje de error
        System.out.println("La asignatura especificada no existe.");
        VerMenuAsignatura(userList);
    }

    public static void AgregarGrupoenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la asignatura a la que desea agregar el grupo:");
        String nombreAsignatura = entrada.nextLine();

        // Buscar la asignatura por su nombre en la lista de asignaturas
        Materia asignatura = listaMaterias.buscarAsignatura(nombreAsignatura);
        if (asignatura != null) {
            System.out.println("Ingrese el nombre del grupo que desea agregar a la asignatura:");
            String nombreGrupo = entrada.nextLine();

            // Buscar el grupo por su nombre en la lista de grupos
            Grupo grupo = listaGrupos.buscarGrupo(nombreGrupo);
            if (grupo != null) {
                // Agregar el grupo a la asignatura
                asignatura.addGrupo(grupo);
                System.out.println("Grupo agregado a la asignatura correctamente.");
            } else {
                System.out.println("El grupo especificado no existe.");
            }
        } else {
            System.out.println("La asignatura especificada no existe.");
        }
        VerMenuAsignatura(userList);
    }

    public static void EliminarGrupoenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la asignatura de la que desea eliminar el grupo:");
        String nombreAsignatura = entrada.nextLine();

        // Buscar la asignatura por su nombre en la lista de asignaturas
        Materia asignatura = listaMaterias.buscarAsignatura(nombreAsignatura);
        if (asignatura != null) {
            System.out.println("Ingrese el nombre del grupo que desea eliminar de la asignatura:");
            String nombreGrupo = entrada.nextLine();

            // Buscar el grupo por su nombre en la asignatura
            Grupo grupo = asignatura.buscarGrupo(nombreGrupo);
            if (grupo != null) {
                // Eliminar el grupo de la asignatura
                asignatura.removeGrupo(grupo);
                System.out.println("Grupo eliminado de la asignatura correctamente.");
            } else {
                System.out.println("El grupo especificado no pertenece a la asignatura.");
            }
        } else {
            System.out.println("La asignatura especificada no existe.");
        }
        VerMenuAsignatura(userList);
    }

    public static void AgregarActividadenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la asignatura a la que desea agregar la actividad:");
        String nombreAsignatura = entrada.nextLine();

        // Buscar la asignatura por su nombre en la lista de asignaturas
        Materia asignatura = listaMaterias.buscarAsignatura(nombreAsignatura);
        if (asignatura != null) {
            System.out.println("Ingrese el nombre de la actividad que desea agregar a la asignatura:");
            String nombreActividad = entrada.nextLine();

            // Buscar la actividad por su nombre en la lista de actividades
            Actividad actividad = listaActividades.buscarActividad(nombreActividad);
            if (actividad != null) {
                // Agregar la actividad a la asignatura
                asignatura.addActividad(actividad);
                System.out.println("Actividad agregada a la asignatura correctamente.");
            } else {
                System.out.println("La actividad especificada no existe.");
            }
        } else {
            System.out.println("La asignatura especificada no existe.");
        }
        VerMenuAsignatura(userList);
    }

    public static void EliminarActividadenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la asignatura de la que desea eliminar la actividad:");
        String nombreAsignatura = entrada.nextLine();

        // Buscar la asignatura por su nombre en la lista de asignaturas
        Materia asignatura = listaMaterias.buscarAsignatura(nombreAsignatura);
        if (asignatura != null) {
            System.out.println("Ingrese el nombre de la actividad que desea eliminar de la asignatura:");
            String nombreActividad = entrada.nextLine();

            // Buscar la actividad por su nombre en la asignatura
            Actividad actividad = asignatura.buscarActividad(nombreActividad);
            if (actividad != null) {
                // Eliminar la actividad de la asignatura
                asignatura.removeActividad(actividad);
                System.out.println("Actividad eliminada de la asignatura correctamente.");
            } else {
                System.out.println("La actividad especificada no pertenece a la asignatura.");
            }
        } else {
            System.out.println("La asignatura especificada no existe.");
        }
        VerMenuAsignatura(userList);
    }

    public static void CrearNuevoGrupo(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del nuevo grupo:");
        String nombreGrupo = entrada.nextLine();

        // Crear un nuevo grupo y agregarlo a la lista de grupos
        Grupo nuevoGrupo = new Grupo(nombreGrupo);
        listaGrupos.addGrupo(nuevoGrupo);
        System.out.println("Nuevo grupo creado correctamente.");
        VerMenuGrupos(userList);
    }

    public static void EditarNombreGrupo(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del grupo que desea editar:");
        String nombreGrupo = entrada.nextLine();

        // Iterar sobre la lista de grupos y buscar el grupo por su nombre
        for (Grupo grupo : listaGrupos.getListaGrupos()) {
            if (grupo.getNombre().equals(nombreGrupo)) {
                // Si se encuentra el grupo, solicitar un nuevo nombre y actualizarlo
                System.out.println("Ingrese el nuevo nombre para el grupo:");
                String nuevoNombre = entrada.nextLine();
                grupo.setNombre(nuevoNombre);
                System.out.println("Nombre del grupo actualizado correctamente.");
                return;
            }
        }

        // Si no se encuentra el grupo, mostrar un mensaje de error
        System.out.println("El grupo especificado no existe.");
        VerMenuGrupos(userList);
    }

    public static void EliminarGrupo(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del grupo que desea eliminar:");
        String nombreGrupo = entrada.nextLine();

        // Iterar sobre la lista de grupos y buscar el grupo por su nombre
        for (int i = 0; i < listaGrupos.getSize(); i++) {
            if (listaGrupos.getListaGrupos().get(i).getNombre().equals(nombreGrupo)) {
                // Si se encuentra el grupo, eliminarlo de la lista
                listaGrupos.removeAt(i);
                System.out.println("Grupo eliminado correctamente.");
                return;
            }
        }

        // Si no se encuentra el grupo, mostrar un mensaje de error
        System.out.println("El grupo especificado no existe.");
        VerMenuGrupos(userList);
    }

    public static void AgregarAlumnoaGrupo(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del grupo al que desea agregar el alumno:");
        String nombreGrupo = entrada.nextLine();

        // Buscar el grupo por su nombre en la lista de grupos
        Grupo grupo = listaGrupos.buscarGrupo(nombreGrupo);
        if (grupo != null) {
            System.out.println("Ingrese el nombre del alumno que desea agregar al grupo:");
            String nombreAlumno = entrada.nextLine();

            // Buscar el alumno por su nombre en la lista de alumnos
            Alumno alumno = listaAlumnos.buscarAlumno(nombreAlumno);
            if (alumno != null) {
                // Agregar el alumno al grupo
                grupo.addAlumno(alumno);
                System.out.println("Alumno agregado al grupo correctamente.");
            } else {
                System.out.println("El alumno especificado no existe.");
            }
        } else {
            System.out.println("El grupo especificado no existe.");
        }
        VerMenuGrupos(userList);
    }

    public static void EliminarAlumnodelGrupo(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del grupo del que desea eliminar el alumno:");
        String nombreGrupo = entrada.nextLine();

        // Buscar el grupo por su nombre en la lista de grupos
        Grupo grupo = listaGrupos.buscarGrupo(nombreGrupo);
        if (grupo != null) {
            System.out.println("Ingrese el nombre del alumno que desea eliminar del grupo:");
            String nombreAlumno = entrada.nextLine();

            // Buscar el alumno por su nombre en el grupo
            Alumno alumno = grupo.buscarAlumno(nombreAlumno);
            if (alumno != null) {
                // Eliminar el alumno del grupo
                grupo.removeAlumno(alumno);
                System.out.println("Alumno eliminado del grupo correctamente.");
            } else {
                System.out.println("El alumno especificado no pertenece al grupo.");
            }
        } else {
            System.out.println("El grupo especificado no existe.");
        }
        VerMenuGrupos(userList);
    }
    /*public static boolean buscarAsignatura(String nombreMateria, ListaAsignaturas listaAsignaturas){
        boolean flag=false;
        for(int i=0; i<listaAsignaturas.getSize();i++){
            if ( nombreMateria.equals(listaAsignaturas.getListaAsignaturas().get(0).getNombreAsignatura())){
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

    }*/

}