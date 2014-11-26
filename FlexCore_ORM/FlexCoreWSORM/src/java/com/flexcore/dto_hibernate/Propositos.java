package com.flexcore.dto_hibernate;
// Generated Nov 17, 2014 12:34:42 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Propositos generated by hbm2java
 */
@XmlRootElement
@Entity
@Table(name="propositos"
    ,catalog="flexcore"
)
public class Propositos  implements java.io.Serializable {


     private int idcuentaPropositos;
     private String descripcion;
     private Set cuentaahorroautomaticos = new HashSet(0);
     private Set cuentaahorroautomaticos_1 = new HashSet(0);

    public Propositos() {
    }

	
    public Propositos(int idcuentaPropositos, String descripcion) {
        this.idcuentaPropositos = idcuentaPropositos;
        this.descripcion = descripcion;
    }
    public Propositos(int idcuentaPropositos, String descripcion, Set cuentaahorroautomaticos, Set cuentaahorroautomaticos_1) {
       this.idcuentaPropositos = idcuentaPropositos;
       this.descripcion = descripcion;
       this.cuentaahorroautomaticos = cuentaahorroautomaticos;
       this.cuentaahorroautomaticos_1 = cuentaahorroautomaticos_1;
    }
   
     @Id 

    @XmlElement
    @Column(name="idcuentaPropositos", unique=true, nullable=false)
    public int getIdcuentaPropositos() {
        return this.idcuentaPropositos;
    }
    
    public void setIdcuentaPropositos(int idcuentaPropositos) {
        this.idcuentaPropositos = idcuentaPropositos;
    }

    @XmlElement
    @Column(name="descripcion", nullable=false, length=50)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
 @XmlTransient
@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="propositosporcuenta", catalog="flexcore", joinColumns = { 
        @JoinColumn(name="idProposito", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="numCuenta", nullable=false, updatable=false) })
    public Set<Cuentaahorroautomatico> getCuentaahorroautomaticos() {
        return this.cuentaahorroautomaticos;
    }
    
    public void setCuentaahorroautomaticos(Set cuentaahorroautomaticos) {
        this.cuentaahorroautomaticos = cuentaahorroautomaticos;
    }
 @XmlTransient
@OneToMany(fetch=FetchType.LAZY, mappedBy="propositos")
    public Set<Cuentaahorroautomatico> getCuentaahorroautomaticos_1() {
        return this.cuentaahorroautomaticos_1;
    }
    
    public void setCuentaahorroautomaticos_1(Set cuentaahorroautomaticos_1) {
        this.cuentaahorroautomaticos_1 = cuentaahorroautomaticos_1;
    }




}


