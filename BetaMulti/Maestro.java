import java.util.Random;    // Libreria de generacion de numeros Random

public class Maestro extends Usuario {
    public Maestro(String u_name) {
        super(u_name);
        // Mostrar las contraseñas del usuario/perfil
        System.out.println("Contraseña de " + u_name + ": " + getPassword());
    }

    @Override
    /* Indica que este método sobrescribe un método de la superclase.
    Ayuda a mejorar la legibilidad y a prevenir errores al asegurar que el 
    método realmente sobrescribe un método existente en la jerarquía de clases. */
    protected String generatePassword() {
        // Obtener las iniciales de cada palabra en el nombre
        String[] parts = u_name.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String part : parts) {
            initials.append(part.substring(0, 1).toUpperCase());
        }

        // Generar contraseña para Maestro basada en las iniciales y dos números aleatorios
        Random rand = new Random();
        /* Generar numeros aleatorios para el Password */
        int num1 = rand.nextInt(10);
        int num2 = rand.nextInt(10);
        int num3 = rand.nextInt(10);
        return initials.toString() + num1 + num2 + num3;
    }
}