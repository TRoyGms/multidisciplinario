import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.concurrent.LinkedBlockingDeque;

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
        
        Materia O_E_Primero = new Materia("O_E_Primero");
        Materia O_E_Segundo = new Materia("O_E_Segundo");
        Materia O_E_Tercero = new Materia("O_E_Tercero");
        Materia O_E_Cuarto = new Materia("O_E_Cuarto");
        Materia O_E_Quinto = new Materia("O_E_Quinto");
        Materia O_E_Sexto = new Materia("O_E_Sexto");

        listaMaterias.addAsignatura(O_E_Primero);
        listaMaterias.addAsignatura(O_E_Segundo);
        listaMaterias.addAsignatura(O_E_Tercero);
        listaMaterias.addAsignatura(O_E_Cuarto);
        listaMaterias.addAsignatura(O_E_Quinto);
        listaMaterias.addAsignatura(O_E_Sexto);
        
        choose_user(userList);
    }

    public static void choose_user(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            System.out.println("Seleccione un perfil:\n1. Profesora.\n2. Administradora.");
            option = validarEnteros(entrada);
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
        int option;
        if(listaAlumnos.getSize() == 0 || listaActividades.getSize() == 0 || listaGrupos.getSize() == 0){
            if(listaAlumnos.getSize() == 0 ){
                System.out.println("Aun no existen alumnos");
            }else{
                if (listaActividades.getSize() == 0) {
                    System.out.println("Aún no existen actividades");                    
                }else{
                    if(listaGrupos.getSize() == 0){
                        System.out.println("Aun no existen grupos");
                    }
                }
            }
            System.out.println("Cambie de perfil para generar los datos necesarios");
            choose_user(userList);           
        }else{
            do{
                System.out.println("Seleccione una opcion\n1. Recibir tarea\n2. Ver alumnos con todas las tareas entregadas");
                option = validarEnteros(entrada);
                switch(option){
                    case 1: recibirActividad(userList);
                    break;
                    case 2: verAprobados(userList);
                    break;
                    default: System.out.println("Opcion invalida");
                }
    
            }while (option <0 || option >1);
        }
    }

    public static void VerAdminMenu(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int option;
        do{
            System.out.println("Seleccione una opcion, ya sea para Crear, Editar o Eliminar\n1.Asignatura \n2.Grupos\n3.Alumnos\n4.Actividades.\n0.Cambiar de Usuario");
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
            System.out.println("1. Agregar grupo a la Asignatura");
            System.out.println("2. Eliminar grupo de la asignatura");
            System.out.println("3. Agregar actividad a la Asignatura");
            System.out.println("4. Eliminar actividad de la asignatura");
            System.out.println("0. Volver al menú principal");

            option = validarEnteros(entrada);
            switch (option) {
                case 1:
                    AgregarGrupoenAsignatura(userList);           //Funcional
                    break;
                case 2:
                    EliminarGrupoenAsignatura(userList);          //Funcional
                    break;
                case 3:
                    AgregarActividadenAsignatura(userList);          //Funcional "IMPORTANTE:Pendiente 2da revision"
                    break;
                case 4:
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
        boolean found = false;

        impAsig();
        System.out.println("Seleccione el numero de la materia");
        int materia = validarEnteros(entrada);
        materia--;
        if(listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().size()==0){
            System.out.println("Esta materia aun no cuenta con grupos donde crear alumnos.\nRedirigiendo a menú de grupos.");
            VerMenuGrupos(userList);
        }else{
            do {           
                if(materia >= 0 && materia < listaMaterias.getSize()){
                    System.out.println("Grupos existentes dentro de "+listaMaterias.getListaAsignaturas().get(materia).getNombreAsignatura()+": ");
                    for(int i=0; i< listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().size();i++){
                    System.out.println(listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(i).getNombre());                
                    }
                    do {
                        System.out.println("Seleccione un grupo");
                        String grupo = entrada.nextLine();
                        for(int j =0; j< listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().size();j++){
                            if (grupo.equals(listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(j).getNombre())) {
                                found=true;                             
                                Alumno alumno = new Alumno();
                                System.out.println("Ingrese Nombre(s) del alumno: ");
                                String nombre = entrada.nextLine();
                                System.out.println("Ingrese apellidos de " + nombre);
                                String apellidos = entrada.nextLine();
                                alumno.setNombre(nombre);
                                alumno.setApellidos(apellidos);
                                listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(j).addAlumno(alumno);
                                                         
                            }
                        }
                    } while (found==false);
                }
            } while (materia < 0 || materia >= listaMaterias.getSize());
        }VerMenuAlumnos(userList);
    }

    public static void EditarAlumno(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int materia;
        int alum = -1; // Se inicializa alum con un valor que no es válido, para que no marque el error en el do-while
        boolean found = false;
        impAsig();
        System.out.println("Seleccione el numero de la materia");
        materia = validarEnteros(entrada);
        materia--;
        if(listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().size()==0){
            System.out.println("Esta materia aun no cuenta con grupos donde crear alumnos.\nRedirigiendo a menú de grupos.");
            VerMenuGrupos(userList);
        }else{
            do {           
                if(materia >= 0 && materia < listaMaterias.getSize()){
                    System.out.println("Grupos existentes dentro de "+listaMaterias.getListaAsignaturas().get(materia).getNombreAsignatura()+": ");
                    for(int i=0; i< listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().size();i++){
                    System.out.println(listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(i).getNombre());                
                    }
                    do {
                        System.out.println("Seleccione el grupo donde se encuentra el alumno a editar");
                        String grupo= entrada.nextLine();
                        for(int g=0; g < listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().size();g++){
                            if(grupo.equals(listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(g).getNombre())){
                                System.out.println("Alumnos existentes en "+listaMaterias.getListaAsignaturas().get(materia).getNombreAsignatura()+" "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(g).getNombre());
                                do {
                                found = true;
                                    System.out.println("Seleccione el numero del alumno a editar en "+listaMaterias.getListaAsignaturas().get(materia).getNombreAsignatura()+" "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(g).getNombre());
                                    for(int alumno=0;alumno < listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(g).getAlumnos().size();alumno++){
                                        System.out.println((alumno+1)+". "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(g).getAlumnos().get(alumno).getNombre()+" "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(g).getAlumnos().get(alumno).getApellidos());
                                        alum = validarEnteros(entrada);
                                        if(alum >=0 && alum < listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(g).getAlumnos().size()){
                                            System.out.println("Ingrese nuevo nombre(s)");
                                            String nuevoNombre=entrada.nextLine();
                                            System.out.println("Ingrese nuevos apellidos");
                                            String nuevosApellidos=entrada.nextLine();
                                            listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(g).getAlumnos().get(alum).setNombre(nuevoNombre);
                                            listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(g).getAlumnos().get(alum).setApellidos(nuevosApellidos);
                                        }
                                        else{
                                            System.out.println("Numero invalido");
                                        }    
                                    } 
                                }while(alum < 0 || alum >= listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(g).getAlumnos().size() );
                            }
                        }
                    } while (found == false);   
                }
            }while(materia <0 || materia >= listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().size());
        }
    }

    public static void EliminarAlumno(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        String name;
        int materia;
        boolean found = false;
        int opcion;
        impAsig();
        System.out.println("Seleccione el numero de la materia");
        materia = validarEnteros(entrada);
        materia--;
        if(listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().size()==0){
            System.out.println("Esta materia aun no cuenta con grupos ni alumnos.\nRedirigiendo a menú de grupos.");
            VerMenuGrupos(userList);
        }else{
            if(materia >=0 && materia < listaMaterias.getListaAsignaturas().size())
            System.out.println("Seleccione el grupo donde se encuentra el alumno a editar");
            for(int i =0; i< listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().size();i++){
                System.out.println(listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(i).getNombre());
                String grupo=entrada.nextLine();
                do {
                    for(int j =0; j< listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().size();j++){
                        if(grupo.equals(listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(j).getNombre())){
                            found = true;
                            
                            System.out.println("Seleccione el numero del alumno que desea eliminar");
                            for(int k=0; k < listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(j).getAlumnos().size();k++){
                                System.out.println((k+1)+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(j).getAlumnos().get(k).getNombre()+" "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(j).getAlumnos().get(k).getApellidos());
                            }
                            int alumno=validarEnteros(entrada);
                            alumno--;
                            System.out.println("Realmente desea eliminar a "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(j).getAlumnos().get(alumno).getNombre()+" "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(j).getAlumnos().get(alumno).getApellidos()+"\n1. Si\n0. Otro numero: No");
                            int respuesta=validarEnteros(entrada);
                            if(respuesta == 1){
                                listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(j).getAlumnos().remove(alumno);   
                            }
                        }
                    }   
                } while (found == false);
            }
        }      
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

    public static void AgregarGrupoenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);

        if (listaGrupos.getSize() == 0) {
            System.out.println("Aún no existen Grupos, redirigiendo a crear nuevo Grupo");
            CrearNuevoGrupo(userList);
        } else {
            impAsig();
            System.out.println("Ingrese el Semestre (numero) que desea agregar el grupo");
            int indice = validarEnteros(entrada);
            indice--;
            if (indice >= 0 && indice < listaMaterias.getSize()) {
                impGrupo();
                entrada.nextLine();
                System.out.println("Ingrese el nombre del grupo que desea agregar a " + listaMaterias.getListaAsignaturas().get(indice).getNombreAsignatura());
                String nombreGrupo = entrada.nextLine();
                Grupo grupo = listaGrupos.buscarGrupo(nombreGrupo);
                if (grupo != null) {
                    listaMaterias.getListaAsignaturas().get(indice).addGrupo(grupo);
                }
            } else {
                System.out.println("La materia no existe.");
            }
        }
        VerMenuAsignatura(userList);
    }

    public static void EliminarGrupoenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        if (listaGrupos.getSize() == 0) {
            System.out.println("Aún no existen Grupos, redirigiendo a crear nuevo Grupo");
            CrearNuevoGrupo(userList);
        } else {
            int indice;
            int opcion;
            do {
                impAsig();
                System.out.println("Ingrese el Semestre (numero) del que desea eliminar un grupo");
                indice = validarEnteros(entrada);
                indice--;
                if (indice >= 0 && indice < listaMaterias.getSize()) {
                    System.out.println("Grupos en " + listaMaterias.getListaAsignaturas().get(indice).getNombreAsignatura());
                    for (int i = 0; i < listaMaterias.getListaAsignaturas().get(indice).getListaGrupos().size(); i++){
                        System.out.println(listaMaterias.getListaAsignaturas().get(indice).getListaGrupos().get(i).getNombre());
                    }
                    entrada.nextLine();
                    System.out.println("Ingrese el nombre del grupo que desea eliminar de la asignatura");
                    String nombreGrupo = entrada.nextLine();
                    for ( int i = 0; i < listaGrupos.getSize(); i++ ) {
                        if (nombreGrupo.equals(listaGrupos.getListaGrupos().get(i).getNombre())) {
                            listaMaterias.getListaAsignaturas().get(indice).removeGrupo(listaGrupos.getListaGrupos().get(i));
                            System.out.println("Grupo eliminado de la asignatura correctamente.");
                        }
                    }
                }
                if (listaMaterias.getListaAsignaturas().get(indice).getListaGrupos().size() == 0) {
                    System.out.println("Esta materia ya no cuenta con Grupos... Regresando a Menu");
                    VerMenuAsignatura(userList);
                }
                System.out.println("1. Eliminar otro grupo \nOtro Num. Regresar al menu de asignatura");
                opcion = validarEnteros(entrada);
            } while (opcion == 1);
        }
        VerMenuAsignatura(userList);
    }

    public static void AgregarActividadenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
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
        if (listaGrupos.getSize() == 0) {
            System.out.println("Aun no existen Grupos, redirigiendo a crear nuevo Grupo");
            CrearNuevoGrupo(userList);            
            } else{
                impGrupo();
                System.out.println("Ingrese el nombre del grupo que desea editar:");
                String nombreGrupo = entrada.nextLine();
                for (Grupo grupo : listaGrupos.getListaGrupos()) {
                    if (grupo.getNombre().equals(nombreGrupo)) {                       
                        System.out.println("Ingrese el nuevo nombre para el grupo:");
                        String nuevoNombre = entrada.nextLine();
                        grupo.setNombre(nuevoNombre);
                        System.out.println("Nombre del grupo actualizado correctamente.");
                    }else {
                        System.out.println("El grupo especificado no existe.");            //<<<<<<<<<<<<<<<<<<<<<<<<<         MENSAJE ERRONEO
                        //break;
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

    public static void recibirActividad(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        impAsig();
        System.out.println("Seleccione una materia");
        int option=validarEnteros(entrada);
        int asignatura = option-1;
            do{
                if (asignatura >= 0 && asignatura < listaMaterias.getListaAsignaturas().size()) {
                    for(int grupo = 0; grupo < listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().size();asignatura++){
                        System.out.println((grupo+1)+". "+listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getNombre());
                    }   
                    System.out.println("Seleccione un grupo dentro de "+listaMaterias.getListaAsignaturas().get(asignatura).getNombreAsignatura());
                    int grupo = validarEnteros(entrada);
                    grupo--;
                    do{
                        if(grupo >= 0 && grupo < listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().size()){
                            for(int alumno=0; alumno< listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().size();alumno++){
                                System.out.println((alumno+1)+". "+listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().get(alumno).getNombre()+listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().get(alumno).getApellidos()+listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().get(alumno).getnumLista());
                                }
                            System.out.println("Seleccione el numero de alumno (el numero entre parentesis)");
                            int alumno = validarEnteros(entrada);
                            alumno--;
                            do{
                                if(alumno >= 0 && alumno < listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().size()){
                                    for(int actividad=0; actividad<listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().size();actividad++){
                                        System.out.println((actividad+1)+". "+listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().get(actividad).getNombreAct());
                                    }
                                    System.out.println("Seleccione el numero de actividad a recibir");
                                    int actividad = validarEnteros(entrada);
                                    actividad--;
                                    do{
                                        if(actividad >= 0 && actividad < listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().size()){
                                            listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().get(alumno).setActividad(listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().get(actividad));
                                            System.out.println("Actividad recibida: "+listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().get(actividad).getNombreAct());
                                        }
                                    }while(actividad<0 || actividad >= listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().size());
                                }
                            }while(alumno <0 && alumno >= listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().size());
                        }
                    }while(grupo<0 || grupo > listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().size());             
                }
            }while(option <0 || option >= listaMaterias.getListaAsignaturas().size());        
    }

    public static void verAprobados(ListaUsuarios userList){
            Scanner entrada = new Scanner(System.in);
            impAsig();
            System.out.println("Seleccione una materia");
            int option=validarEnteros(entrada);
            int asignatura = option-1;
            do{
                if (asignatura >= 0 && asignatura < listaMaterias.getListaAsignaturas().size()) {
                    for(int grupo = 0; grupo < listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().size();asignatura++){
                        System.out.println((grupo+1)+". "+listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getNombre());
                    }   
                    System.out.println("Seleccione un grupo dentro de "+listaMaterias.getListaAsignaturas().get(asignatura).getNombreAsignatura()+" para ver alumnos competentes");
                    int grupo = validarEnteros(entrada);
                    grupo--;
                    do{
                        for(int a=0; a< listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().size();a++){
                            if(listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().size() == listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().get(a).getActividad().size()){
                                System.out.println("Número de lista del alumno: "+listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().get(a).getnumLista()+", Nombre del alumno: "+listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().get(a).getNombre()+" "+listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().get(a).getApellidos());
                            }
                        }
                    }while(grupo <0 || grupo >= listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().size());       
                }else {
                    System.out.println("Opcion invalida");
                }
            }while(option <0 || option >= listaMaterias.getListaAsignaturas().size());
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
            System.out.println(listaGrupos.getListaGrupos().get(i).getNombre());
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

    private static int validarEnteros(Scanner scanner) { 
        int input;  
        while (true) {
            try {
                input = scanner.nextInt();
                break;}
            catch (InputMismatchException e)  {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.next(); 
            }
            catch (Exception e)  {
            System.out.println("Ejemplo de un exception esto detecta cualquier tipo de exception");
            scanner.next();
            } 
        }
        return input; 
    }
}


                
                   /*  public static void CrearNuevaAsignatura(ListaUsuarios userList){
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
                
                    } */
                    
                   /*  public static void EditarNombreAsignatura(ListaUsuarios userList){
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
                    } */
                
                    /* public static void EliminarAsignatura(ListaUsuarios userList){
                        Scanner entrada = new Scanner(System.in);
                        int indice; 
                        if (listaMaterias.getSize()==0) {
                            System.out.println("Aun no existen asignaturas/niveles, redirigiendo a crear nueva asignatura/nivel");
                            CrearNuevaAsignatura(userList);          
                            } else{
                                impAsig();
                                System.out.println("Ingrese el numero de la asignatura/nivel que desea eliminar:");
                                indice = validarEnteros(entrada);
                                indice--;
                                do {
                                    if (indice >= 0 && indice < listaMaterias.getSize()) {
                                        entrada.nextLine();
                                        // Iterar sobre la lista de asignaturas y buscar la asignatura por su nombre
                                        listaMaterias.removeAt(indice);
                                        System.out.println("Asignatura/nivel eliminada correctamente.");
                                    }
                                } while (indice < 0 || indice >= listaMaterias.getSize());                                                       
                                VerMenuAsignatura(userList);
                            }
                    } */