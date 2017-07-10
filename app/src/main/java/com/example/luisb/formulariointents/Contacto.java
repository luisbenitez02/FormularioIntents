package com.example.luisb.formulariointents;

/**
 * Created by luisb on 8/07/2017.
 */

public class Contacto {
    private String nombre;
    private String telefono;
    private String email;
    private String nacimiento;
    private String descript;

    public Contacto(String nombre, String telefono, String email, String nacimiento, String descript) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.nacimiento = nacimiento;
        this.descript = descript;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
