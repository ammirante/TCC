import { DominioNorma } from './dominio-norma.model';

export interface Norma {
    codigoNorma: number;
    numeroNorma: number;
    dataDocumento: Date;
    assunto: string;
    responsavel: string;
    dominioNorma: DominioNorma;
    diarioOficialUniao: string;
    texto: string;
}
