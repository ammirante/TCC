import { Action, createReducer, on } from '@ngrx/store';
import { LoginActions } from '../actions';
import { AutenticacaoDTO } from '../models/autenticacao-dto.model';

export interface StateLogin {
    isAuthenticated: boolean;
    autenticado: AutenticacaoDTO | null;
    mensagemErro: string | null;
}

export const initialState: StateLogin = {
    isAuthenticated: false,
    autenticado: null,
    mensagemErro: null
};

const loginReducer = createReducer(
    initialState,
    on(LoginActions.autenticacaoSuccess, (state, { autenticado }) => ({
        ...state, isAuthenticated: true, autenticado,
    }),
    ),
    on(LoginActions.loginFailure, state => ({
        ...state, mensagemErro: 'Usuário ou senha inválida.'
    }))
);

export function reducer(state: StateLogin | undefined, action: Action): any {
    return loginReducer(state, action);
}
