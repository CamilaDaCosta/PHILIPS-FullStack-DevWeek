package com.dio.PHILIPSFullStackDevWeek.controller;

import com.dio.PHILIPSFullStackDevWeek.entity.Regiao;
import com.dio.PHILIPSFullStackDevWeek.repository.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegiaoController {
    private final RegiaoRepo REPOSITORY_R;

    public RegiaoController(RegiaoRepo repository) {
        REPOSITORY_R = repository;
    }

    @GetMapping("/regioes")
    public List<Regiao> getRegiao(){
        return REPOSITORY_R.findAll();
    }

    @GetMapping("/regioes/{id}")
    public ResponseEntity<?> getRegiaoById(@PathVariable Long id){
        Optional regiaoEscolhida =  REPOSITORY_R.findById(id);
        if (regiaoEscolhida.isPresent()){
            Object regiaoValidacao = regiaoEscolhida.get(); //ou cast
            return new ResponseEntity<>(regiaoValidacao, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regioes/novo")
    public Regiao postRegiao(@RequestBody Regiao regiao){
        return REPOSITORY_R.save(regiao);
    }

    @DeleteMapping("/regioes/delete/{id}")
    public void deleteRegiao(@PathVariable Long id){
        REPOSITORY_R.deleteById(id);
    }
}
