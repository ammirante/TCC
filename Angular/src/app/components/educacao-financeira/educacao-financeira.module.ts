import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ContainerEducacaoFinanceiraComponent } from './containers/container-educacao-financeira/educacao-financeira.component';
import { EducacaoFinanceiraRoutingModule } from './educacao-financeira-routing.module';


@NgModule({
  declarations: [
    ContainerEducacaoFinanceiraComponent
  ],
  imports: [
    EducacaoFinanceiraRoutingModule,
    CommonModule
  ],
  entryComponents: [
  ],
  providers: [
  ]
})
export class EducacaoFinanceiraModule { }
