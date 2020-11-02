import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AngularEditorModule } from '@kolkov/angular-editor';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';
import { EscapeHtmlPipe } from 'src/app/util/escape-html.pipe';
import { ContainerDocumentosComponent } from './containers/container-educacao-financeira/documentos.component';
import { DocumentosRoutingModule } from './documentos-routing.module';
import { DocumentosService } from './documentos.service';
import { DocumentoEffects } from './effects/documento.effects';
import * as documentoReducer from './reducers/documento.reducer';

@NgModule({
  declarations: [
    ContainerDocumentosComponent,
    EscapeHtmlPipe
  ],
  imports: [
    DocumentosRoutingModule,
    CommonModule,
    FormsModule,
    AngularEditorModule,
    EffectsModule.forFeature([DocumentoEffects]),
    StoreModule.forFeature('recuperarDocumentos', documentoReducer.reducer),
    NgbModule,
  ],
  entryComponents: [
  ],
  providers: [
    DocumentosService
  ],
  exports: [
    EscapeHtmlPipe
  ]
})
export class DocumentosModule { }
