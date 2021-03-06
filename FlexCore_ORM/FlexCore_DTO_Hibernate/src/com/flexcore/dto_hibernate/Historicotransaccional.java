package com.flexcore.dto_hibernate;
// Generated Nov 17, 2014 12:34:42 PM by Hibernate Tools 3.6.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Historicotransaccional generated by hbm2java
 */
@Entity
@Table(name="historicotransaccional"
    ,catalog="flexcore"
)
public class Historicotransaccional  implements java.io.Serializable {


     private Integer idhistoricoTransaccional;
     private Cuenta cuenta;
     private Tipomovimiento tipomovimiento;
     private Date fecha;

    public Historicotransaccional() {
    }

    public Historicotransaccional(Cuenta cuenta, Tipomovimiento tipomovimiento, Date fecha) {
       this.cuenta = cuenta;
       this.tipomovimiento = tipomovimiento;
       this.fecha = fecha;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idhistoricoTransaccional", unique=true, nullable=false)
    public Integer getIdhistoricoTransaccional() {
        return this.idhistoricoTransaccional;
    }
    
    public void setIdhistoricoTransaccional(Integer idhistoricoTransaccional) {
        this.idhistoricoTransaccional = idhistoricoTransaccional;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="numCuenta", nullable=false)
    public Cuenta getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipoMovimiento", nullable=false)
    public Tipomovimiento getTipomovimiento() {
        return this.tipomovimiento;
    }
    
    public void setTipomovimiento(Tipomovimiento tipomovimiento) {
        this.tipomovimiento = tipomovimiento;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=false, length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


