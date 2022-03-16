import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Faixaetaria } from '../model/faixaetaria';

@Injectable({
  providedIn: 'root'
})
export class FaixaEtariaService {

  constructor(
    private http: HttpClient
    ) { }
  
  listFaixas(): Observable<Faixaetaria[]>{
    const url = '/api/faixaEtaria';
    return this.http.get<Faixaetaria[]>(url);
  }
}
