package com.flexcore.dto_hibernate;
// Generated Nov 17, 2014 12:34:42 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
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
 * Pagos generated by hbm2java
 */
@Entity
@Table(name="pagos"
    ,catalog="flexcore"
)
public class Pagos  implements java.io.Serializable {


     private Integer idPago;
     private Cuenta cuentaByIdCuentaDestino;
     private Cuenta cuentaByIdCuentaOrigen;
     private BigDecimal monto;
     private Date fecha;
     private int idCuentaDestino;
     private int idCuentaOrigen;

    public Pagos() {
    }

    public Pagos(Cuenta cuentaByIdCuentaDestino, Cuenta cuentaByIdCuentaOrigen, BigDecimal monto, Date fecha) {
       this.cuentaByIdCuentaDestino = cuentaByIdCuentaDestino;
       this.cuentaByIdCuentaOrigen = cuentaByIdCuentaOrigen;
       this.monto = monto;
       this.fecha = fecha;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idPago", unique=true, nullable=false)
    public Integer getIdPago() {
        return this.idPago;
    }
    
    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCuentaDestino", nullable=false)
    public Cuenta getCuentaByIdCuentaDestino() {
        return this.cuentaByIdCuentaDestino;
    }
    
    public void setCuentaByIdCuentaDestino(Cuenta cuentaByIdCuentaDestino) {
        this.cuentaByIdCuentaDestino = cuentaByIdCuentaDestino;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCuentaOrigen", nullable=false)
    public Cuenta getCuentaByIdCuentaOrigen() {
        return this.cuentaByIdCuentaOrigen;
    }
    
    public void setCuentaByIdCuentaOrigen(Cuenta cuentaByIdCuentaOrigen) {
        this.cuentaByIdCuentaOrigen = cuentaByIdCuentaOrigen;
    }

    
    @Column(name="monto", nullable=false, precision=15)
    public BigDecimal getMonto() {
        return this.monto;
    }
    
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=false, length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the idCuentaDestino
     */
    public int getIdCuentaDestino() {
        return idCuentaDestino;
    }

    /**
     * @param idCuentaDestino the idCuentaDestino to set
     */
    public void setIdCuentaDestino(int idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    /**
     * @return the idCuentaOrigen
     */
    public int getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    /**
     * @param idCuentaOrigen the idCuentaOrigen to set
     */
    public void setIdCuentaOrigen(int idCuentaOrigen) {
        this.idCuentaOrigen = idCuentaOrigen;
    }




}


