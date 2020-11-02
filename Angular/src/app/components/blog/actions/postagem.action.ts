import { createAction, props } from '@ngrx/store';
import { PostagemDTO } from '../models/postagem-dto.model';
import { Postagem } from '../models/postagem.model';

export enum PostagemActionTypes {
    SalvarPostagem = '[Postagem] SalvarPostagem',
    RecuperarPostagem = '[Postagem] RecuperarPostagem',
    RecuperarPostagemSuccess = '[Postagem] RecuperarPostagemSuccess',
}

export const salvarPost = createAction(
    PostagemActionTypes.SalvarPostagem,
    props<{ postagem: PostagemDTO }>()
);

export const recuperarPostagens = createAction(
    PostagemActionTypes.RecuperarPostagem,
    props
);

export const recuperarPostagensSuccess = createAction(
    PostagemActionTypes.RecuperarPostagemSuccess,
    props<{ retorno: Postagem[] }>()
);
