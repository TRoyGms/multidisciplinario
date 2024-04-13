import java.util.Scanner;
//import javax.swing.text.StyledEditorKit.ForegroundAction;
import java.util.InputMismatchException;
//import java.util.concurrent.LinkedBlockingDeque;      // No tengo idea de donde salio eso...
@SuppressWarnings("resource")  // Quita las alertas de cierre de scanner       :O!

public class Main {
    private static ListaAsignaturas listaMaterias = new ListaAsignaturas();
    private static ListaGrupos listaGrupos = new ListaGrupos();
    private static ListaAlumnos listaAlumnos = new ListaAlumnos();
    private static ListaActividades listaActividades = new ListaActividades();
    public static void main(String[] args) {   
        crearObjetos();
    }
    public static void crearObjetos() {
        Maestro Maestra = new Maestro("Berenice");
        Admin Administradora = new Admin("Perfil Administración");

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

        Grupo Primero_A = new Grupo("Primero A");
        Grupo Primero_B = new Grupo("Primero B");
        Grupo Primero_C = new Grupo("Primero C");
        Grupo Primero_D = new Grupo("Primero D");
        Grupo Primero_E = new Grupo("Primero E");
        Grupo Primero_F = new Grupo("Primero F");
        Grupo Primero_G = new Grupo("Primero G");
        Grupo Primero_H = new Grupo("Primero H");
        Grupo Primero_I = new Grupo("Primero I");
        Grupo Primero_J = new Grupo("Primero J");

        listaMaterias.getListaAsignaturas().get(0).addGrupo(Primero_A);
        listaMaterias.getListaAsignaturas().get(0).addGrupo(Primero_B);
        listaMaterias.getListaAsignaturas().get(0).addGrupo(Primero_C);
        listaMaterias.getListaAsignaturas().get(0).addGrupo(Primero_D);
        listaMaterias.getListaAsignaturas().get(0).addGrupo(Primero_E);
        listaMaterias.getListaAsignaturas().get(0).addGrupo(Primero_F);
        listaMaterias.getListaAsignaturas().get(0).addGrupo(Primero_G);
        listaMaterias.getListaAsignaturas().get(0).addGrupo(Primero_H);
        listaMaterias.getListaAsignaturas().get(0).addGrupo(Primero_I);
        listaMaterias.getListaAsignaturas().get(0).addGrupo(Primero_J);

        Grupo Segundo_A = new Grupo("Segundo A");
        Grupo Segundo_B = new Grupo("Segundo B");
        Grupo Segundo_C = new Grupo("Segundo C");
        Grupo Segundo_D = new Grupo("Segundo D");
        Grupo Segundo_E = new Grupo("Segundo E");
        Grupo Segundo_F = new Grupo("Segundo F");
        Grupo Segundo_G = new Grupo("Segundo G");
        Grupo Segundo_H = new Grupo("Segundo H");
        Grupo Segundo_I = new Grupo("Segundo I");
        Grupo Segundo_J = new Grupo("Segundo J");

        listaMaterias.getListaAsignaturas().get(1).addGrupo(Segundo_A);
        listaMaterias.getListaAsignaturas().get(1).addGrupo(Segundo_B);
        listaMaterias.getListaAsignaturas().get(1).addGrupo(Segundo_C);
        listaMaterias.getListaAsignaturas().get(1).addGrupo(Segundo_D);
        listaMaterias.getListaAsignaturas().get(1).addGrupo(Segundo_E);
        listaMaterias.getListaAsignaturas().get(1).addGrupo(Segundo_F);
        listaMaterias.getListaAsignaturas().get(1).addGrupo(Segundo_G);
        listaMaterias.getListaAsignaturas().get(1).addGrupo(Segundo_H);
        listaMaterias.getListaAsignaturas().get(1).addGrupo(Segundo_I);
        listaMaterias.getListaAsignaturas().get(1).addGrupo(Segundo_J);

        Grupo Tercero_A = new Grupo("Tercero A");
        Grupo Tercero_B = new Grupo("Tercero B");
        Grupo Tercero_C = new Grupo("Tercero C");
        Grupo Tercero_D = new Grupo("Tercero D");
        Grupo Tercero_E = new Grupo("Tercero E");
        Grupo Tercero_F = new Grupo("Tercero F");
        Grupo Tercero_G = new Grupo("Tercero G");
        Grupo Tercero_H = new Grupo("Tercero H");
        Grupo Tercero_I = new Grupo("Tercero I");
        Grupo Tercero_J = new Grupo("Tercero J");

        listaMaterias.getListaAsignaturas().get(2).addGrupo(Tercero_A);
        listaMaterias.getListaAsignaturas().get(2).addGrupo(Tercero_B);
        listaMaterias.getListaAsignaturas().get(2).addGrupo(Tercero_C);
        listaMaterias.getListaAsignaturas().get(2).addGrupo(Tercero_D);
        listaMaterias.getListaAsignaturas().get(2).addGrupo(Tercero_E);
        listaMaterias.getListaAsignaturas().get(2).addGrupo(Tercero_F);
        listaMaterias.getListaAsignaturas().get(2).addGrupo(Tercero_G);
        listaMaterias.getListaAsignaturas().get(2).addGrupo(Tercero_H);
        listaMaterias.getListaAsignaturas().get(2).addGrupo(Tercero_I);
        listaMaterias.getListaAsignaturas().get(2).addGrupo(Tercero_J);

        Grupo Cuarto_A = new Grupo("Cuarto A");
        Grupo Cuarto_B = new Grupo("Cuarto B");
        Grupo Cuarto_C = new Grupo("Cuarto C");
        Grupo Cuarto_D = new Grupo("Cuarto D");
        Grupo Cuarto_E = new Grupo("Cuarto E");
        Grupo Cuarto_F = new Grupo("Cuarto F");
        Grupo Cuarto_G = new Grupo("Cuarto G");
        Grupo Cuarto_H = new Grupo("Cuarto H");
        Grupo Cuarto_I = new Grupo("Cuarto I");
        Grupo Cuarto_J = new Grupo("Cuarto J");

        listaMaterias.getListaAsignaturas().get(3).addGrupo(Cuarto_A);
        listaMaterias.getListaAsignaturas().get(3).addGrupo(Cuarto_B);
        listaMaterias.getListaAsignaturas().get(3).addGrupo(Cuarto_C);
        listaMaterias.getListaAsignaturas().get(3).addGrupo(Cuarto_D);
        listaMaterias.getListaAsignaturas().get(3).addGrupo(Cuarto_E);
        listaMaterias.getListaAsignaturas().get(3).addGrupo(Cuarto_F);
        listaMaterias.getListaAsignaturas().get(3).addGrupo(Cuarto_G);
        listaMaterias.getListaAsignaturas().get(3).addGrupo(Cuarto_H);
        listaMaterias.getListaAsignaturas().get(3).addGrupo(Cuarto_I);
        listaMaterias.getListaAsignaturas().get(3).addGrupo(Cuarto_J);

        Grupo Quinto_A = new Grupo("Quinto A");
        Grupo Quinto_B = new Grupo("Quinto B");
        Grupo Quinto_C = new Grupo("Quinto C");
        Grupo Quinto_D = new Grupo("Quinto D");
        Grupo Quinto_E = new Grupo("Quinto E");
        Grupo Quinto_F = new Grupo("Quinto F");
        Grupo Quinto_G = new Grupo("Quinto G");
        Grupo Quinto_H = new Grupo("Quinto H");
        Grupo Quinto_I = new Grupo("Quinto I");
        Grupo Quinto_J = new Grupo("Quinto J");

        listaMaterias.getListaAsignaturas().get(4).addGrupo(Quinto_A);
        listaMaterias.getListaAsignaturas().get(4).addGrupo(Quinto_B);
        listaMaterias.getListaAsignaturas().get(4).addGrupo(Quinto_C);
        listaMaterias.getListaAsignaturas().get(4).addGrupo(Quinto_D);
        listaMaterias.getListaAsignaturas().get(4).addGrupo(Quinto_E);
        listaMaterias.getListaAsignaturas().get(4).addGrupo(Quinto_F);
        listaMaterias.getListaAsignaturas().get(4).addGrupo(Quinto_G);
        listaMaterias.getListaAsignaturas().get(4).addGrupo(Quinto_H);
        listaMaterias.getListaAsignaturas().get(4).addGrupo(Quinto_I);
        listaMaterias.getListaAsignaturas().get(4).addGrupo(Quinto_J);

        Grupo Sexto_A = new Grupo("Sexto A");
        Grupo Sexto_B = new Grupo("Sexto B");
        Grupo Sexto_C = new Grupo("Sexto C");
        Grupo Sexto_D = new Grupo("Sexto D");
        Grupo Sexto_E = new Grupo("Sexto E");
        Grupo Sexto_F = new Grupo("Sexto F");
        Grupo Sexto_G = new Grupo("Sexto G");
        Grupo Sexto_H = new Grupo("Sexto H");
        Grupo Sexto_I = new Grupo("Sexto I");
        Grupo Sexto_J = new Grupo("Sexto J");

        listaMaterias.getListaAsignaturas().get(5).addGrupo(Sexto_A);
        listaMaterias.getListaAsignaturas().get(5).addGrupo(Sexto_B);
        listaMaterias.getListaAsignaturas().get(5).addGrupo(Sexto_C);
        listaMaterias.getListaAsignaturas().get(5).addGrupo(Sexto_D);
        listaMaterias.getListaAsignaturas().get(5).addGrupo(Sexto_E);
        listaMaterias.getListaAsignaturas().get(5).addGrupo(Sexto_F);
        listaMaterias.getListaAsignaturas().get(5).addGrupo(Sexto_G);
        listaMaterias.getListaAsignaturas().get(5).addGrupo(Sexto_H);
        listaMaterias.getListaAsignaturas().get(5).addGrupo(Sexto_I);
        listaMaterias.getListaAsignaturas().get(5).addGrupo(Sexto_J);
    
        choose_user(userList);
    }
    public static void choose_user(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            System.out.println("\nSeleccione un perfil:\n1. Profesora.\n2. Administradora.");
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
    public static void VerTeacherMenu(ListaUsuarios userList) {        /////////////       AULA           ///////////
        Scanner entrada = new Scanner(System.in);
        int option;
        if(listaActividades.getSize() == 0 ){
            System.out.println("Aún no existen actividades que recibir");            
            System.out.println("Cambie de perfil para generar los datos necesarios");
            choose_user(userList);           
        }else{
            do{
                System.out.println("Seleccione una opcion\n1. Recibir tarea\n2. Ver alumnos con todas las tareas entregadas\n3. Cancelar entrega\n4. Cambiar de usuario \n0.Salir del programa");
                option = validarEnteros(entrada);
                switch(option){
                    case 1: recibirActividad(userList);
                    break;
                    case 2: verAprobados(userList);
                    break;
                    case 3: cancelarEntrega(userList);
                    break;
                    case 4:loginAdmin(userList);
                    break;
                    case 0: System.out.println("Adios.");
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
            System.out.println("Seleccione una opcion para trabajar\n1.Asignatura \n2.Grupos\n3.Alumnos\n4.Actividades.\n5.Cambiar de Usuario. \n0. Salir del programa");
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
                case 5: loginTeacher(userList);
                break;
                case 0: System.out.println("Vuelva pronto");
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (option < 0 || option > 4);
    }
    public static void VerMenuAsignatura(ListaUsuarios userList){           
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar actividad a la Asignatura ");
            System.out.println("2. Eliminar actividad de la asignatura");
            System.out.println("0. Volver al menú principal");

            option = validarEnteros(entrada);
            switch (option) {
                case 1:
                    AgregarActividadenAsignatura(userList);        
                    break;
                case 2:
                    EliminarActividadenAsignatura(userList);         
                    break;
                case 0:
                    VerAdminMenu(userList);
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (option < 0 || option > 7);
    }     
    public static void VerMenuGrupos(ListaUsuarios userList){          //OPCION 2      <<<<<     GRUPOS
        Scanner entrada = new Scanner(System.in);
        int option;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ver alumnos existentes");
            System.out.println("2. Eliminar alumno del grupo");
            System.out.println("3. Vaciar grupo ");
            System.out.println("0. Volver al menú principal");
            option = validarEnteros(entrada);
            switch (option) {
                case 1:
                    VerAlumnosEnGrupo(userList);
                    break;
                case 2:
                    EliminarAlumno(userList);
                    break;
                case 3:
                    VaciarGrupo(userList);                
                    break;
                case 0:
                    VerAdminMenu(userList);
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (option < 0 || option > 5);
    }                  
    public static void VerMenuAlumnos(ListaUsuarios userList){      //OPCION 3      <<<<<     ALUMNOS
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
        int semestre;
        int grupo;
        int repetir=2;
        do{
            do {
                System.out.println("Ingrese el semestre (1 al 6) al cual pertenece el alumno");
                semestre = validarEnteros(entrada);
                semestre--;
                if(semestre >= 0 && semestre <6){
                    do {
                        System.out.println("Grupos existentes en "+listaMaterias.getListaAsignaturas().get(semestre).getNombreAsignatura());
                        for(int i =0; i<listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().size();i++){
                            System.out.println((i+1)+". "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(i).getNombre());
                        }
                        System.out.println("Seleccione el numero del grupo al que pertenece el alumno");
                        grupo = validarEnteros(entrada);
                        grupo--;
                        if(grupo >= 0 && grupo < 10){                       
                            Alumno alumno = new Alumno();
                            entrada.nextLine();
                            System.out.println("Ingrese Nombre(s) del alumno: ");
                            String nombre = entrada.nextLine();
                            //entrada.nextLine();
                            System.out.println("Ingrese apellidos de " + nombre);
                            String apellidos = entrada.nextLine();
                            alumno.setNombre(nombre);
                            alumno.setApellidos(apellidos);
                            listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).addAlumno(alumno); 
                            System.out.println("Crear otro alumno?\n 1.si \nOtro numero: Volver al menú de alumnos");   
                            repetir = validarEnteros(entrada); 
                        }else{
                            System.out.println("Grupo invalido");
                        }
                    } while (grupo < 0 || grupo > 10);
                }else{
                    System.out.println("Semestre invalido");
                }
                
            } while (semestre <0 || semestre >5);
        }while(repetir == 1);
        VerMenuAlumnos(userList);
    }
    public static void EditarAlumno(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int semestre;
        int grupo;
        int alumno;
        impAsig();
        do {           
            System.out.println("Seleccione el semestre (1 al 6) de Orientación Educativa");
            semestre = validarEnteros(entrada);
            semestre--;
            if(semestre >= 0 && semestre < listaMaterias.getSize()){
                System.out.println("Grupos existentes dentro de "+listaMaterias.getListaAsignaturas().get(semestre).getNombreAsignatura()+": ");
                for(int i=0; i< 10 ;i++){
                System.out.println((i+1)+". "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(i).getNombre());                
                }
                do {   
                    System.out.println("Seleccione el numero de grupo donde se encuentra el alumno a editar");
                    grupo= validarEnteros(entrada);
                    grupo--;
                    if(grupo >=0 && grupo < listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().size()) {
                        System.out.println("Alumnos existentes en "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getNombre());
                        for(int j=0; j<listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().size();j++){
                            System.out.println((j+1)+". "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().get(j).getNombre()+" "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().get(j).getApellidos());
                        }
                        do {
                            System.out.println("Seleccione el numero del alumno a editar");
                            alumno = validarEnteros(entrada);
                            alumno--;
                            if(alumno >= 0 && alumno < listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().size()){
                                entrada.nextLine();
                                System.out.println("Ingrese nuevo nombre(s)");
                                String nuevoNombre=entrada.nextLine();
                                System.out.println("nuevo nombre: "+nuevoNombre);
                                System.out.println("Ingrese nuevos apellidos");
                                String nuevosApellidos=entrada.nextLine();
                                listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().get(alumno).setNombre(nuevoNombre);
                                listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().get(alumno).setApellidos(nuevosApellidos);
                                VerMenuAlumnos(userList);
                            }
                        } while (alumno <0 || alumno >= listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().size());                        
                    }else{
                        System.out.println("Rango de grupo invalido");
                    }
                        
                } while (grupo >0 || grupo >= listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().size());  ////aqui acaba 
            }else{
                System.out.println("El semestre no puede ser menor a 1 ni mayor a 6");
            }
        }while(semestre <0 || semestre >= listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().size());
        VerMenuAlumnos(userList);
    }
    public static void VerAlumnosEnGrupo(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int grupo;
        int semestre;
        do {
            System.out.println("Seleccione el semestre (numero del 1 al 6) donde se encuentra el grupo que desea visualizar");
            semestre = validarEnteros(entrada);
            semestre--;
            if(semestre >= 0 && semestre < 6){
                System.out.println("ENTRA ");
                for(int i = 0; i < listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().size(); i++){
                    System.out.println((i+1)+". "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(i).getNombre());
                }
                do {
                    System.out.println("Seleccione el numero del grupo");
                    grupo = validarEnteros(entrada);
                    grupo--;
                    if(grupo >=0 && grupo < listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().size()){
                        if(listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().size()!=0){
                            for(int j = 0; j< listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().size(); j++){
                                System.out.println((j+1)+". "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().get(j).getNombre()+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().get(j).getApellidos());
                            }
                        }else{
                            System.out.println("El grupo no cuenta con alumnos. \nRedirigiendo a crear alumnos");
                            CrearAlumno(userList);
                        }
                        System.out.println("Pulse un numero para volver al menú");
                        int numero = validarEnteros(entrada);
                        if(numero == 1){
                            VerMenuGrupos(userList);
                        }else{
                            VerMenuGrupos(userList);
                        }
                    }
                    
                } while (grupo < 0 || grupo >= listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().size());

            }else{
                System.out.println("El semestre no puede ser menor a 1 ni mayor a 6");
            }
        } while (semestre < 0 || semestre >6);
        VerMenuGrupos(userList);
    }
    public static void EliminarAlumno(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int materia;
        int grupo;
        int alumno;
        int eliminar;
        impAsig();
        do{
            System.out.println("Seleccione el semestre (numero)");
            materia = validarEnteros(entrada);
            materia--;
            if(materia >=0 && materia < 6){
                for(int i =0; i< listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().size();i++){
                    System.out.println((i+1)+". "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(i).getNombre());
                    do {
                        System.out.println("Seleccione el grupo donde se encuentra el alumno a editar");
                        grupo=validarEnteros(entrada);
                        grupo--;
                        if (grupo >=0 && grupo <10) {
                            if (listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(grupo).getAlumnos().size()==0) {
                                System.out.println("Este grupo no contiene alumnos.\nRedirigiendo al menu de Alumnos");
                                VerMenuAlumnos(userList);                                                                 
                            }
                            System.out.println("Alumnos dentro de "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(grupo).getNombre());
                            for(int k=0; k < listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(grupo).getAlumnos().size();k++){
                                System.out.println((k+1)+". "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(grupo).getAlumnos().get(k).getNombre()+" "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(grupo).getAlumnos().get(k).getApellidos());
                            }
                            do {
                                System.out.println("Seleccione el numero del alumno que desea eliminar");
                                alumno=validarEnteros(entrada);
                                alumno--;
                                if(alumno >=0 && alumno < listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(grupo).getAlumnos().size()){
                                    System.out.println("Realmente desea eliminar a "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(grupo).getAlumnos().get(alumno).getNombre()+" "+listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(grupo).getAlumnos().get(alumno).getApellidos()+"\n1. Si\n0. Otro numero: CANCELAR");
                                    eliminar = validarEnteros(entrada);
                                    if (eliminar==1) {
                                        listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(grupo).getAlumnos().remove(alumno);    
                                        VerMenuAlumnos(userList);   
                                    }else{
                                        System.out.println("Cancelando...");
                                        VerMenuAlumnos(userList);
                                    }
                                }
                            } while (alumno <0 || alumno >= listaMaterias.getListaAsignaturas().get(materia).getListaGrupos().get(grupo).getAlumnos().size());
                        }
                    } while (grupo<0 || grupo >= 10);
                }
            }
        }while(materia <0 || materia >= 10);   
        VerMenuAlumnos(userList);      
    }
    public static void VerMenuActividades(ListaUsuarios userList){      //OPCION 4      <<<<<     ACTIVIDADES
        Scanner entrada = new Scanner(System.in);
        int option;
        if(listaActividades.getSize()!=0){
            System.out.println("\n Actividades existentes: \n");
        }
        do{
            for(int i=0;i<listaActividades.getSize();i++){
                System.out.println((i+1)+". "+listaActividades.getListaActividades().get(i).getNombreAct());
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
    public static void AgregarActividadenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        int semestre;
        int actividad;
        if (listaActividades.getSize()==0) {
            System.out.println("Aun no existen Actividades, redirigiendo a crear nueva actividad");
            CrearActividad(userList);          
            } else {

                do {
                    System.out.println("Ingrese el semestre (1 al 6) al que desea agregar la actividad (la actividad se agregará a todos los grupos):");
                    semestre = validarEnteros(entrada);
                    semestre--;
                    if(semestre >= 0 && semestre <6){

                        do {
                            System.out.println("Seleccione el numero de actividad que desea asignar a "+listaMaterias.getListaAsignaturas().get(semestre).getNombreAsignatura());
                            for(int i = 0; i<listaActividades.getSize();i++){
                                System.out.println((i+1)+" "+listaActividades.getListaActividades().get(i).getNombreAct());
                            }
                            actividad=validarEnteros(entrada);
                            actividad--;
                            if (actividad >= 0 && actividad < listaActividades.getSize()) {
                                listaMaterias.getListaAsignaturas().get(semestre).addActividad(listaActividades.getListaActividades().get(actividad));
                                System.out.println("Actividad '"+listaActividades.getListaActividades().get(actividad).getNombreAct()+"' añadida a "+listaMaterias.getListaAsignaturas().get(semestre).getNombreAsignatura()+" correctamente.");
                                System.out.println();    
                            } else{
                                System.out.println("Opcion fuera de rango");
                            }   
                        } while (actividad < 0  || actividad >= listaActividades.getSize());    
                    }else{
                        System.out.println("El semestre no puede ser menor a 1 ni mayor a 6");
                    }     
                } while (semestre <0 || semestre >=6);
        VerMenuAsignatura(userList);
        }
    }
    public static void EliminarActividadenAsignatura(ListaUsuarios userList) {
        Scanner entrada = new Scanner(System.in);
        int semestre;
        int actividad;
        for(int i =0; i<listaMaterias.getSize();i++){
            System.out.println((i+1)+". "+listaMaterias.getListaAsignaturas().get(i).getNombreAsignatura());
        }
        do {
            System.out.println("Ingrese el semestre del que desea eliminar la actividad:");
            semestre = validarEnteros(entrada);
            semestre--;
            
            if(semestre >= 0 && semestre < 6 ){
                if(listaMaterias.getListaAsignaturas().get(semestre).getListaActividades().size()==0){
                    System.out.println("Este semestre aun no cuenta con actividades asignadas\nRedirigiendo a menú de asignaturas");
                    VerMenuAsignatura(userList);
                }
                for(int i = 0; i<listaMaterias.getListaAsignaturas().get(semestre).getListaActividades().size();i++){
                    System.out.println((i+1)+ ". "+listaMaterias.getListaAsignaturas().get(semestre).getListaActividades().get(i).getNombreAct());
                }
                do {
                    System.out.println("Seleccione el numero de la actividad a eliminar de "+listaMaterias.getListaAsignaturas().get(semestre).getNombreAsignatura());
                    actividad = validarEnteros(entrada);
                    actividad--;
                    if(actividad >= 0 && actividad < listaMaterias.getListaAsignaturas().get(semestre).getListaActividades().size()){
                        listaMaterias.getListaAsignaturas().get(semestre).removeActividad(listaMaterias.getListaAsignaturas().get(semestre).getListaActividades().get(actividad));
                        VerMenuAsignatura(userList);
                    }else{
                        System.out.println("Opcion fuera de rango");
                    }                    
                } while (actividad < 0 || actividad >= listaMaterias.getListaAsignaturas().get(semestre).getListaActividades().size());
            }
            
        } while (semestre <0 || semestre >=6); 
        VerMenuAsignatura(userList);
    }
    public static void VaciarGrupo(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);

        System.out.println("**ALERTA** Esta acción eliminará todos los alumnos del grupo y es irreversible\n1.si\nOtro numero: Regresar al menú anterior");
        int opcion= validarEnteros(entrada);
        int semestre;
        int grupo;
        int cancelar;
        if(opcion==1){ 
            do {
                System.out.println("Seleccione el semestre al que pertenece el grupo (1 al 6)");
                semestre = validarEnteros(entrada);
                semestre--;
                if(semestre >=0 && semestre <6){
                    for(int i = 0; i < listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().size(); i++){
                        System.out.println((i+1)+". "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(i).getNombre());
                    }
                    do {
                        System.out.println("Seleccione el numero del grupo del que desea eliminar TODOS los alumnos");
                        grupo=validarEnteros(entrada);
                        grupo--;
                        if(grupo >= 0 && grupo < 10){
                            System.out.println("Eliminar todos los alumnos del grupo "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getNombre());
                            System.out.println("1. Si\nOtro numero: Cancelar");
                            cancelar = validarEnteros(entrada);
                            if (cancelar == 1) {
                               
                                while(listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().size() !=0){
                                    listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).removeAlumno(listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().get(0));
                                }
                            }else{
                                VerMenuGrupos(userList);
                            }
                        }                        
                    } while (grupo <0 || grupo >= 10);
                }                
            } while (semestre <0 || semestre >6);               
        }else{
            VerMenuGrupos(userList);
        }      
        VerMenuGrupos(userList);        
    }
    public static void recibirActividad(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int continuar;
        int actividad;
        impAsig();
        System.out.println("Seleccione una materia");
        int asignatura =validarEnteros(entrada);
        asignatura--;
        do{
            if(asignatura >=0 && asignatura < 6){                
                for(int grupo = 0; grupo < listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().size();grupo++){
                    System.out.println((grupo+1)+". "+listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getNombre());
                }   
                System.out.println("Seleccione un grupo");
                int grupo = validarEnteros(entrada);
                grupo--;
                do{
                    if(grupo >= 0 && grupo < listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().size()){
                        for(int alumno=0; alumno< listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().size();alumno++){
                            System.out.println((alumno+1)+". "+listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().get(alumno).getNombre()+listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().get(alumno).getApellidos());
                        }
                        System.out.println("Seleccione el numero de alumno");
                        int alumno = validarEnteros(entrada);
                        alumno--;
                        do{
                            if(alumno >= 0 && alumno < listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().size()){
                                for(int act=0; act<listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().size();act++){
                                    System.out.println((act+1)+". "+listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().get(act).getNombreAct());
                                }
                                do {
                                    do{
                                    
                                        System.out.println("Seleccione el numero de actividad a recibir");
                                        actividad = validarEnteros(entrada);
                                        actividad--;
                                        if(actividad >= 0 && actividad < listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().size()){
                                            if(listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().get(alumno).getActividad().contains(listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().get(actividad))){
                                                System.out.println("El alumno ya entrego la actividad '"+listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().get(actividad).getNombreAct()+"' anteriormente");
                                            }else{
                                                listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().get(alumno).setActividad(listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().get(actividad));
                                                System.out.println("Actividad recibida: "+listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().get(actividad).getNombreAct());
                                                VerTeacherMenu(userList);
                                            }
                                        }else{
                                            System.out.println("Opcion invalida");
                                        }
                                        System.out.println("Recibir otra tarea \n1. Si\nOtro numero: No");
                                        continuar = validarEnteros(entrada);
                                        if(continuar !=1){
                                            VerTeacherMenu(userList);
                                        }
                                    } while (continuar==1);
                                }while(actividad<0 || actividad >= listaMaterias.getListaAsignaturas().get(asignatura).getListaActividades().size());
                            }else{
                                System.out.println("Opcion invalida");                                }
                        }while(alumno <0 && alumno >= listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().get(grupo).getAlumnos().size());
                    }else{
                        System.out.println("Opcion invalida"); 
                    }
                }while(grupo<0 || grupo > listaMaterias.getListaAsignaturas().get(asignatura).getListaGrupos().size());             
                
            }else{
                System.out.println("Opcion invalida");
            }
        }while(asignatura <0 || asignatura >= 6);   
        VerTeacherMenu(userList);     
    }

    public static void verAprobados(ListaUsuarios userList){
            Scanner entrada = new Scanner(System.in);
            impAsig();
            System.out.println("Seleccione una materia");
            int semestre=validarEnteros(entrada);
            semestre--;
            do{
                if (semestre >= 0 && semestre < listaMaterias.getListaAsignaturas().size()) {
                    for(int grupo = 0; grupo < listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().size();grupo++){
                        System.out.println((grupo+1)+". "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getNombre());
                    }   
                    System.out.println("Seleccione un grupo dentro de "+listaMaterias.getListaAsignaturas().get(semestre).getNombreAsignatura()+" para ver alumnos competentes");
                    int grupo = validarEnteros(entrada);
                    grupo--;
                    do{
                        for(int a=0; a< listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().size();a++){
                            if(listaMaterias.getListaAsignaturas().get(semestre).getListaActividades().size() == listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().get(a).getsizeAct()){
                                System.out.println("Nombre del alumno: "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().get(a).getNombre()+" "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(grupo).getAlumnos().get(a).getApellidos());
                                
                                VerTeacherMenu(userList);
                            }
                        }
                    }while(grupo <0 || grupo >= listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().size());       
                }else {
                    System.out.println("Opcion invalida");
                }
            }while(semestre <0 || semestre >= listaMaterias.getListaAsignaturas().size());
            VerTeacherMenu(userList);
        }

    public static void cancelarEntrega(ListaUsuarios userList){
        Scanner entrada = new Scanner(System.in);
        int semestre;
        int grupo;
        int alumno;
        int actividad;
        do {
            System.out.println("Seleccione el semestre del alumno (1-6)");
            semestre = validarEnteros(entrada);
            semestre--;
            if(semestre>=0 && semestre <6){
                for(int g = 0; g<10; g++){
                    System.out.println((g+1)+". "+listaMaterias.getListaAsignaturas().get(semestre).getListaGrupos().get(g).getNombre());
                }
                do {
                    grupo=validarEnteros(entrada);
                    grupo--;
                    if (grupo >= 0 && grupo < 10) {
                        //////////////      imprimir lista de alumnos, seleccionar un alumo e imprimir su array de actividades personales, seleccionar el index y eliminar el elemento correspondiente
                        
                    }
                    
                } while (grupo <0 || grupo >= 10);
            }
            
        } while (semestre <0 || semestre >= 6);
        

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
            System.out.println((i+1)+" "+listaGrupos.getListaGrupos().get(i).getNombre());
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
        }
        return input; 
    }
}   