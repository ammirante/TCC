import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { exhaustMap, map } from 'rxjs/operators';
import { DocumentosActions } from '../actions';
import { DocumentosService } from '../documentos.service';

@Injectable()
export class DocumentoEffects {

    constructor(
        private actions$: Actions,
        private documentoService: DocumentosService,
    ) { }

    recuperarDocumentos$ = createEffect(
        () => this.actions$.pipe(
            ofType(DocumentosActions.recuperarDocumentos),
            exhaustMap(action =>
                this.documentoService.getDocumentos(action.conteudo).pipe(
                    map(normas => DocumentosActions.recuperarDocumentosSuccess({ retorno: normas }))
                )
            )
        )
    );
}