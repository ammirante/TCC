import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContainerOpenBankingComponent } from './containers/container-open-banking/container-open-banking.component';

const routes: Routes = [
  {
    path: '',
    component: ContainerOpenBankingComponent,
    children: [
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OpenBankingRoutingModule { }
