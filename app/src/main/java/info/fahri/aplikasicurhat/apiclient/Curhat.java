package info.fahri.aplikasicurhat.apiclient;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Curhat implements Serializable{
    @SerializedName("id")
    private int id;
    @SerializedName("nama")
    private String nama;
    @SerializedName("konten")
    private String konten;

    public Curhat() {
    }

    public Curhat(int id, String nama, String konten) {
        this.id = id;
        this.nama = nama;
        this.konten = konten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }
}
