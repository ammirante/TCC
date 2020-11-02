import { createAction, props } from '@ngrx/store';
import { DominioCategoria } from '../models/dominio-categoria.model';

export enum CategoriaActionTypes {
    CategoriaAction = '[CATEGORIA] CategoriaAction',
    CategoriaActionSuccess = '[CATEGORIA] CategoriaActionSuccess',
}

export const recuperarCategorias = createAction(
    CategoriaActionTypes.CategoriaAction,
    props<{}>()
);

export const recuperarCategoriasSuccess = createAction(
    CategoriaActionTypes.CategoriaActionSuccess,
    props<{ retorno: DominioCategoria[] }>()
);
