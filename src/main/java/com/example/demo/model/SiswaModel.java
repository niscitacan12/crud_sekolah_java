package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "data_siswa")
public class SiswaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_siswa")
    private String nama_siswa;
    @Column(name = "nisn")
    private int nisn;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "tanggal_lahir")
    private String tanggal_lahir;
    @ManyToOne
    @JoinColumn(name = "kelas_id")
    private KelasModel kelasModel;

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
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }
    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public int getNisn() {
        return nisn;
    }
    public void setNisn(int nisn) {
        this.nisn = nisn;
    }

    public KelasModel getKelasModel() {
        return kelasModel;
    }
    public void setKelasModel(KelasModel kelasModel) {
        this.kelasModel = kelasModel;
    }
}
