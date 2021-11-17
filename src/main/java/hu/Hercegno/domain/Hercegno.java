package hu.Hercegno.domain;

import javax.persistence.*;

@Entity
public class Hercegno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  int id;
    public String nev;
    public int kor;
    public int rabsagban;

    @ManyToOne
    @JoinColumn(name = "sarkany")
    public Sarkany sarkany;
    public Hercegno() {
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

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getRabsagban() {
        return rabsagban;
    }

    public void setRabsagban(int rabsagban) {
        this.rabsagban = rabsagban;
    }


    @Override
    public String toString() {
        return "Hercegno{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", kor=" + kor +
                ", rabsagban=" + rabsagban +
                ", sarkanyok=" + sarkany +
                '}';
    }
}
