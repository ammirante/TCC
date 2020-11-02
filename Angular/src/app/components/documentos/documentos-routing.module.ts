import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContainerDocumentosComponent } from './containers/container-educacao-financeira/documentos.component';

const routes: Routes = [
  {
    path: '',
    component: ContainerDocumentosComponent,
    children: [
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DocumentosRoutingModule { }
