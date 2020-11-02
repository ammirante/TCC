import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContainerBlogComponent } from './containers/container-educacao-financeira/blog.component';

const routes: Routes = [
  {
    path: '',
    component: ContainerBlogComponent,
    children: [
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BlogRoutingModule { }
