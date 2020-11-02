import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { select, Store } from '@ngrx/store';
import { Observable, of, Subscription } from 'rxjs';
import { StorageService } from 'src/app/util/storage.service';
import { StateLogin } from '../login/reducers/login.reducer';

@Component({
  selector: 'app-template',
  templateUrl: './template.component.html',
  styleUrls: ['./template.component.scss']
})
export class TemplateComponent implements OnInit {
  private readonly OPEN_BANKING = '/open-banking';
  private readonly PIX = '/pix';
  private readonly EDUCACAO_FINANCEIRA = '/educacao-financeira';
  private readonly DOCUMENTOS = '/documentos';
  private readonly BLOG = '/blog';
  private readonly LOGIN = '/login';

  isAutenticado = false;
  autenticacao$: Observable<StateLogin> = of();
  subscriptions: Subscription[] = [];

  constructor(
    private router: Router,
    private storageService: StorageService,
    private store: Store<any>
  ) { }

  ngOnInit(): void {
    this.autenticacao$ = this.store.pipe(select('recuperarUsuario'));

    this.subscriptions.push(this.autenticacao$.subscribe(retorno => {
      if (retorno.isAuthenticated) {
        localStorage.setItem('token', retorno.autenticado.token);
        localStorage.setItem('nomeUsuario', retorno.autenticado.nomeUsuario);
        this.isAutenticado = true;
      } else {
        localStorage.clear();
      }
    }));
  }

  redirecionarParaOpenBanking(): void {
    this.router.navigate([this.OPEN_BANKING]);
  }

  redirecionarParaPIX(): void {
    this.router.navigate([this.PIX]);
  }

  redirecionarParaEducacaoFinanceira(): void {
    this.router.navigate([this.EDUCACAO_FINANCEIRA]);
  }

  redirecionarParaDocumentos(): void {
    this.router.navigate([this.DOCUMENTOS]);
  }

  redirecionarParaBlog(): void {
    this.router.navigate([this.BLOG]);
  }

  redirecionarParaLogin(): void {
    this.router.navigate([this.LOGIN]);
  }
}
