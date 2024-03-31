package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "data_kelas")
public class KelasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_kelas")
    private  String nama_kelas;
    @Column(name = "nama_jurusan")
    private String nama_jurusan;
    @Column (name = "keterangan")
    private String keterangan;
    @Column (name = "tingkat_kelas")
    private String tingkat_kelas;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }
    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getNama_jurusan() {
        return nama_jurusan;
    }
    public void setNama_jurusan(String nama_jurusan) {
        this.nama_jurusan = nama_jurusan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTingkat_kelas() {
        return tingkat_kelas;
    }

    public void setTingkat_kelas(String tingkat_kelas) {
        this.tingkat_kelas = tingkat_kelas;
    }
}
