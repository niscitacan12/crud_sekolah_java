package com.example.demo.controller;

import com.example.demo.model.GuruModel;
import com.example.demo.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/data_guru")
public class GuruController {

    @Autowired
    private GuruService guruService;
    @GetMapping("/all")
    public ResponseEntity<List<GuruModel>> getAllData(){
        List<GuruModel> guruModels = guruService.getAllData();
        return new ResponseEntity<>(guruModels, HttpStatus.OK);
    }

    //Untuk GetById
    @GetMapping("/{id}")
    public ResponseEntity<GuruModel> getById(@PathVariable Long id) {
        Optional<GuruModel> sekolahModels = guruService.getById(id);
        return sekolahModels.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Untuk Add Data
    @PostMapping("/add")
    public ResponseEntity<GuruModel> createData(@RequestBody GuruModel guruModel) {
        GuruModel newData = guruService.createData(guruModel);
        return new ResponseEntity<>(newData, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuruModel> updateData(@PathVariable Long id, @RequestBody GuruModel ubahGuru) {
        GuruModel putSekolah = guruService.updateData(id, ubahGuru);
        return new ResponseEntity<>(putSekolah, HttpStatus.OK);
    }

    // delete data
    @DeleteMapping("/hapus/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        guruService.deleteData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
