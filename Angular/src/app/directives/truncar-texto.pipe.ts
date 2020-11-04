import { Injectable, Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'trucarTexto'
})
@Injectable()
export class TruncarTextoPipe implements PipeTransform {

  transform(texto: string, args: string[]): string {
    let tamanho = args.length > 0 ? +args[0] : 10;
    const completarCom = '...';

    for (let i = 1; i <= texto.length; i++) {
      if (this.calcularTamanhoTexto(texto.toString().substring(0, i)) >= tamanho) {
        tamanho = texto.substring(0, i).length;
        return texto.substring(0, i - completarCom.length) + completarCom;
      }
    }

    return texto;
  }

  calcularTamanhoTexto(texto: string): number {
    const font = '15px Puente Medium';
    const canvas = document.createElement('canvas');
    const context = canvas.getContext('2d');
    context.font = font;
    const width = context.measureText(texto).width;

    return Math.ceil(width);
  }

}
