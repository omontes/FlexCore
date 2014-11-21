package com.flexcore.dto_hibernate;
// Generated Nov 17, 2014 12:34:42 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tipostiempo generated by hbm2java
 */
@Entity(name="tipostiempo")
@Table(name="tipostiempo"
    ,catalog="flexcore"
)
public class Tipostiempo  implements java.io.Serializable {


     private int idTiempo;
     private String descripcion;
     private Set cuentaahorroautomaticos = new HashSet(0);

    public Tipostiempo() {
    }

	
    public Tipostiempo(int idTiempo) {
        this.idTiempo = idTiempo;
    }
    public Tipostiempo(int idTiempo, String descripcion, Set cuentaahorroautomaticos) {
       this.idTiempo = idTiempo;
       this.descripcion = descripcion;
       this.cuentaahorroautomaticos = cuentaahorroautomaticos;
    }
   
     @Id 

    
    @Column(name="idTiempo", unique=true, nullable=false)
    public int getIdTiempo() {
        return this.idTiempo;
    }
    
    public void setIdTiempo(int idTiempo) {
        this.idTiempo = idTiempo;
    }

    
    @Column(name="descripcion", length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tipostiempo")
    public Set<Cuentaahorroautomatico> getCuentaahorroautomaticos() {
        return this.cuentaahorroautomaticos;
    }
    
    public void setCuentaahorroautomaticos(Set cuentaahorroautomaticos) {
        this.cuentaahorroautomaticos = cuentaahorroautomaticos;
    }




}

