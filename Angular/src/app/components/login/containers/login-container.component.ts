import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NavigationEnd, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Subscription } from 'rxjs';
import { filter } from 'rxjs/operators';
import { autenticar } from '../actions/login.action';

@Component({
    selector: 'app-container-login',
    templateUrl: './login-container.component.html',
    styleUrls: ['./login-container.component.scss']
})
export class ContainerLoginComponent implements OnInit, OnDestroy {

    private readonly RECUPERAR_SENHA = '/login/recuperar-senha';

    formularioLogin = new FormGroup({
        usuario: new FormControl(null, [Validators.required]),
        senha: new FormControl(null, [Validators.required])
    });
    subscriptions: Subscription[] = [];
    login = true;

    constructor(
        private router: Router,
        private store: Store<any>
    ) { }

    ngOnInit(): void {
        this.subscriptions.push(
            this.router.events.pipe(
                filter(event => event instanceof NavigationEnd)).
                subscribe((event: NavigationEnd) => {
                    if ('/login' === event.url) {
                        this.login = true;
                    } else {
                        this.login = false;
                    }
                })
        );
    }

    ngOnDestroy(): void {

    }

    recuperarSenha(): void {
        this.router.navigate([this.RECUPERAR_SENHA]);
    }

    autenticar(): void {
        const usuarioForm = this.formularioLogin.get('usuario').value;
        const senhaForm = this.formularioLogin.get('senha').value;
        this.store.dispatch(autenticar({ usuario: usuarioForm, senha: senhaForm }));
    }
}
