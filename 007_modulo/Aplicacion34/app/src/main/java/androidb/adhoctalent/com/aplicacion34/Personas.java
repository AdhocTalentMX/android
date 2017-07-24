package androidb.adhoctalent.com.aplicacion34;


import com.google.gson.annotations.SerializedName;

public class Personas {
    @SerializedName("id")

    private int id;
    private String nombre;
    private String domicilio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
