package com.example.demo.controller;

import com.example.demo.model.SekolahModel;
import com.example.demo.model.SiswaModel;
import com.example.demo.service.SekolahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/data_sekolah")
public class SekolahController {

    @Autowired
    private SekolahService sekolahService;
    @GetMapping
    public ResponseEntity<List<SekolahModel>> getAllData(){
        List<SekolahModel> SekolahModels = sekolahService.getAllData();
        return new ResponseEntity<>(SekolahModels, HttpStatus.OK);
    }

    //Untuk GetById
    @GetMapping("/{id}")
    public ResponseEntity<SekolahModel> getById(@PathVariable Long id) {
        Optional<SekolahModel> sekolahModels = sekolahService.getById(id);
        return sekolahModels.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Untuk Add Data
    @PostMapping
    public ResponseEntity<SekolahModel> createData(@RequestBody SekolahModel sekolahModel) {
        SekolahModel newData = sekolahService.createData(sekolahModel);
        return new ResponseEntity<>(newData, HttpStatus.OK);
    }

    // tambah data
    @PutMapping("/{id}")
    public ResponseEntity<SekolahModel> updateData(@PathVariable Long id, @RequestBody SekolahModel ubahSekolah) {
        SekolahModel putSekolah = sekolahService.updateData(id, ubahSekolah);
        return new ResponseEntity<>(putSekolah, HttpStatus.OK);
    }

    // delete data
    @DeleteMapping("/hapus/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        sekolahService.deleteData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
