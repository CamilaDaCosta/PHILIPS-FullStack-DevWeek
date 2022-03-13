package com.dio.PHILIPSFullStackDevWeek.controller;

import com.dio.PHILIPSFullStackDevWeek.entity.IncidenciaExame;
import com.dio.PHILIPSFullStackDevWeek.repository.IncidenciaExameRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class IncidenciaExameController {
    private final IncidenciaExameRepo REPOSITORY_I;

    public IncidenciaExameController(IncidenciaExameRepo repository_i) {
        REPOSITORY_I = repository_i;
    }

    @GetMapping("/incidenciaExame")
    public ResponseEntity<List<IncidenciaExame>> findOcorrencias(){
        List<IncidenciaExame> listaIncidencias = REPOSITORY_I.findAll();
        if (listaIncidencias.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(listaIncidencias, HttpStatus.OK);
    }

    @GetMapping("/incidenciaExame/{id}")
    public ResponseEntity<IncidenciaExame> findOcorrenciasById(@PathVariable Long id){
        Optional<IncidenciaExame> incidenciaEscolhida = REPOSITORY_I.findById(id);
        if (incidenciaEscolhida.isPresent()){
            IncidenciaExame incidenciaEscolhidaValidacao = incidenciaEscolhida.get();
            return new ResponseEntity<>(incidenciaEscolhidaValidacao, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidenciaExame/novo")
    public IncidenciaExame postIncidencia(@RequestBody IncidenciaExame incidenciaExame){
        return REPOSITORY_I.save(incidenciaExame);
    }
}
