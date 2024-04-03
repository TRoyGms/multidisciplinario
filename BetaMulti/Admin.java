public class Admin extends Usuario {
    public String getPassword(){
        return this.password;}

    public Admin(String u_name, String password) {
        super(u_name, password);
    }

}
