public class Usuario {
    private String u_name;
    private String password;

    public Usuario(String u_name, String password) {
        this.u_name = u_name;
        this.password = password;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String username, String password) {
        // Verificar si el nombre de usuario y la contraseña coinciden
        return this.u_name.equals(username) && this.password.equals(password);
    }
}
