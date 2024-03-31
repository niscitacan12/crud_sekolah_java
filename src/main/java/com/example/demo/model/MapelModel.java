package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "data_mapel")
public class MapelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "nama_mapel")
    private String nama_mapel;
    @Column (name = "tingkat_kelas")
    private String tingkat_kelas;
    @Column (name = "deskripsi")
    private String deskripsi;
    @Column (name = "tahun_ajaran")
    private int tahun_ajaran;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_mapel() {
        return nama_mapel;
    }

    public void setNama_mapel(String nama_mapel) {
        this.nama_mapel = nama_mapel;
    }

    public String getTingkat_kelas() {
        return tingkat_kelas;
    }

    public void setTingkat_kelas(String tingkat_kelas) {
        this.tingkat_kelas = tingkat_kelas;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getTahun_ajaran() {
        return tahun_ajaran;
    }

    public void setTahun_ajaran(int tahun_ajaran) {
        this.tahun_ajaran = tahun_ajaran;
    }
}
