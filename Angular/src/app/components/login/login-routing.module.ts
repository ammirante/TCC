import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RecuperarSenhaComponent } from './components/recuperar-senha/recuperar-senha.component';
import { ContainerLoginComponent } from './containers/login-container.component';

const routes: Routes = [
  {
    path: '',
    component: ContainerLoginComponent,
    children: [
      {
        path: 'recuperar-senha',
        component: RecuperarSenhaComponent
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
