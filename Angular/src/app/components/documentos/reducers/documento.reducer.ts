import { Action, createReducer, on } from '@ngrx/store';
import { DocumentosActions } from '../actions';
import { Norma } from '../models/norma.model';

export interface State {
    retornoBacen: Norma[];
}

export const initialState: State = {
    retornoBacen: null
};

const documentosRecuperadosReducer = createReducer(
    initialState,
    on(DocumentosActions.recuperarDocumentosSuccess, (state, { retorno }) => ({
        ...state, retornoBacen: retorno
    }))
);

export function reducer(state: State | undefined, action: Action): any {
    return documentosRecuperadosReducer(state, action);
}
