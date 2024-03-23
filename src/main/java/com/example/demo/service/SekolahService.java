package com.example.demo.service;

import com.example.demo.model.SekolahModel;
import com.example.demo.repository.SekolahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SekolahService {
    @Autowired
    private SekolahRepository sekolahRepository;
    public List<SekolahModel> getAllData() {
        return sekolahRepository.findAll();
    }

    // untuk getById
    public Optional<SekolahModel> getById(Long id) {
        return sekolahRepository.findById(id);
    }
    // untuk Create Data
    public SekolahModel createData(SekolahModel sekolahModel) {
        return sekolahRepository.save(sekolahModel);
    }
    // tambah data getById
    public SekolahModel updateData(Long id,SekolahModel updatedSekolah) {
        Optional<SekolahModel> exiting = sekolahRepository.findById(id);
        if (exiting.isPresent()) {
            SekolahModel existingSiswa = exiting.get();
            existingSiswa.setNama_sekolah(updatedSekolah.getNama_sekolah());
            existingSiswa.setAlamat_sekolah(updatedSekolah.getAlamat_sekolah());
            existingSiswa.setEmail(updatedSekolah.getEmail());
            existingSiswa.setNo_telepon(updatedSekolah.getNo_telepon());
            existingSiswa.setMotto(updatedSekolah.getMotto());
            return sekolahRepository.save(existingSiswa);
        } else {
            throw new IllegalArgumentException("Id siswa" + " tidak di temukan");
        }
    }
    // untuk delete
    public void deleteData(Long id) {
        Optional<SekolahModel> hapusSekolah = sekolahRepository.findById(id);
        if (hapusSekolah.isPresent()) {
            sekolahRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Sekolah dengan id = " + id + " ,tidak ada!!!");
        }
    }
}
