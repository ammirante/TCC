import { Component, OnDestroy, OnInit } from '@angular/core';
import { select, Store } from '@ngrx/store';
import { Observable, of, Subscription } from 'rxjs';
import { recuperarDocumentos } from '../../actions/documento.actions';
import { Norma } from '../../models/norma.model';
import { State } from '../../reducers/documento.reducer';

@Component({
  selector: 'app-container-documentos',
  templateUrl: './documentos.component.html',
  styleUrls: ['./documentos.component.scss']
})
export class ContainerDocumentosComponent implements OnInit, OnDestroy {

  pesquisa: string;
  normativos$: Observable<State> = of();
  normativos: Norma[] = [];
  subscriptions: Subscription[] = [];
  normaAssunto = '';

  constructor(
    private store: Store<any>,
  ) { }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  pesquisar(): void {
    this.store.dispatch(recuperarDocumentos({ conteudo: this.pesquisa }));
    this.normativos$ = this.store.pipe(select('recuperarDocumentos'));

    this.subscriptions.push(this.normativos$.subscribe(retorno => {
      this.normativos = retorno.retornoBacen;
    }));
  }

  converterData(data: string): string {
    return data.substring(8, 10).concat('/').concat(data.substring(5, 7)).concat('/').concat(data.substring(0, 4));
  }

  redirecionarBACEN(tipo: string, numero: number): void {
    window.open(`https://www.bcb.gov.br/estabilidadefinanceira/exibenormativo?tipo=${tipo}&numero=${numero}`, '_blank');
  }

}
