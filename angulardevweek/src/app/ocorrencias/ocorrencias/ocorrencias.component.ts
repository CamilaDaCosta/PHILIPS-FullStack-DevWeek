import { Component, OnInit } from '@angular/core';
import { Faixaetaria } from '../model/faixaetaria';
import { Ocorrencia } from '../model/ocorrencia';
import { Regiao } from '../model/regiao';
import { FaixaEtariaService } from '../service/faixa-etaria.service';
import { OcorrenciaService } from '../service/ocorrencia.service';
import { RegiaoService } from '../service/regiao.service';

@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.css']
})
export class OcorrenciasComponent implements OnInit {
  /**
   * variável do tipo Região que recebe um vetor
   * variável para cada model service
   */
  regioes: Regiao[] = [];
  faixaetaria: Faixaetaria[] = [];
  ocorrencias: Ocorrencia[] = [];
  /**
   * realiza a injeção de dependências para cada classe service
   */
  constructor(
      private regiaoService:RegiaoService,
      private faixaetariaService: FaixaEtariaService,
      private ocorrenciaService: OcorrenciaService
    ) { }

  /**
   * Quando o componente for inicializado vai realizar a função
   */
  ngOnInit(): void {
    this.regiaoService.listRegioes().subscribe(regioes => this.regioes = regioes);
    this.faixaetariaService.listFaixas().subscribe(faixaetaria => this.faixaetaria = faixaetaria);
    this.ocorrenciaService.listOcorrencias().subscribe(ocorrencias => this.ocorrencias = ocorrencias);
  }

}
