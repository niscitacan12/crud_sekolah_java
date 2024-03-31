package com.example.demo.service;

import com.example.demo.model.GuruModel;
import com.example.demo.model.MapelModel;
import com.example.demo.model.SiswaModel;
import com.example.demo.repository.MapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapelService {
    @Autowired
    private MapelRepository mapelRepository;
    public List<MapelModel> getAllData() {
        return mapelRepository.findAll();
    }

    // untuk getById
    public Optional<MapelModel> getById(Long id) {
        return mapelRepository.findById(id);
    }
    // untuk Create Data
    public MapelModel createData(MapelModel MapelModel) {
        return mapelRepository.save(MapelModel);
    }

    // tambah data getById
    public MapelModel updateData(Long id, MapelModel updatedMapel) {
        Optional<MapelModel> exiting = mapelRepository.findById(id);
        if (exiting.isPresent()) {
            MapelModel existingMapel = exiting.get();
            existingMapel.setNama_mapel(updatedMapel.getNama_mapel());
            existingMapel.setTingkat_kelas(updatedMapel.getTingkat_kelas());
            existingMapel.setDeskripsi(updatedMapel.getDeskripsi());
            existingMapel.setTahun_ajaran(updatedMapel.getTahun_ajaran());
            return mapelRepository.save(existingMapel);
        } else {
            throw new IllegalArgumentException("Id Mapel" + " tidak di temukan");
        }
    }
    // untuk delete
    public void deleteData(Long id) {
        Optional<MapelModel> hapusMapel = mapelRepository.findById(id);
        if (hapusMapel.isPresent()) {
            mapelRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Mapel dengan id = " + id + " ,tidak ada!!!");
        }
    }
}
