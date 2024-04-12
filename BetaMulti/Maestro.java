public class Maestro extends Usuario {
    public Maestro(String u_name) {
        super(u_name);
        System.out.println("Contraseña de Maestro " + u_name + ": " + getPassword());
    }

    @Override
    protected String generatePassword() {
        // Generar contraseña para Maestro basada en el nombre y dos números aleatorios
        
        int num1 = 0;
        int num2 = 1;
        return u_name + num1 + num2;
    }
}
