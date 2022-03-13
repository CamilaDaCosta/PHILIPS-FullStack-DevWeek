import { Component, OnInit } from '@angular/core';
import { Regiao } from '../model/regiao';
import { RegiaoService } from '../service/regiao.service';

@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.css']
})
export class OcorrenciasComponent implements OnInit {
  /**
   * variável do tipo Região que recebe um vetor
   */
  regioes: Regiao[] = [];

  /**
   * realiza a injeção de dependências
   */
  constructor(private regiaoService:RegiaoService) { }

  /**
   * Quando o componente for inicializado vai realizar a função
   */
  ngOnInit(): void {
    this.regioes = this.regiaoService.listRegioes();
  }

}
