package com.example.demo.dto;

public class KelasDTO {
    private String keterangan;
    private String nama_jurusan;
    private String nama_kelas;
    private String tingkat_kelas;

    // getters and setters

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNama_jurusan() {
        return nama_jurusan;
    }

    public void setNama_jurusan(String nama_jurusan) {
        this.nama_jurusan = nama_jurusan;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getTingkat_kelas() {
        return tingkat_kelas;
    }

    public void setTingkat_kelas(String tingkat_kelas) {
        this.tingkat_kelas = tingkat_kelas;
    }
}