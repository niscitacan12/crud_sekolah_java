package com.example.demo.service;

import com.example.demo.model.SiswaModel;
import com.example.demo.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiswaService {
    @Autowired
    private SiswaRepository siswaRepository;
    public List<SiswaModel> getAllData() {
        return siswaRepository.findAll();
    }

    // untuk getById
    public Optional<SiswaModel> getById(Long id) {
        return siswaRepository.findById(id);
    }
    // untuk Create Data
    public SiswaModel createData(SiswaModel siswaModel) {
        return siswaRepository.save(siswaModel);
    }
    // tambah data getById
    public SiswaModel updateData(Long id,SiswaModel updatedSiswa) {
        Optional<SiswaModel> exiting = siswaRepository.findById(id);
        if (exiting.isPresent()) {
            SiswaModel existingSiswa = exiting.get();
            existingSiswa.setNisn(updatedSiswa.getNisn());
            existingSiswa.setNama_siswa(updatedSiswa.getNama_siswa());
            existingSiswa.setUmur(updatedSiswa.getUmur());
            existingSiswa.setAlamat(updatedSiswa.getAlamat());
            existingSiswa.setKelas(updatedSiswa.getKelas());
            existingSiswa.setJurusan(updatedSiswa.getJurusan());
            return siswaRepository.save(existingSiswa);
        } else {
            throw new IllegalArgumentException("Id siswa" + " tidak di temukan");
        }
    }
    // untuk delete
    public void deleteData(Long id) {
        Optional<SiswaModel> hapusSiswa = siswaRepository.findById(id);
        if (hapusSiswa.isPresent()) {
            siswaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Siswa dengan id = " + id + " ,tidak ada!!!");
        }
    }
}
