package com.portfolio.PortfolioAP.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String password;

    @Column
    private String email;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> educations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkExperience> experiences;

    public User(){

    }

    public User(int id, String nombre, String apellido, String mail, String sobre_mi, String ocupacion, String fecha_nacimiento, String nacionalidad, String imagen_perfil, String imagen_background) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = mail;
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

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
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
