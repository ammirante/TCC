import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Norma } from './models/norma.model';

@Injectable({
  providedIn: 'root'
})
export class DocumentosService {

  constructor(private http: HttpClient) { }

  public getDocumentos(conteudo: string): Observable<Norma[]> {
    let params = new HttpParams();
    params = params.set('conteudo', conteudo);

    return this.http.get<Norma[]>('normativos?' + params);
  }
}

