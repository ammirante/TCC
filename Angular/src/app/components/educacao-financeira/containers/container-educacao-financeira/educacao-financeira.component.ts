import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-container-educacao-financeira',
  templateUrl: './educacao-financeira.component.html',
  styleUrls: ['./educacao-financeira.component.scss']
})
export class ContainerEducacaoFinanceiraComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  redirecionarBACEN(): void {
    window.open('https://www.bcb.gov.br/cidadaniafinanceira', '_blank');
  }
}
