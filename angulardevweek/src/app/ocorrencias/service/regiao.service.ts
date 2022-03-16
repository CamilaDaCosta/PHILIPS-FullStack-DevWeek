import { Injectable } from '@angular/core';
import { Regiao } from '../model/regiao';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegiaoService {

  constructor(
    /**
     * variavel do tipo HttpClient que possui os métodos de requisição http
     */
    private http: HttpClient
  ) { }

  /**
   * função listRegioes que irá retornar um vetor de Regiao
   */
  listRegioes(): Observable<Regiao[]>{
    const url = '/api/regioes';
    return this.http.get<Regiao[]>(url);
  }
}
