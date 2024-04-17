package com.example.demo.dto;

public class MapelDTO {
    private String deskripsi;
    private String nama_mapel;
    private int tahun_ajaran;
    private String tingkat_kelas;

    // getters and setters

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getNama_mapel() {
        return nama_mapel;
    }

    public void setNama_mapel(String nama_mapel) {
        this.nama_mapel = nama_mapel;
    }

    public int getTahun_ajaran() {
        return tahun_ajaran;
    }

    public void setTahun_ajaran(int tahun_ajaran) {
        this.tahun_ajaran = tahun_ajaran;
    }

    public String getTingkat_kelas() {
        return tingkat_kelas;
    }

    public void setTingkat_kelas(String tingkat_kelas) {
        this.tingkat_kelas = tingkat_kelas;
    }
}