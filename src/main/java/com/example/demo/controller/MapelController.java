package com.example.demo.controller;

import com.example.demo.model.MapelModel;
import com.example.demo.service.MapelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/data_mapel")
@CrossOrigin(origins = "*")
public class MapelController {

    @Autowired
    private MapelService mapelService;
    @GetMapping
    public ResponseEntity<List<MapelModel>> getAllData(){
        List<MapelModel> mapelModels = mapelService.getAllData();
        return new ResponseEntity<>(mapelModels, HttpStatus.OK);
    }

    // untuk GetById
    @GetMapping("/mapel/{id}")
    public ResponseEntity<MapelModel> getById(@PathVariable Long id) {
        Optional<MapelModel> mapelModels = mapelService.getById(id);
        return mapelModels.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Untuk Add Data
    @PostMapping
    public ResponseEntity<MapelModel> createData(@RequestBody MapelModel mapelModel) {
        MapelModel newData = mapelService.createData(mapelModel);
        return new ResponseEntity<>(newData, HttpStatus.OK);
    }

    // tambah data
    @PutMapping("/{id}")
    public ResponseEntity<MapelModel> updateData(@PathVariable Long id, @RequestBody MapelModel ubahMapel) {
        MapelModel putMapel = mapelService.updateData(id, ubahMapel);
        return new ResponseEntity<>(putMapel, HttpStatus.OK);
    }

    // delete data
    @DeleteMapping("/hapus/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        mapelService.deleteData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
