package com.flexcore.dto_hibernate;
// Generated Nov 17, 2014 12:34:42 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Cuentaahorroautomatico generated by hbm2java
 */
@Entity
@Table(name="cuentaahorroautomatico"
    ,catalog="flexcore"
)
public class Cuentaahorroautomatico extends Cuenta implements java.io.Serializable {


     private int numCuenta;
     private Propositos propositos;
     private Cuenta cuenta;
     private Tipostiempo tipostiempo;
     private int tiempoDeducciones;
     private Date fechaInicio;
     private int tiempoAhorroMeses;
     private Integer numCuentaDeduccion;
     private BigDecimal montoAhorro;
     private boolean estadoAhorro;
     private Date fechaUltimaActualizacion;
     private Set propositoses = new HashSet(0);
     private int idCliente;
     private int idProposito;
     private int tipoTiempo;
    public Cuentaahorroautomatico() {
    }

	
    public Cuentaahorroautomatico(Propositos propositos, Cuenta cuenta, Tipostiempo tipostiempo, int tiempoDeducciones, Date fechaInicio, int tiempoAhorroMeses, BigDecimal montoAhorro, boolean estadoAhorro, Date fechaUltimaActualizacion) {
        this.propositos = propositos;
        this.cuenta = cuenta;
        this.tipostiempo = tipostiempo;
        this.tiempoDeducciones = tiempoDeducciones;
        this.fechaInicio = fechaInicio;
        this.tiempoAhorroMeses = tiempoAhorroMeses;
        this.montoAhorro = montoAhorro;
        this.estadoAhorro = estadoAhorro;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }
    public Cuentaahorroautomatico(Propositos propositos, Cuenta cuenta, Tipostiempo tipostiempo, int tiempoDeducciones, Date fechaInicio, int tiempoAhorroMeses, Integer numCuentaDeduccion, BigDecimal montoAhorro, boolean estadoAhorro, Date fechaUltimaActualizacion, Set propositoses) {
       this.propositos = propositos;
       this.cuenta = cuenta;
       this.tipostiempo = tipostiempo;
       this.tiempoDeducciones = tiempoDeducciones;
       this.fechaInicio = fechaInicio;
       this.tiempoAhorroMeses = tiempoAhorroMeses;
       this.numCuentaDeduccion = numCuentaDeduccion;
       this.montoAhorro = montoAhorro;
       this.estadoAhorro = estadoAhorro;
       this.fechaUltimaActualizacion = fechaUltimaActualizacion;
       this.propositoses = propositoses;
    }
   
    
    
    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idProposito", nullable=false)
    public Propositos getPropositos() {
        return this.propositos;
    }
    
    public void setPropositos(Propositos propositos) {
        this.propositos = propositos;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Cuenta getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipoTiempo", nullable=false)
    public Tipostiempo getTipostiempo() {
        return this.tipostiempo;
    }
    
    public void setTipostiempo(Tipostiempo tipostiempo) {
        this.tipostiempo = tipostiempo;
    }

    
    @Column(name="tiempoDeducciones", nullable=false)
    public int getTiempoDeducciones() {
        return this.tiempoDeducciones;
    }
    
    public void setTiempoDeducciones(int tiempoDeducciones) {
        this.tiempoDeducciones = tiempoDeducciones;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaInicio", nullable=false, length=19)
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    
    @Column(name="tiempoAhorroMeses", nullable=false)
    public int getTiempoAhorroMeses() {
        return this.tiempoAhorroMeses;
    }
    
    public void setTiempoAhorroMeses(int tiempoAhorroMeses) {
        this.tiempoAhorroMeses = tiempoAhorroMeses;
    }

    
    @Column(name="numCuentaDeduccion")
    public Integer getNumCuentaDeduccion() {
        return this.numCuentaDeduccion;
    }
    
    public void setNumCuentaDeduccion(Integer numCuentaDeduccion) {
        this.numCuentaDeduccion = numCuentaDeduccion;
    }

    
    @Column(name="montoAhorro", nullable=false, precision=15)
    public BigDecimal getMontoAhorro() {
        return this.montoAhorro;
    }
    
    public void setMontoAhorro(BigDecimal montoAhorro) {
        this.montoAhorro = montoAhorro;
    }

    
    @Column(name="estadoAhorro", nullable=false)
    public boolean isEstadoAhorro() {
        return this.estadoAhorro;
    }
     /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public void setEstadoAhorro(boolean estadoAhorro) {
        this.estadoAhorro = estadoAhorro;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaUltimaActualizacion", nullable=false, length=19)
    public Date getFechaUltimaActualizacion() {
        return this.fechaUltimaActualizacion;
    }
    
    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="propositosporcuenta", catalog="flexcore", joinColumns = { 
        @JoinColumn(name="numCuenta", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="idProposito", nullable=false, updatable=false) })
    public Set<Propositos> getPropositoses() {
        return this.propositoses;
    }
    
    public void setPropositoses(Set propositoses) {
        this.propositoses = propositoses;
    }

    /**
     * @return the idProposito
     */
    public int getIdProposito() {
        return idProposito;
    }

    /**
     * @param idProposito the idProposito to set
     */
    public void setIdProposito(int idProposito) {
        this.idProposito = idProposito;
    }

    /**
     * @return the tipoTiempo
     */
    public int getTipoTiempo() {
        return tipoTiempo;
    }

    /**
     * @param tipoTiempo the tipoTiempo to set
     */
    public void setTipoTiempo(int tipoTiempo) {
        this.tipoTiempo = tipoTiempo;
    }




}

