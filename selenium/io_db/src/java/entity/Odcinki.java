/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Artur
 */
@Entity
@Table(name = "ODCINKI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odcinki.findAll", query = "SELECT o FROM Odcinki o")
    , @NamedQuery(name = "Odcinki.findById", query = "SELECT o FROM Odcinki o WHERE o.id = :id")
    , @NamedQuery(name = "Odcinki.findByTytul", query = "SELECT o FROM Odcinki o WHERE o.tytul = :tytul")})
public class Odcinki implements Serializable {

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
    @JoinColumn(name = "ID_SERIAL", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Seriale idSerial;

    public Odcinki() {
    }

    public Odcinki(Integer id) {
        this.id = id;
    }

    public Odcinki(Integer id, String tytul) {
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

    public Seriale getIdSerial() {
        return idSerial;
    }

    public void setIdSerial(Seriale idSerial) {
        this.idSerial = idSerial;
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
        if (!(object instanceof Odcinki)) {
            return false;
        }
        Odcinki other = (Odcinki) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Odcinki[ id=" + id + " ]";
    }
    
}
