import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Ocorrencia } from '../model/ocorrencia';

@Injectable({
  providedIn: 'root'
})
export class OcorrenciaService {

  constructor(
    private http: HttpClient
    ) { }
  
  listOcorrencias(): Observable<Ocorrencia[]>{
    const url = '/api/incidenciaExame';
    return this.http.get<Ocorrencia[]>(url);
  }
}
