package com.flexcore.dto_hibernate;
// Generated Nov 17, 2014 12:34:42 PM by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Dispositivoafiliado generated by hbm2java
 */
@Entity
@Table(name="dispositivoafiliado"
    ,catalog="flexcore"
)
public class Dispositivoafiliado  implements java.io.Serializable {


     private int idTarjeta;
     private Cuenta cuenta;
     private boolean estado;

    public Dispositivoafiliado() {
    }

    public Dispositivoafiliado(int idTarjeta, Cuenta cuenta, boolean estado) {
       this.idTarjeta = idTarjeta;
       this.cuenta = cuenta;
       this.estado = estado;
    }
   
     @Id 

    
    @Column(name="idTarjeta", unique=true, nullable=false)
    public int getIdTarjeta() {
        return this.idTarjeta;
    }
    
    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCuenta", nullable=false)
    public Cuenta getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    
    @Column(name="Estado", nullable=false)
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }




}


