import { DominioCategoria } from './dominio-categoria.model';

export interface PostagemDTO {
    titulo: string;
    referenciaImagemCapa: string;
    descricaoTexto: string;
    lstDominioCategoria: number[];
    nomeUsuario: string;
}
