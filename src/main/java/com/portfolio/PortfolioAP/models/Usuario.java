package com.portfolio.PortfolioAP.models;

import javax.persistence.*;

@Table(name = "usuarios")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String mail;

    @Column
    private String sobre_mi;

    @Column
    private String ocupacion;

    @Column
    private String fecha_nacimiento;

    @Column
    private String nacionalidad;

    @Column
    private String imagen_perfil;

    @Column
    private String imagen_background;

    public Usuario(){

    }

    public Usuario(int id, String nombre, String apellido, String mail, String sobre_mi, String ocupacion, String fecha_nacimiento, String nacionalidad, String imagen_perfil, String imagen_background) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.sobre_mi = sobre_mi;
        this.ocupacion = ocupacion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.imagen_perfil = imagen_perfil;
        this.imagen_background = imagen_background;
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSobre_mi() {
        return sobre_mi;
    }

    public void setSobre_mi(String sobre_mi) {
        this.sobre_mi = sobre_mi;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getImagen_perfil() {
        return imagen_perfil;
    }

    public void setImagen_perfil(String imagen_perfil) {
        this.imagen_perfil = imagen_perfil;
    }

    public String getImagen_background() {
        return imagen_background;
    }

    public void setImagen_background(String imagen_background) {
        this.imagen_background = imagen_background;
    }

}
