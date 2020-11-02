import { Action, createReducer, on } from '@ngrx/store';
import { CategoriaActions } from '../actions';
import { DominioCategoria } from '../models/dominio-categoria.model';

export interface StateCategoria {
    retornoCategorias: DominioCategoria[];
}

export const initialState: StateCategoria = {
    retornoCategorias: null
};

const categoriasRecuperadasReducer = createReducer(
    initialState,
    on(CategoriaActions.recuperarCategoriasSuccess, (state, { retorno }) => ({
        ...state, retornoCategorias: retorno
    }))
);

export function reducer(state: StateCategoria | undefined, action: Action): any {
    return categoriasRecuperadasReducer(state, action);
}
