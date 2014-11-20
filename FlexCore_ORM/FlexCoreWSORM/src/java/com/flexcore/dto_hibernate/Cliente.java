package com.flexcore.dto_hibernate;
// Generated Nov 17, 2014 12:34:42 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Cliente generated by hbm2java
 */
@MappedSuperclass

public class Cliente  implements java.io.Serializable {


     private Integer customerIF;
     private String nombre;
     private String direccion;
     private Integer telCasa;
     private Integer telOficina;
     private Integer celular;
     private Set cuentas = new HashSet(0);
     private Clientefisico clientefisico;
     private Clientejuridico clientejuridico;

    public Cliente() {
    }

	
    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    public Cliente(String nombre, String direccion, Integer telCasa, Integer telOficina, Integer celular, Set cuentas, Clientefisico clientefisico, Clientejuridico clientejuridico) {
       this.nombre = nombre;
       this.direccion = direccion;
       this.telCasa = telCasa;
       this.telOficina = telOficina;
       this.celular = celular;
       this.cuentas = cuentas;
       this.clientefisico = clientefisico;
       this.clientejuridico = clientejuridico;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="customerIF", unique=true, nullable=false)
    public Integer getCustomerIF() {
        return this.customerIF;
    }
    
    public void setCustomerIF(Integer customerIF) {
        this.customerIF = customerIF;
    }

    
    @Column(name="nombre", nullable=false, length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="direccion", length=100)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="telCasa")
    public Integer getTelCasa() {
        return this.telCasa;
    }
    
    public void setTelCasa(Integer telCasa) {
        this.telCasa = telCasa;
    }

    
    @Column(name="telOficina")
    public Integer getTelOficina() {
        return this.telOficina;
    }
    
    public void setTelOficina(Integer telOficina) {
        this.telOficina = telOficina;
    }

    
    @Column(name="celular")
    public Integer getCelular() {
        return this.celular;
    }
    
    public void setCelular(Integer celular) {
        this.celular = celular;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
    public Set<Cuenta> getCuentas() {
        return this.cuentas;
    }
    
    public void setCuentas(Set cuentas) {
        this.cuentas = cuentas;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="cliente")
    public Clientefisico getClientefisico() {
        return this.clientefisico;
    }
    
    public void setClientefisico(Clientefisico clientefisico) {
        this.clientefisico = clientefisico;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="cliente")
    public Clientejuridico getClientejuridico() {
        return this.clientejuridico;
    }
    
    public void setClientejuridico(Clientejuridico clientejuridico) {
        this.clientejuridico = clientejuridico;
    }




}


