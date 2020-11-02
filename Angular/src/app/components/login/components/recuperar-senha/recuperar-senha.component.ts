import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { recuperarSenha } from '../../actions/login.action';

@Component({
    selector: 'app-recuperar-senha',
    templateUrl: './recuperar-senha.component.html',
    styleUrls: ['./recuperar-senha.component.scss']
})
export class RecuperarSenhaComponent implements OnInit, OnDestroy {

    private readonly LOGIN = '/login';

    formularioRecuperarSenha = new FormGroup({
        usuario: new FormControl(null, [Validators.required]),
        email: new FormControl(null, [Validators.required])
    });

    constructor(
        private router: Router,
        private store: Store<any>
    ) { }

    ngOnInit(): void {

    }

    ngOnDestroy(): void {

    }

    recuperarSenha(): void {
        const usuarioForm = this.formularioRecuperarSenha.get('usuario').value;
        const emailForm = this.formularioRecuperarSenha.get('email').value;
        this.store.dispatch(recuperarSenha({ usuario: usuarioForm, email: emailForm }));
        this.router.navigate([this.LOGIN]);
    }
}
