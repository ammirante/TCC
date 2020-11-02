import { createAction, props } from '@ngrx/store';
import { AutenticacaoDTO } from '../models/autenticacao-dto.model';

export enum LoginActionTypes {
    RecuperarSenha = '[Login] RecuperarSenha',
    Autenticar = '[Login] Autenticar',
    AutenticacaoSuccess = '[Login] AutenticacaoSuccess',
}

export const recuperarSenha = createAction(
    LoginActionTypes.RecuperarSenha,
    props<{ usuario: string, email: string }>()
);

export const autenticar = createAction(
    LoginActionTypes.Autenticar,
    props<{ usuario: string, senha: string }>()
);

export const autenticacaoSuccess = createAction(
    LoginActionTypes.AutenticacaoSuccess,
    props<{ autenticado: AutenticacaoDTO }>()
);

export const loginFailure = createAction(
    '[Auth] Login Failure',
    props<{ falha: any }>()
);

