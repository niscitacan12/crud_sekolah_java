package com.example.demo.controller;

import com.example.demo.model.KelasModel;
import com.example.demo.model.SiswaModel;
import com.example.demo.service.KelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/data_kelas")
public class KelasController {

    @Autowired
    private KelasService kelasService;
    @GetMapping
    public ResponseEntity<List<KelasModel>> getAllData(){
        List<KelasModel> kelasModels = kelasService.getAllData();
        return new ResponseEntity<>(kelasModels, HttpStatus.OK);
    }

    // untuk GetById
    @GetMapping("/{id}")
    public ResponseEntity<KelasModel> getById(@PathVariable Long id) {
        Optional<KelasModel> kelasModels = kelasService.getById(id);
        return kelasModels.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Untuk Add Data
    @PostMapping
    public ResponseEntity<KelasModel> createData(@RequestBody KelasModel kelasModel) {
        KelasModel newData = kelasService.createData(kelasModel);
        return new ResponseEntity<>(newData, HttpStatus.OK);
    }

    // tambah data
    @PutMapping("/{id}")
    public ResponseEntity<KelasModel> updateData(@PathVariable Long id, @RequestBody KelasModel ubahKelas) {
        KelasModel putKelas = kelasService.updateData(id, ubahKelas);
        return new ResponseEntity<>(putKelas, HttpStatus.OK);
    }

    // delete data
    @DeleteMapping("/hapus/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        kelasService.deleteData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
