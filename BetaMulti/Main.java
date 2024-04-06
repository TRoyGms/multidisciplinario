import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

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
            option = validarEnteros(entrada); //IMPORTANTE: Try & Catch FUNCIONAL!
            if (option == 1) {
                loginTeacher(userList);
            } 
            if (option == 2) {
                loginAdmin(userList);
            }
        } while (option < 1 || option > 2);
    }

    public static void loginTeacher(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenida Profesora Berenice \nIngrese su contraseña:");
        int i = 0;
        while (i < 3) {
            String password = entrada.nextLine(); //Los String no necesesitan el try & catch
            if (password.equals(userList.getUserList().get(1).getPassword())){ 
            VerTeacherMenu(userList);
        }else{
            System.out.println("Password incorrecto \nIntentelo de nuevo");
            i++;
            }
        }
    }

    public static void loginAdmin(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenida Administradora \nIngrese su contraseña:");        
        int i = 0;
        while (i < 3) {
            String password = entrada.nextLine();
            if (password.equals(userList.getUserList().get(0).getPassword())){ 
            VerAdminMenu(userList);
            }else{
                System.out.println("Password incorrecto \nIntentelo de nuevo");
                i++;
            }
        }
    }
                                                                    /////////////       AULA           ///////////
    public static void VerTeacherMenu(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
       if (listaMaterias.getSize()==0 || listaGrupos.getSize()==0 || listaActividades.getSize()==0 || listaAlumnos.getSize()==0) {
            System.out.println("Datos insuficientes");
            choose_user(userList);            
            }else{
            int option;
            int grupo;
            for (int i=0; i<listaGrupos.getSize(); i++){
                System.out.println((i+1)+". " + listaGrupos.getListaGrupos().get(i).getNombre());
            }
                System.out.println("Bienvenida Profesora Berenice");
            do {
                System.out.println("Seleccione el numero del Grupo con el que va a trabajar");
                option = validarEnteros(entrada);
                grupo = option - 1;         //poner un if para entrar a la funcion
                if (grupo >= 0 && grupo < listaGrupos.getSize()){
                    for(int i=0; i<listaGrupos.getListaGrupos().get(grupo).getSizeG();i++){
                        System.out.println(listaGrupos.getListaGrupos().get(grupo).getAlumnos().get(i).getnumLista()+". "+listaGrupos.getListaGrupos().get(grupo).getAlumnos().get(i).getNombre()+" "+listaGrupos.getListaGrupos().get(grupo).getAlumnos().get(i).getApellidos());
                    }
                    System.out.println("Seleccione el numero de lista del alumno para recibir alguna actividad");
                    int lista = validarEnteros(entrada);
                    for(int j=0;j<listaGrupos.getListaGrupos().get(grupo).getSizeG();j++){
                        if(lista==(listaGrupos.getListaGrupos().get(grupo).getAlumnos().get(j).getnumLista())){
                            int alumno = j;
                            System.out.println("Seleccione la actividad a recibir");
                            for(int k=0;k<listaGrupos.getListaGrupos().get(grupo).getActSize();k++){
                                System.out.println((k+1)+". "+listaGrupos.getListaGrupos().get(grupo).getActividadenG().get(k).getNombreAct());
                                int indx = validarEnteros(entrada);
                                int tarea = indx-1;
                                recibirTarea(grupo, alumno, tarea);
                            }
                        }
                    }
                }
                else {
                    System.out.println("Seleccione una opcion valida");
                }
            } while (option < 1 || option > listaGrupos.getSize());     //
        }
    }

    public static void recibirTarea(int grupo, int alumno, int tarea){
        listaGrupos.getListaGrupos().get(grupo).getAlumnos().get(alumno).setActividad(listaGrupos.getListaGrupos().get(grupo).getActividadenG().get(tarea));
    }
    public static void VerAdminMenu(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int option;
        do{
            System.out.println("Seleccione una opcion, ya sea para Crear, Editar o Eliminar\n1.Asignautra \n2.Grupos\n3.Alumnos\n4.Actividades.\n0.Cambiar de Usuario");
            option = validarEnteros(entrada);
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
    public static void VerMenuAsignatura(ListaUsuarios userList){       
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear nueva Asignatura");
            System.out.println("2. Editar nombre de una asignatura existente");
            System.out.println("3. Eliminar una asignatura existente");
            System.out.println("4. Agregar grupo a la Asignatura");
            System.out.println("5. Eliminar grupo de la asignatura");
            System.out.println("6. Agregar actividad a la Asignatura");
            System.out.println("7. Eliminar actividad de la asignatura");
            System.out.println("0. Volver al menú principal");

            option = validarEnteros(entrada);
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
                    AgregarGrupoenAsignatura(userList);           //Funcional
                    break;
                case 5:
                    EliminarGrupoenAsignatura(userList);          //Funcional
                    break;
                case 6:
                    AgregarActividadenAsignatura(userList);          //Funcional "IMPORTANTE:Pendiente 2da revision"
                    break;
                case 7:
                    EliminarActividadenAsignatura(userList);         //Funcional "IMPORTANTE:Pendiente 2da revision"
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
    public static void VerMenuGrupos(ListaUsuarios userList){      
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear nuevo Grupo");
            System.out.println("2. Editar nombre de un grupo existente");
            System.out.println("3. Eliminar grupo existente");
            System.out.println("4. Agregar Alumnos existentes");
            System.out.println("5. Eliminar Alumno del grupo");
            System.out.println("0. Volver al menú principal");

            option = validarEnteros(entrada);

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
                    AgregarAlumnoaGrupo(userList);                //Funcional
                    break;
                case 5:
                    EliminarAlumnodelGrupo(userList);              //Funcional
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
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Crear nuevo Alumno");
            System.out.println("2. Editar nombre de Alumno");
            System.out.println("3. Eliminar Alumno");
            System.out.println("0. Atrás");

            option = validarEnteros(entrada);

            switch (option) {
                case 1:
                    CrearAlumno(userList);    // YA QUEDO
                    break;
                case 2:
                    EditarAlumno(userList);   // YA QUEDO
                    break;
                case 3:
                    EliminarAlumno(userList);   // YA QUEDO
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
            int num_lista = validarEnteros(entrada);
            alumno.setNombre(nombre);
            alumno.setApellidos(apellidos);
            alumno.setnumLista(num_lista);
            listaAlumnos.addAlumno(alumno);
            VerMenuAlumnos(userList);
        }else{ //IMPORTANTE: DONE
            int opcion;
            System.out.println("Ingrese Nombre(s) del alumno");
            String nombre = entrada.nextLine();
            for(int i=0; i<listaAlumnos.getSize(); i++){                                           
                if(nombre.equals(listaAlumnos.getListaAlumnos().get(i).getNombre())){
                    System.out.println("Ya existe un alumno(a) con nombre(s): " + nombre + " sus apellidos son: " + listaAlumnos.getListaAlumnos().get(i).getApellidos()+" Y numero de lista: " + listaAlumnos.getListaAlumnos().get(i).getnumLista());
                    do{
                        System.out.println("Desea crear nuevo alumno(a) con el mismo nombre pero diferentes apellidos o numero de lista? \n1.Si \n2.No");
                        opcion = validarEnteros(entrada);
                        if (opcion==1){
                        Alumno newalumno = new Alumno();
                        System.out.println("Ingrese Apellidos de: " + nombre);
                        String apellidos = entrada.nextLine();
                        entrada.nextLine();
                        System.out.println("Ingrese numero de lista para: " + nombre + " " + apellidos);
                        int numLista = validarEnteros(entrada);
                        newalumno.setNombre(nombre);
                        newalumno.setApellidos(apellidos);
                        newalumno.setnumLista(numLista);
                        listaAlumnos.addAlumno(newalumno);
                        VerMenuAlumnos(userList);
                    }
                }while(opcion<1 || opcion>2);
                }else{
                    Alumno alumno = new Alumno();
                    System.out.println("Ingrese apellidos de " + nombre);
                    String apellidos = entrada.nextLine();
                    System.out.println("Ingrese numero de lista de " + nombre + " " + apellidos);
                    int num_lista = validarEnteros(entrada);
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

        if (listaAlumnos.getSize()==0) {
            System.out.println("Aun no existen alumnos, redirigiendo a crear nuevo alumno");
            CrearAlumno(userList);            
        }else{
            impAlumno(); //IMPORTANTE: DONE
            System.out.println("Ingrese el numero (de opcion, no de lista) del alumno a editar: ");    
            int index = validarEnteros(entrada);
            entrada.nextLine();
            index = index-1;
            
            System.out.println("Ingrese nuevo(s) nombre(s) de: "+listaAlumnos.getListaAlumnos().get(index).getNombre()+" "+listaAlumnos.getListaAlumnos().get(index).getApellidos());
            String name = entrada.nextLine();
            System.out.println("Ingrese nuevos apellidos para: " + name);
            String apellidos= entrada.nextLine();
            System.out.println("Ingrese nuevo numero de lista para: " + name + " " + apellidos);
            int num_lista= validarEnteros(entrada);

            listaAlumnos.getListaAlumnos().get(index).setNombre(name);     
            listaAlumnos.getListaAlumnos().get(index).setApellidos(apellidos);
            listaAlumnos.getListaAlumnos().get(index).setnumLista(num_lista);          
            VerMenuAlumnos(userList);
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
            impAlumno();
            System.out.println("Ingrese nombre del alumno a eliminar");
            name = entrada.nextLine();
            for(int i=0;i<listaAlumnos.getSize();i++){
                if (name.equals(listaAlumnos.getListaAlumnos().get(i).getNombre())) {
                    do{
                        System.out.println("Esta segura de eliminar al alumno: " + listaAlumnos.getListaAlumnos().get(i).getNombre()+" "+listaAlumnos.getListaAlumnos().get(i).getApellidos() + "? \n1.SI \n2.NO");
                        opcion = validarEnteros(entrada);
                        if (opcion==1) {
                            listaAlumnos.remove(i);                            
                        }else{
                            VerMenuAlumnos(userList);
                            break;
                        }
                    }while(opcion<1 || opcion >2);
                }
            }  
        }VerMenuAlumnos(userList);
    }

                                                                     //OPCION 4      <<<<<     ACTIVIDADES
    public static void VerMenuActividades(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int option;
        if(listaActividades.getSize()!=0){
            System.out.println("\n Actividades existentes: \n");
        }
        do{
            for(int i=0;i<listaActividades.getSize();i++){
                System.out.println(listaActividades.getListaActividades().get(i).getNombreAct());
            }
            System.out.println("\n Seleccione una opcion \n1. Crear nueva Actividad \n2. Editar nombre de una actividad existente \n3. Eliminar una actividad existente\n0. Menú principal");
            option = validarEnteros(entrada);
        switch(option){
                case 1:CrearActividad(userList);
                break;
                case 2:EditarActividad(userList);
                break;
                case 3:EliminarActividad(userList);
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
                    System.out.println("Ya existe una actividad llamada: " + name);
                    VerMenuActividades(userList);
                }else{
                    Actividad actividad = new Actividad();
                    actividad.setNombreAct(name);
                    listaActividades.addActividad(actividad);
                    System.out.println("Actividad guardada correctamente");
                    break;
                }
            }
        }VerMenuActividades(userList);
    }  
    
    public static void EditarActividad(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        String newname;
        if(listaActividades.getSize()==0){
            System.out.println("Aun no existen actividades");
            VerMenuActividades(userList);
        }else{
            impActividad();
            do{
                System.out.println("Seleccione el numero de la actividad a editar");
                opcion = validarEnteros(entrada);
                int index = opcion-1;
                if(index >= 0 && index < listaActividades.getSize()){
                    System.out.println("Ingrese nuevo nombre para la actividad: "+listaActividades.getListaActividades().get(index).getNombreAct());
                    entrada.nextLine();
                    newname = entrada.nextLine();   
                    listaActividades.getListaActividades().get(index).setNombreAct(newname);
                }else{
                    System.out.println("el numero seleccionado no corresponde a ninguna actividad");
                }
            }while(opcion<1 || opcion>listaActividades.getSize());
            VerMenuActividades(userList);
        }
    }


    public static void EliminarActividad(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int index;
        if(listaActividades.getSize()==0){
        System.out.println("Aun no existen actividades");
        VerMenuActividades(userList);
        }else{
            impActividad();
        int size=listaActividades.getSize();
        do{
            System.out.println("Seleccione el numero de la actividad a eliminar");
            int opcion = validarEnteros(entrada);
            index= opcion-1;
            if(index >= 0 && index < size){
                listaActividades.removeAt(index);
                System.out.println("Actividad eliminada con exito");
            }
        }while(index <0 || index >= size);
            VerMenuActividades(userList);
        }
    }

    public static void CrearNuevaAsignatura(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        String nombreAsignatura;
        int opcion;
        do {
            System.out.println("Ingrese nombre de la nueva asignatura: ");
            nombreAsignatura = entrada.nextLine();
                                                                          // Verificar si la asignatura ya existe en la lista
            if (listaMaterias.buscarAsignatura(nombreAsignatura) != null) {
                System.out.println("La asignatura/nivel ya existe.");
            } else {
                                                                          // Crear una nueva asignatura y agregarla a la lista
                Materia nuevaAsignatura = new Materia(nombreAsignatura);
                listaMaterias.addAsignatura(nuevaAsignatura);
                System.out.println("Nueva asignatura/nivel creada correctamente.");
            }
                                                                          // Preguntar al usuario si desea crear otra asignatura
            System.out.println("¿Desea crear otra asignatura/nivel? (1. Sí / 0. No)");
            opcion = validarEnteros(entrada);
            entrada.nextLine();                                           // Limpiar el buffer del scanner
        } while (opcion == 1);
        VerMenuAsignatura(userList);

    }
    
    public static void EditarNombreAsignatura(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);         
        if (listaMaterias.getSize()==0) {
            System.out.println("Aun no existen asignaturas/niveles, redirigiendo a crear nueva asignatura/nivel");
            CrearNuevaAsignatura(userList);            
            } else {
                int indice;
                do {
                    impAsig();
                    System.out.println("\nIngrese el numero de la asignatura/nivel que desea editar:");
                    indice = validarEnteros(entrada);
                    indice--;
                    if (indice >= 0 && indice < listaMaterias.getSize()) {
                        entrada.nextLine();
                        System.out.println("Ingrese el nuevo nombre para la asignatura/nivel:");
                        String nuevoNombre = entrada.nextLine();
                        // Iterar sobre la lista de asignaturas y buscar la asignatura por su nombre
                        listaMaterias.getListaAsignaturas().get(indice).setNombre(nuevoNombre);
                    }
                } while (indice < 0 || indice >= listaMaterias.getSize());
            VerMenuAsignatura(userList);
        }
    }

    public static void EliminarAsignatura(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        if (listaMaterias.getSize()==0) {
            System.out.println("Aun no existen asignaturas/niveles, redirigiendo a crear nueva asignatura/nivel");
            CrearNuevaAsignatura(userList);            
            } else{
                impAsig();
                System.out.println("Ingrese el nombre de la asignatura/nivel que desea eliminar:");
                String nombreAsignatura = entrada.nextLine();
                                                                          // Iterar sobre la lista de asignaturas y buscar la asignatura por su nombre
                for (int i = 0; i < listaMaterias.getSize(); i++) {
                    if (listaMaterias.getListaAsignaturas().get(i).getNombreAsignatura().equals(nombreAsignatura)) {
                                                                                     // Si se encuentra la asignatura, eliminarla de la lista
                        listaMaterias.removeAt(i);
                        System.out.println("Asignatura/nivel eliminada correctamente.");
                    } else {        
                                                                                      // Si no se encuentra la asignatura, mostrar un mensaje de error
                        System.out.println("La asignatura/nivel especificada no existe.");
                        VerMenuAsignatura(userList);
                    }
                } VerMenuAsignatura(userList);
            }
    }

    public static void AgregarGrupoenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);                                                    // Validacion de las asignaturas
        if (listaMaterias.getSize() == 0) {
            System.out.println("Aun no existen asignaturas/niveles, redirigiendo a crear nueva asignatura/nivel");
            CrearNuevaAsignatura(userList);            
            }                                                                             // Validacion de los grupos
        if (listaGrupos.getSize()==0) {
            System.out.println("Aun no existen Grupos, redirigiendo a crear nuevo Grupo");
            CrearNuevoGrupo(userList);            
            }    

        else{
        impAsig();
        System.out.println("Ingrese el nombre de la asignatura/nivel a la que desea agregar el grupo:");
        String nombreAsignatura = entrada.nextLine();
                                                                        // Buscar la asignatura por su nombre en la lista de asignaturas
        Materia asignatura = listaMaterias.buscarAsignatura(nombreAsignatura);
        if (asignatura != null) {
            impGrupo();
            System.out.println("Ingrese el nombre del grupo que desea agregar a la asignatura/nivel:");
            String nombreGrupo = entrada.nextLine();

                                                                            // Buscar el grupo por su nombre en la lista de grupos
            Grupo grupo = listaGrupos.buscarGrupo(nombreGrupo);
            if (grupo != null) {
                                                                             // Agregar el grupo a la asignatura
                asignatura.addGrupo(grupo);
                System.out.println("Grupo agregado a la asignatura/nivel correctamente.");
            } else {
                System.out.println("El grupo especificado no existe.");
            }
        } else {
            System.out.println("La asignatura/nivel especificada no existe.");
        }
        VerMenuAsignatura(userList);
        }
    }

    public static void EliminarGrupoenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);        
        // Validacion de las asignaturas
        if (listaMaterias.getSize() == 0) {
            System.out.println("Aun no existen asignaturas/niveles, redirigiendo a crear nueva asignatura/nivel");
            CrearNuevaAsignatura(userList);            
        }
        // Validacion de los grupos
        if (listaGrupos.getSize()==0) {
            System.out.println("Aun no existen Grupos, redirigiendo a crear nuevo Grupo");
            CrearNuevoGrupo(userList);            
        } else { 
        System.out.println("Ingrese el nombre de la asignatura/nivel de la que desea eliminar el grupo:");
        String nombreAsignatura = entrada.nextLine();
        // Buscar la asignatura por su nombre en la lista de asignaturas
        Materia asignatura = listaMaterias.buscarAsignatura(nombreAsignatura);
        if (asignatura != null) {
            System.out.println("Ingrese el nombre del grupo que desea eliminar de la asignatura/nivel:");
            String nombreGrupo = entrada.nextLine();
            // Buscar el grupo por su nombre en la asignatura
            Grupo grupo = asignatura.buscarGrupo(nombreGrupo);
            if (grupo != null) {
                // Eliminar el grupo de la asignatura
                asignatura.removeGrupo(grupo);
                System.out.println("Grupo eliminado de la asignatura/nivel correctamente.");
            } else {
                System.out.println("El grupo especificado no pertenece a la asignatura/nivel.");
            }
        } else {
            System.out.println("La asignatura/nivel especificada no existe.");
        }VerMenuAsignatura(userList);
        }
    }

    public static void AgregarActividadenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);       
        // Validacion de las asignaturas
        if (listaMaterias.getSize() == 0) {
            System.out.println("Aun no existen asignaturas/niveles, redirigiendo a crear nueva asignatura/nivel");
            CrearNuevaAsignatura(userList);            
            }
        // Validacion de las actividades
        if (listaActividades.getSize()==0) {
            System.out.println("Aun no existen Actividades, redirigiendo a crear nueva actividad");
            CrearActividad(userList);          
            } else {
                impAsig();
                System.out.println("Ingrese el nombre de la asignatura/nivel a la que desea agregar la actividad:");
                String nombreAsignatura = entrada.nextLine();

                // Buscar la asignatura por su nombre en la lista de asignaturas
                Materia asignatura = listaMaterias.buscarAsignatura(nombreAsignatura);
        if (asignatura != null) {
            impActividad();
            System.out.println("Ingrese el nombre de la actividad que desea agregar a la asignatura/nivel:");
            String nombreActividad = entrada.nextLine();

            // Buscar la actividad por su nombre en la lista de actividades
            Actividad actividad = listaActividades.buscarActividad(nombreActividad);
            if (actividad != null) {
                // Agregar la actividad a la asignatura
                asignatura.addActividad(actividad);
                System.out.println("Actividad agregada a la asignatura/nivel correctamente.");
            } else {
                System.out.println("La actividad especificada no existe.");
            }
        } else {
            System.out.println("La asignatura/nivel especificada no existe.");
        }
        VerMenuAsignatura(userList);
        }
    }

    public static void EliminarActividadenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);       
        // Validacion de las asignaturas
        if (listaMaterias.getSize() == 0) {
            System.out.println("Aun no existen asignaturas/niveles, redirigiendo a crear nueva asignatura/nivel");
            CrearNuevaAsignatura(userList);            
            }
        // Validacion de los grupos
        if (listaGrupos.getSize() == 0) {
            System.out.println("Aun no existen Grupos, redirigiendo a crear nuevo Grupo");
            CrearNuevoGrupo(userList);            
            }    

        //else{
        for(int i =0; i<listaMaterias.getSize();i++){
            System.out.println(listaMaterias.getListaAsignaturas().get(i).getNombreAsignatura());
        }
        System.out.println("Ingrese el nombre de la asignatura/nivel de la que desea eliminar la actividad:");
        String nombreAsignatura = entrada.nextLine();

        // Buscar la asignatura por su nombre en la lista de asignaturas
        Materia asignatura = listaMaterias.buscarAsignatura(nombreAsignatura);
        if (asignatura != null) {
            System.out.println("Ingrese el nombre de la actividad que desea eliminar de la asignatura/nivel:");
            String nombreActividad = entrada.nextLine();

            // Buscar la actividad por su nombre en la asignatura
            Actividad actividad = asignatura.buscarActividad(nombreActividad);
            if (actividad != null) {
                // Eliminar la actividad de la asignatura
                asignatura.removeActividad(actividad);
                System.out.println("Actividad eliminada de la asignatura/nivel correctamente.");
            } else {
                System.out.println("La actividad especificada no pertenece a la asignatura/nivel.");
            }
        } else {
            System.out.println("La asignatura/nivel especificada no existe.");
        }
        VerMenuAsignatura(userList);
        //}
    }

    public static void CrearNuevoGrupo(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del nuevo grupo:");
        String nombreGrupo = entrada.nextLine();
        if (listaGrupos.buscarGrupo(nombreGrupo) != null) {
            System.out.println("El grupo ya existe.");
        }
        else{
        // Crear un nuevo grupo y agregarlo a la lista de grupos
        Grupo nuevoGrupo = new Grupo(nombreGrupo);
        listaGrupos.addGrupo(nuevoGrupo);
        System.out.println("Nuevo grupo creado correctamente.");
        }
        VerMenuGrupos(userList);
    }

    public static void EditarNombreGrupo(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        
        // Validacion de los grupos
        if (listaGrupos.getSize() == 0) {
            System.out.println("Aun no existen Grupos, redirigiendo a crear nuevo Grupo");
            CrearNuevoGrupo(userList);            
            }    

        else{
            impGrupo();
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
            }
            else {
                System.out.println("El grupo especificado no existe.");
                break;
            }
        }
        VerMenuGrupos(userList);
        }
    }

    public static void EliminarGrupo(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        
        // Validacion de los grupos
        if (listaGrupos.getSize() == 0) {
            System.out.println("Aun no existen Grupos, redirigiendo a crear nuevo Grupo");
            CrearNuevoGrupo(userList);            
            }    

        else{
            impGrupo();
            System.out.println("Ingrese el nombre del grupo que desea eliminar:");
            String nombreGrupo = entrada.nextLine();

        // Iterar sobre la lista de grupos y buscar el grupo por su nombre
        for (int i = 0; i < listaGrupos.getSize(); i++) {
            if (listaGrupos.getListaGrupos().get(i).getNombre().equals(nombreGrupo)) {
                // Si se encuentra el grupo, eliminarlo de la lista
                listaGrupos.removeAt(i);
                System.out.println("Grupo eliminado correctamente.");
            }else {
                System.out.println("El grupo especificado no existe.");
                break;
            }
        }
        VerMenuGrupos(userList);
        }
    }

    public static void AgregarAlumnoaGrupo(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        
         // Validacion de los grupos
         if (listaGrupos.getSize() == 0) {
            System.out.println("Aun no existen Grupos, redirigiendo a crear nuevo grupo");
            CrearNuevoGrupo(userList);            
            }   
            
            // Validacion de los grupos
         if (listaAlumnos.getSize() == 0) {
            System.out.println("Aun no existen Alumnos, redirigiendo a crear nuevo alumno");
            CrearAlumno(userList);            
            } 

        else{
        impGrupo();
        System.out.println("Ingrese el nombre del grupo al que desea agregar el alumno:");
        String nombreGrupo = entrada.nextLine();

        // Buscar el grupo por su nombre en la lista de grupos
        Grupo grupo = listaGrupos.buscarGrupo(nombreGrupo);
        if (grupo != null) {
            impAlumno();
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
    }
    public static void EliminarAlumnodelGrupo(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
         // Validacion de los grupos
         if (listaGrupos.getSize() == 0) {
            System.out.println("Aun no existen Grupos, redirigiendo a crear nuevo grupo");
            CrearNuevoGrupo(userList);            
            }   
            // Validacion de los grupos
         if (listaAlumnos.getSize() == 0) {
            System.out.println("Aun no existen Alumnos, redirigiendo a crear nuevo alumno");
            CrearAlumno(userList);            
            }else{
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
    }

    public static void impAsig(){
        System.out.println("Asignaturas/niveles existentes: ");
        for (int i = 0; i < listaMaterias.getSize(); i++){
            System.out.println((i+1)+". "+listaMaterias.getListaAsignaturas().get(i).getNombreAsignatura());
        }
    }
    public static void impGrupo(){
        System.out.println("Grupos Existentes:");
            for (int i = 0; i < listaGrupos.getSize() ; i++){
                System.out.println((i+1)+". "+listaGrupos.getListaGrupos().get(i).getNombre());
            }
    }
    public static void impAlumno(){
        System.out.println("Lista de Alumnos: \n");
            for(int i =0; i<listaAlumnos.getSize();i++){
                System.out.println((i+1)+". "+listaAlumnos.getListaAlumnos().get(i).getNombre()+" "+listaAlumnos.getListaAlumnos().get(i).getApellidos()+" numero de lista: "+listaAlumnos.getListaAlumnos().get(i).getnumLista());
            }
    }
    public static void impActividad(){
        System.out.println("Lista de Actividades: \n");      
        for(int i=0;i<listaActividades.getSize();i++){
            System.out.println((i+1)+": "+listaActividades.getListaActividades().get(i).getNombreAct()+"\n");
        }
    }

    /* IMPORTANTE: Try&Catch IMPLEMENTADO en la seleccion de perfil en la VAR option */
    private static int validarEnteros(Scanner scanner) { // Evitar entradas erroneas por parte del usuario
        // Lógica para obtener un números enteros validados
        int input;    // Variable auxiliar
        while (true) {
            try {
                input = scanner.nextInt();
                break;}
            catch (InputMismatchException e) /* recibe el error especifico */ {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.next(); // Limpiar el buffer del scanner y se evita el crash 
            }
            /*Este es un ejemplo por que se pueden poner mas de un catch para un try,
             he visto de hasta 3 no se si se puedan mas, este catch de ejemplo no afecta si lo borras*/
            catch ( Exception e) /* recibe el "error 2" */ { // "exception e" evita cualquier tipo de error
            System.out.println("Ejemplo de un exception esto detecta cualquier tipo de exception");
            scanner.next(); // Limpiar el buffer del scanner y se evita el crash
            } 
        }
        return input; // Una vez pasa las prubas de los exceptions retorna la variable auxiliar sin cambios
    }
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
        
        public static boolean buscarGrupo(int index){
            boolean flag=false;
            for(int i=0; i<listaGrupos.getSize();i++){
                if ( listaGrupos.getListaGrupos().get(index).getNombre()){
                    flag = true;
                }
            }
            return flag;
        
        }
    }*/