import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AutenticacaoDTO } from './models/autenticacao-dto.model';

@Injectable({
    providedIn: 'root'
})
export class LoginService {

    constructor(private http: HttpClient) { }

    public recuperarSenha(usuario: string, email: string): Observable<any> {
        let params = new HttpParams();
        params = params.set('login', usuario);
        params = params.set('email', email);

        return this.http.get<any>('usuarios/recuperar-senha?' + params);
    }

    public autenticar(usuario: string, senha: string): Observable<AutenticacaoDTO> {
        let params = new HttpParams();

        params = params.set('login', usuario);
        params = params.set('senha', senha);

        return this.http.get<AutenticacaoDTO>('usuarios/login?' + params);
    }

}

