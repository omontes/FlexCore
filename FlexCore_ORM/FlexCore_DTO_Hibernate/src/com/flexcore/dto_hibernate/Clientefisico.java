package com.flexcore.dto_hibernate;
// Generated Nov 17, 2014 12:34:42 PM by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Clientefisico generated by hbm2java
 */
@Entity
@Table(name="clientefisico"
    ,catalog="flexcore"
)
public class Clientefisico  implements java.io.Serializable {


     private int idClienteFisico;
     private Cliente cliente;
     private int cedula;
     private String fotografia;
     private String primerApellido;
     private String segundoApellido;

    public Clientefisico() {
    }

	
    public Clientefisico(Cliente cliente, int cedula) {
        this.cliente = cliente;
        this.cedula = cedula;
    }
    public Clientefisico(Cliente cliente, int cedula, String fotografia, String primerApellido, String segundoApellido) {
       this.cliente = cliente;
       this.cedula = cedula;
       this.fotografia = fotografia;
       this.primerApellido = primerApellido;
       this.segundoApellido = segundoApellido;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="cliente"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="idClienteFisico", unique=true, nullable=false)
    public int getIdClienteFisico() {
        return this.idClienteFisico;
    }
    
    public void setIdClienteFisico(int idClienteFisico) {
        this.idClienteFisico = idClienteFisico;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    @Column(name="cedula", nullable=false)
    public int getCedula() {
        return this.cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    
    @Column(name="fotografia", length=45)
    public String getFotografia() {
        return this.fotografia;
    }
    
    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    
    @Column(name="primerApellido", length=45)
    public String getPrimerApellido() {
        return this.primerApellido;
    }
    
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    
    @Column(name="segundoApellido", length=45)
    public String getSegundoApellido() {
        return this.segundoApellido;
    }
    
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }




}


