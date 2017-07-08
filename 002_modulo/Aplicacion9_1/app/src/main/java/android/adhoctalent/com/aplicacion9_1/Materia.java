package android.adhoctalent.com.aplicacion9_1;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class Materia {
    String nombre;
    float calificaciones;

    public Materia(String nombre, float calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(float calificaciones) {
        this.calificaciones = calificaciones;
    }
}
