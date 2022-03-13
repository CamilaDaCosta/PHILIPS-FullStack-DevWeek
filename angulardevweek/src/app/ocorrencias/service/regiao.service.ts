import { Injectable } from '@angular/core';
import { Regiao } from '../model/regiao';

@Injectable({
  providedIn: 'root'
})
export class RegiaoService {

  constructor() { }

  /**
   * função listRegioes que irá retornar um vetor de Regiao
   */
  listRegioes(): Regiao[]{
    return [
      {id: 1, regiao: 'Norte', total_exames: 1564}
    ]
  }
}
