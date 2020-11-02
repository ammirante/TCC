import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DominioCategoria } from './models/dominio-categoria.model';
import { PostagemDTO } from './models/postagem-dto.model';
import { Postagem } from './models/postagem.model';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  constructor(private http: HttpClient) { }

  public getCategorias(): Observable<DominioCategoria[]> {
    return this.http.get<DominioCategoria[]>('categorias');
  }

  public adicionarPostagem(postagem: PostagemDTO): Observable<any> {
    return this.http.post<PostagemDTO>('postagens', postagem);
  }

  public getPostagens(): Observable<Postagem[]> {
    return this.http.get<Postagem[]>('postagens');
  }
}

