public class Maestro extends Usuario {
    public String getPassword(){
        return this.password;}

    public Maestro(String u_name, String password) {
        super(u_name, password);
    }
}
