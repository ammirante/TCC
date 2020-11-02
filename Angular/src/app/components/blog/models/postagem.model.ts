import { DominioCategoria } from './dominio-categoria.model';
import { DominioSituacao } from './dominio-situacao.model';
import { Pessoa } from './pessoa.model';

export interface Postagem {
    codigoPostagem: number;
    titulo: string;
    dataPostagem: Date;
    dataAtualizacao: Date;
    descricaoTexto: string;
    referenciaImagemCapa: string;
    situacao: DominioSituacao;
    pessoa: Pessoa;
    lstCategorias: DominioCategoria[];
}