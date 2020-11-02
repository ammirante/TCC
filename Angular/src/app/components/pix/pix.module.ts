import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ContainerPIXComponent } from './containers/container-pix/pix.component';
import { PIXRoutingModule } from './pix-routing.module';


@NgModule({
  declarations: [
    ContainerPIXComponent
  ],
  imports: [
    PIXRoutingModule,
    CommonModule
  ],
  entryComponents: [
  ],
  providers: [
  ]
})
export class PIXModule { }
