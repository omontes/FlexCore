package com.flexcore.dto_hibernate;
// Generated Nov 17, 2014 12:34:42 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 * Cuenta generated by hbm2java
 */
@MappedSuperclass
public class Cuenta  implements java.io.Serializable {


     private Integer numCuenta;
     private Cliente cliente;
     private BigDecimal saldoTemporal;
     private BigDecimal saldoReal;
     private Boolean estadoCuenta;
     private Set transaccionesvuelos = new HashSet(0);
     private Set pagosesForIdCuentaDestino = new HashSet(0);
     private Set personasbeneficiariases = new HashSet(0);
     private Set dispositivoafiliados = new HashSet(0);
     private Cuentaahorroautomatico cuentaahorroautomatico;
     private Set retiroses = new HashSet(0);
     private Set historicotransaccionals = new HashSet(0);
     private Cuentaahorrovista cuentaahorrovista;
     private Set pagosesForIdCuentaOrigen = new HashSet(0);

    public Cuenta() {
    }

	
    public Cuenta(Cliente cliente, BigDecimal saldoTemporal, BigDecimal saldoReal) {
        this.cliente = cliente;
        this.saldoTemporal = saldoTemporal;
        this.saldoReal = saldoReal;
    }
    public Cuenta(Cliente cliente, BigDecimal saldoTemporal, BigDecimal saldoReal, Boolean estadoCuenta, Set transaccionesvuelos, Set pagosesForIdCuentaDestino, Set personasbeneficiariases, Set dispositivoafiliados, Cuentaahorroautomatico cuentaahorroautomatico, Set retiroses, Set historicotransaccionals, Cuentaahorrovista cuentaahorrovista, Set pagosesForIdCuentaOrigen) {
       this.cliente = cliente;
       this.saldoTemporal = saldoTemporal;
       this.saldoReal = saldoReal;
       this.estadoCuenta = estadoCuenta;
       this.transaccionesvuelos = transaccionesvuelos;
       this.pagosesForIdCuentaDestino = pagosesForIdCuentaDestino;
       this.personasbeneficiariases = personasbeneficiariases;
       this.dispositivoafiliados = dispositivoafiliados;
       this.cuentaahorroautomatico = cuentaahorroautomatico;
       this.retiroses = retiroses;
       this.historicotransaccionals = historicotransaccionals;
       this.cuentaahorrovista = cuentaahorrovista;
       this.pagosesForIdCuentaOrigen = pagosesForIdCuentaOrigen;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="numCuenta", unique=true, nullable=false)
    public Integer getNumCuenta() {
        return this.numCuenta;
    }
    
    public void setNumCuenta(Integer numCuenta) {
        this.numCuenta = numCuenta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCliente", nullable=false)
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    @Column(name="saldoTemporal", nullable=false, precision=15)
    public BigDecimal getSaldoTemporal() {
        return this.saldoTemporal;
    }
    
    public void setSaldoTemporal(BigDecimal saldoTemporal) {
        this.saldoTemporal = saldoTemporal;
    }

    
    @Column(name="saldoReal", nullable=false, precision=15)
    public BigDecimal getSaldoReal() {
        return this.saldoReal;
    }
    
    public void setSaldoReal(BigDecimal saldoReal) {
        this.saldoReal = saldoReal;
    }

    
    @Column(name="estadoCuenta")
    public Boolean getEstadoCuenta() {
        return this.estadoCuenta;
    }
    
    public void setEstadoCuenta(Boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cuenta")
    public Set<Transaccionesvuelo> getTransaccionesvuelos() {
        return this.transaccionesvuelos;
    }
    
    public void setTransaccionesvuelos(Set transaccionesvuelos) {
        this.transaccionesvuelos = transaccionesvuelos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cuentaByIdCuentaDestino")
    public Set<Pagos> getPagosesForIdCuentaDestino() {
        return this.pagosesForIdCuentaDestino;
    }
    
    public void setPagosesForIdCuentaDestino(Set pagosesForIdCuentaDestino) {
        this.pagosesForIdCuentaDestino = pagosesForIdCuentaDestino;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="cuentas")
    public Set<Personasbeneficiarias> getPersonasbeneficiariases() {
        return this.personasbeneficiariases;
    }
    
    public void setPersonasbeneficiariases(Set personasbeneficiariases) {
        this.personasbeneficiariases = personasbeneficiariases;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cuenta")
    public Set<Dispositivoafiliado> getDispositivoafiliados() {
        return this.dispositivoafiliados;
    }
    
    public void setDispositivoafiliados(Set dispositivoafiliados) {
        this.dispositivoafiliados = dispositivoafiliados;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="cuenta")
    public Cuentaahorroautomatico getCuentaahorroautomatico() {
        return this.cuentaahorroautomatico;
    }
    
    public void setCuentaahorroautomatico(Cuentaahorroautomatico cuentaahorroautomatico) {
        this.cuentaahorroautomatico = cuentaahorroautomatico;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cuenta")
    public Set<Retiros> getRetiroses() {
        return this.retiroses;
    }
    
    public void setRetiroses(Set retiroses) {
        this.retiroses = retiroses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cuenta")
    public Set<Historicotransaccional> getHistoricotransaccionals() {
        return this.historicotransaccionals;
    }
    
    public void setHistoricotransaccionals(Set historicotransaccionals) {
        this.historicotransaccionals = historicotransaccionals;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="cuenta")
    public Cuentaahorrovista getCuentaahorrovista() {
        return this.cuentaahorrovista;
    }
    
    public void setCuentaahorrovista(Cuentaahorrovista cuentaahorrovista) {
        this.cuentaahorrovista = cuentaahorrovista;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cuentaByIdCuentaOrigen")
    public Set<Pagos> getPagosesForIdCuentaOrigen() {
        return this.pagosesForIdCuentaOrigen;
    }
    
    public void setPagosesForIdCuentaOrigen(Set pagosesForIdCuentaOrigen) {
        this.pagosesForIdCuentaOrigen = pagosesForIdCuentaOrigen;
    }




}


