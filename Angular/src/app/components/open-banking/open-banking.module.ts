import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ContainerOpenBankingComponent } from './containers/container-open-banking/container-open-banking.component';
import { OpenBankingRoutingModule } from './open-banking-routing.module';


@NgModule({
  declarations: [
    ContainerOpenBankingComponent
  ],
  imports: [
    OpenBankingRoutingModule,
    CommonModule
  ],
  entryComponents: [
  ],
  providers: [
  ]
})
export class OpenBankingModule { }
