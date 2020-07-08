/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Artur
 */
@Entity
@Table(name = "SERIALE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seriale.findAll", query = "SELECT s FROM Seriale s")
    , @NamedQuery(name = "Seriale.findById", query = "SELECT s FROM Seriale s WHERE s.id = :id")
    , @NamedQuery(name = "Seriale.findByTytul", query = "SELECT s FROM Seriale s WHERE s.tytul = :tytul")})
public class Seriale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TYTUL")
    private String tytul;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSerial")
    private Collection<Odcinki> odcinkiCollection;

    public Seriale() {
    }

    public Seriale(Integer id) {
        this.id = id;
    }

    public Seriale(Integer id, String tytul) {
        this.id = id;
        this.tytul = tytul;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    @XmlTransient
    public Collection<Odcinki> getOdcinkiCollection() {
        return odcinkiCollection;
    }

    public void setOdcinkiCollection(Collection<Odcinki> odcinkiCollection) {
        this.odcinkiCollection = odcinkiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seriale)) {
            return false;
        }
        Seriale other = (Seriale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Seriale[ id=" + id + " ]";
    }
    
}
