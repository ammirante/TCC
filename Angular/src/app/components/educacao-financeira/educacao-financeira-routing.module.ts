import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContainerEducacaoFinanceiraComponent } from './containers/container-educacao-financeira/educacao-financeira.component';

const routes: Routes = [
  {
    path: '',
    component: ContainerEducacaoFinanceiraComponent,
    children: [
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EducacaoFinanceiraRoutingModule { }
