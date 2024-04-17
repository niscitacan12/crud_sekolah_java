package com.example.demo.service;

import com.example.demo.model.GuruModel;
import com.example.demo.repository.GuruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuruService {
    @Autowired
    private GuruRepository guruRepository;
    public List<GuruModel> getAllData() {
        return guruRepository.findAll();
    }

    // untuk getById
    public Optional<GuruModel> getById(Long id) {
        return guruRepository.findById(id);
    }
    // untuk Create Data
    public GuruModel createData(GuruModel GuruModel) {
        return guruRepository.save(GuruModel);
    }
    // tambah data getById
    public GuruModel updateData(Long id,GuruModel updatedGuru) {
        Optional<GuruModel> exiting = guruRepository.findById(id);
        if (exiting.isPresent()) {
            GuruModel existingGuru = exiting.get();
            existingGuru.setNama_guru(updatedGuru.getNama_guru());
            existingGuru.setEmail(updatedGuru.getEmail());
            existingGuru.setJabatan(updatedGuru.getJabatan());
            existingGuru.setJenis_kelamin(updatedGuru.getJenis_kelamin());
            existingGuru.setMapelModel(updatedGuru.getMapelModel());
            return guruRepository.save(existingGuru);
        } else {
            throw new IllegalArgumentException("Id siswa" + " tidak di temukan");
        }
    }
    // untuk delete
    public void deleteData(Long id) {
        Optional<GuruModel> hapusSekolah = guruRepository.findById(id);
        if (hapusSekolah.isPresent()) {
            guruRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Sekolah dengan id = " + id + " ,tidak ada!!!");
        }
    }
}
