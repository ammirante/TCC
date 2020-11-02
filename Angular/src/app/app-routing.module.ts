import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TemplateComponent } from './components/template/template.component';

const routes: Routes = [
  {
    path: '',
    component: TemplateComponent,
    children: [
      {
        path: '',
        component: HomeComponent,
        data: {
          breadcrumb: 'Início'
        }
      },
      {
        path: 'open-banking',
        loadChildren: () => import('./components/open-banking/open-banking.module').then(m => m.OpenBankingModule),
        data: {
          breadcrumb: 'Open Banking'
        }
      },
      {
        path: 'pix',
        loadChildren: () => import('./components/pix/pix.module').then(m => m.PIXModule),
        data: {
          breadcrumb: 'PIX'
        }
      },
      {
        path: 'educacao-financeira',
        loadChildren: () => import('./components/educacao-financeira/educacao-financeira.module').then(m => m.EducacaoFinanceiraModule),
        data: {
          breadcrumb: 'Educação Financeira'
        }
      },
      {
        path: 'documentos',
        loadChildren: () => import('./components/documentos/documentos.module').then(m => m.DocumentosModule),
        data: {
          breadcrumb: 'Documentos'
        }
      },
      {
        path: 'blog',
        loadChildren: () => import('./components/blog/blog.module').then(m => m.BlogModule),
        data: {
          breadcrumb: 'Blog'
        }
      },
      {
        path: 'login',
        loadChildren: () => import('./components/login/login.module').then(m => m.LoginModule),
        data: {
          breadcrumb: 'Login'
        }
      }
    ]
  },
  /*{
    path: 'forbidden', // Quando o usuário não pode acessar o componente baseado no AuthGuard
    component: ForbiddenComponent
  },*/
  /*{
    path: '**', component: NotFoundComponent// Componente apresentado quando a rota não existe
  },*/
];
@NgModule({
  imports: [RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
