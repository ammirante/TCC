import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContainerPIXComponent } from './containers/container-pix/pix.component';

const routes: Routes = [
  {
    path: '',
    component: ContainerPIXComponent,
    children: [
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PIXRoutingModule { }
