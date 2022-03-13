package com.dio.PHILIPSFullStackDevWeek.controller;

import com.dio.PHILIPSFullStackDevWeek.entity.FaixaEtaria;
import com.dio.PHILIPSFullStackDevWeek.repository.FaixaEtariaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FaixaEtariaController {

    private final FaixaEtariaRepo REPOSITORY_F;

    public FaixaEtariaController(FaixaEtariaRepo repository) {
        REPOSITORY_F = repository;
    }

    @GetMapping("/faixaEtaria")
    public ResponseEntity<?> findAllFaixaEtaria(){
        try{
            List<FaixaEtaria> lista = REPOSITORY_F.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaEtaria/{id}")
    public ResponseEntity<FaixaEtaria> findByIdFaixaEtaria(@PathVariable Long id){
        try{
            Optional<FaixaEtaria> faixaescolhida = REPOSITORY_F.findById(id);
            if (faixaescolhida.isPresent()){
                FaixaEtaria faixaEtariaValidacao = faixaescolhida.get();
                return new ResponseEntity<>(faixaEtariaValidacao, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaEtaria/novo")
    public FaixaEtaria postFaixaEtaria(@RequestBody FaixaEtaria faixaEtaria){
        return REPOSITORY_F.save(faixaEtaria);
    }
    @DeleteMapping("/faixaEtaria/remover/{id}")
    public void deleteFaixaEtaria(@PathVariable Long id){
        REPOSITORY_F.deleteById(id);
    }

}
