package hu.Hercegno.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sarkany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nev;
    public String szin;

    @OneToMany(mappedBy = "sarkany")
    @JsonIgnore
    private List<Hercegno> hercegnok;

    public List<Hercegno> getHercegnok() {
        return hercegnok;
    }

    public void setHercegnok(List<Hercegno> hercegnok) {
        this.hercegnok = hercegnok;
    }

    public Sarkany() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    @Override
    public String toString() {
        return "Sarkany{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", szin='" + szin + '\'' +
                ", hercegnok=" + hercegnok +
                '}';
    }
}
