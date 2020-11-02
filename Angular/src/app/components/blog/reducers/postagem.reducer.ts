import { Action, createReducer, on } from '@ngrx/store';
import { PostagemActions } from '../actions';
import { Postagem } from '../models/postagem.model';

export interface StagePostagem {
    retornoPostagens: Postagem[];
}

export const initialState: StagePostagem = {
    retornoPostagens: null
};

const postagensRecuperadasReducer = createReducer(
    initialState,
    on(PostagemActions.recuperarPostagensSuccess, (state, { retorno }) => ({
        ...state, retornoPostagens: retorno
    }))
);

export function reducer(state: StagePostagem | undefined, action: Action): any {
    return postagensRecuperadasReducer(state, action);
}
