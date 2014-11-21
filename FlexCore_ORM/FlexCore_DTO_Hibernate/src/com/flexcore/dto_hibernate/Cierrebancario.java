package com.flexcore.dto_hibernate;
// Generated Nov 17, 2014 12:34:42 PM by Hibernate Tools 3.6.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Cierrebancario generated by hbm2java
 */
@Entity
@Table(name="cierrebancario"
    ,catalog="flexcore"
)
public class Cierrebancario  implements java.io.Serializable {


     private Integer idcierreBancario;
     private Date fecha;
     private boolean estadoCierre;
     private Integer cantidadRegistrosModificados;

    public Cierrebancario() {
    }

	
    public Cierrebancario(Date fecha, boolean estadoCierre) {
        this.fecha = fecha;
        this.estadoCierre = estadoCierre;
    }
    public Cierrebancario(Date fecha, boolean estadoCierre, Integer cantidadRegistrosModificados) {
       this.fecha = fecha;
       this.estadoCierre = estadoCierre;
       this.cantidadRegistrosModificados = cantidadRegistrosModificados;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idcierreBancario", unique=true, nullable=false)
    public Integer getIdcierreBancario() {
        return this.idcierreBancario;
    }
    
    public void setIdcierreBancario(Integer idcierreBancario) {
        this.idcierreBancario = idcierreBancario;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=false, length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="estadoCierre", nullable=false)
    public boolean isEstadoCierre() {
        return this.estadoCierre;
    }
    
    public void setEstadoCierre(boolean estadoCierre) {
        this.estadoCierre = estadoCierre;
    }

    
    @Column(name="cantidadRegistrosModificados")
    public Integer getCantidadRegistrosModificados() {
        return this.cantidadRegistrosModificados;
    }
    
    public void setCantidadRegistrosModificados(Integer cantidadRegistrosModificados) {
        this.cantidadRegistrosModificados = cantidadRegistrosModificados;
    }




}

