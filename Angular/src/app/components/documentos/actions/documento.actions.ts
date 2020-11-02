import { createAction, props } from '@ngrx/store';
import { Norma } from '../models/norma.model';

export enum DocumentosActionTypes {
    RecuperarDocumentos = '[DOCUMENTO] RecuperarDocumentos',
    RecuperarDocumentosSuccess = '[DOCUMENTO] RecuperarDocumentosSuccess',
    RecuperarDocumentosFailure = '[DOCUMENTO] RecuperarDocumentosFailure',
}

export const recuperarDocumentos = createAction(
    DocumentosActionTypes.RecuperarDocumentos,
    props<{ conteudo: string }>()
);

export const recuperarDocumentosSuccess = createAction(
    DocumentosActionTypes.RecuperarDocumentosSuccess,
    props<{ retorno: Norma[] }>()
);

export const recuperarDocumentosFailure = createAction(
    DocumentosActionTypes.RecuperarDocumentosFailure,
    props<{ falha: any }>()
);
