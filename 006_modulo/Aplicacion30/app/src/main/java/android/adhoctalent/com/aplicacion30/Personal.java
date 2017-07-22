package android.adhoctalent.com.aplicacion30;

/**
 * Description:
 * <p>
 * Copyright 2017 AdhocTalent
 * <p>
 * Created by luiscobian on 7/21/17.
 * Edit by ---- on 7/21/17
 */

public class Personal {

    private String nombre;
    private String telefono;


    public Personal(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
