package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "data_siswa")
public class SiswaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nama_siswa")
    private String nama_siswa;
    @Column(name = "nisn")
    private Long nisn;
    @Column(name = "kelas")
    private String kelas;
    @Column(name = "jurusan")
    private String jurusan;
    @Column(name = "umur")
    private int umur;
    @Column(name = "alamat")
    private String alamat;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }
    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public Long getNisn() {
        return nisn;
    }
    public void setNisn(Long nisn) {
        this.nisn = nisn;
    }

    public String getKelas() {
        return kelas;
    }
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJurusan() {
        return jurusan;
    }
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public int getUmur() {
        return umur;
    }
    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
