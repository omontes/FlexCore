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
 * Clientejuridico generated by hbm2java
 */
@Entity
@Table(name="clientejuridico"
    ,catalog="flexcore"
)
public class Clientejuridico extends Cliente implements java.io.Serializable {


     private int idclienteJuridico;
     private Cliente cliente;
     private int cedulaJuridica;

    public Clientejuridico() {
    }

    public Clientejuridico(Cliente cliente, int cedulaJuridica) {
       this.cliente = cliente;
       this.cedulaJuridica = cedulaJuridica;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="cliente"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="idclienteJuridico", unique=true, nullable=false)
    public int getIdclienteJuridico() {
        return this.idclienteJuridico;
    }
    
    public void setIdclienteJuridico(int idclienteJuridico) {
        this.idclienteJuridico = idclienteJuridico;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    @Column(name="cedulaJuridica", nullable=false)
    public int getCedulaJuridica() {
        return this.cedulaJuridica;
    }
    
    public void setCedulaJuridica(int cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }




}

