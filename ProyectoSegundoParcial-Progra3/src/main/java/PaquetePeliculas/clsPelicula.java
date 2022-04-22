package PaquetePeliculas;

public class clsPelicula {
    private int peli_id;
    private String peli_nombre;
    private String peli_clasif;
    private String peli_estado;

    public clsPelicula() {
    }

    public clsPelicula(int peli_id) {
        this.peli_id = peli_id;
    }
    
    public clsPelicula(String peli_nombre, String peli_clasif , String peli_estado) {
        this.peli_nombre = peli_nombre;
        this.peli_clasif = peli_clasif;
        this.peli_estado = peli_estado;
    }
    
    public clsPelicula(int peli_id, String peli_nombre, String peli_clasif , String peli_estado) {
        this.peli_id = peli_id;
        this.peli_nombre = peli_nombre;
        this.peli_clasif = peli_clasif;
        this.peli_estado = peli_estado;
    }
    

    public int getPeli_Id() {
        return peli_id;
    }

    public void setPeli_Id(int peli_id) {
        this.peli_id = peli_id;
    }

    public String getPeli_nombre() {
        return peli_nombre;
    }

    public void setPeli_nombre(String peli_nombre) {
        this.peli_nombre = peli_nombre;
    }

    public String getPeli_clasif() {
        return peli_clasif;
    }

    public void setPeli_clasif(String peli_clasif) {
        this.peli_clasif = peli_clasif;
    }

    public String getPeli_estado() {
        return peli_estado;
    }

    public void setPeli_estado(String peli_estado) {
        this.peli_estado = peli_estado;
    }


    @Override
    public String toString() {
        return "peilculas{" + "id_pelicula=" +peli_id  + ", nombre_pelicula=" + peli_nombre + ", clasif_pelicula=" + peli_clasif + ", estado_pelicula="+ peli_estado + '}';
    }
    
    
}
