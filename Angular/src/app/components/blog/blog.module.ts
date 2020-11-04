import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AngularEditorModule} from '@kolkov/angular-editor';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {EffectsModule} from '@ngrx/effects';
import {StoreModule} from '@ngrx/store';
import {BlogRoutingModule} from './blog-routing.module';
import {ContainerBlogComponent} from './containers/container-educacao-financeira/blog.component';
import {CategoriaEffects} from './effects/categoria.effects';
import {PostagemEffects} from './effects/postagem.effects';
import * as categoriaReducer from './reducers/categoria.reducer';
import * as postagemReducer from './reducers/postagem.reducer';
import {TruncarTextoPipe} from '../../directives/truncar-texto.pipe';

@NgModule({
  declarations: [
    ContainerBlogComponent,
    TruncarTextoPipe
  ],
  imports: [
    BlogRoutingModule,
    CommonModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
    AngularEditorModule,
    EffectsModule.forFeature([CategoriaEffects, PostagemEffects]),
    StoreModule.forFeature('recuperarCategorias', categoriaReducer.reducer),
    StoreModule.forFeature('recuperarPostagens', postagemReducer.reducer),
  ],
  entryComponents: [],
  providers: []
})
export class BlogModule {
}
