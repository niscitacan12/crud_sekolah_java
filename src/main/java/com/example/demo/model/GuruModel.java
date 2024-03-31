package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "data_guru")
public class GuruModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_guru")
    private String nama_guru;
    @Column(name = "jenis_kelamin")
    private String jenis_kelamin;
    @Column(name = "email")
    private String email;
    @Column(name = "jabatan")
    private String jabatan;
    @ManyToOne
    @JoinColumn(name = "mapel_id")
    private MapelModel mapelModel;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public MapelModel getMapelModel() {
        return mapelModel;
    }
    public void setMapelModel(MapelModel mapelModel) {
        this.mapelModel = mapelModel;
    }
}
