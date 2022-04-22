package PaqueteUsuario;

public class clsUsuario1 {
    private int usuid;
    private String usunombre;
    private String usucontrasena;
    public clsUsuario1() {
    }

    public clsUsuario1(int p_usuid) {
        this.usuid = p_usuid;
    }
    
    public clsUsuario1(String p_usunombre, String p_usucontrasena) {
        this.usunombre = p_usunombre;
        this.usucontrasena = p_usucontrasena;
    }
    
    public clsUsuario1(int p_usuid, String p_usunombre, String p_usucontrasena) {
        this.usuid = p_usuid;
        this.usunombre = p_usunombre;
        this.usucontrasena = p_usucontrasena;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getUsuid() {
        return usuid;
    }

    public void setUsuid(int usuid) {
        this.usuid = usuid;
    }

    public String getUsunombre() {
        return usunombre;
    }

    public void setUsunombre(String usunombre) {
        this.usunombre = usunombre;
    }

    public String getUsucontrasena() {
        return usucontrasena;
    }

    public void setUsucontrasena(String usucontrasena) {
        this.usucontrasena = usucontrasena;
    }
}