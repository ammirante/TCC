import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormArray, FormControl, FormGroup, Validators} from '@angular/forms';
import {DomSanitizer, SafeResourceUrl} from '@angular/platform-browser';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {select, Store} from '@ngrx/store';
import {Observable, of, Subscription} from 'rxjs';
import {recuperarCategorias} from '../../actions/categoria.actions';
import {recuperarPostagens, salvarPost} from '../../actions/postagem.action';
import {DominioCategoria} from '../../models/dominio-categoria.model';
import {PostagemDTO} from '../../models/postagem-dto.model';
import {Postagem} from '../../models/postagem.model';
import {StateCategoria} from '../../reducers/categoria.reducer';
import {StagePostagem} from '../../reducers/postagem.reducer';

@Component({
  selector: 'app-container-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.scss']
})
export class ContainerBlogComponent implements OnInit, OnDestroy {

  categorias$: Observable<StateCategoria> = of();
  categorias: DominioCategoria[] = [];
  postagens$: Observable<StagePostagem> = of();
  postagens: Postagem[] = [];
  subscriptions: Subscription[] = [];
  visualizacao: boolean;
  categoriasVisualizacao: DominioCategoria[] = [];
  tituloModal = 'Cadastrar postagem';


  closeResult = '';

  formularioPostagem = new FormGroup({
    titulo: new FormControl(null, [Validators.required]),
    referenciaImagemCapa: new FormControl(null, [Validators.required]),
    descricaoTexto: new FormControl(null, [Validators.required]),
    lstCategorias: new FormArray([], [Validators.required])
  });

  isCadastroHabilitado = false;

  constructor(
    private modalService: NgbModal,
    private store: Store<any>,
    private sanitizer: DomSanitizer
  ) {
  }

  ngOnInit(): void {
    this.store.dispatch(recuperarCategorias());
    this.store.dispatch(recuperarPostagens());
    this.categorias$ = this.store.pipe(select('recuperarCategorias'));
    this.postagens$ = this.store.pipe(select('recuperarPostagens'));

    this.subscriptions.push(this.categorias$.subscribe(retorno => {
      this.categorias = retorno.retornoCategorias;
    }));

    this.subscriptions.push(this.postagens$.subscribe(retorno => {
      this.postagens = retorno.retornoPostagens;
    }));

    const token = localStorage.getItem('token');
    if (token) {
      this.isCadastroHabilitado = true;
    }
  }

  ngOnDestroy(): void {
    this.modalService.dismissAll();
    this.resetarFormulario();
  }

  close(): void {
    this.modalService.dismissAll();
    this.resetarFormulario();
  }

  open(content, postagem?: Postagem): void {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', size: 'lg'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });

    if (postagem) {
      this.formularioPostagem.patchValue(postagem);
      this.visualizacao = true;
      this.formularioPostagem.controls.titulo.disable();
      this.formularioPostagem.controls.referenciaImagemCapa.disable();
      this.formularioPostagem.controls.descricaoTexto.disable();
      this.formularioPostagem.controls.lstCategorias.disable();
      this.categoriasVisualizacao = postagem.lstCategorias;
      this.tituloModal = 'Detalhamento postagem';
      console.log(this.categoriasVisualizacao);
    } else {
      this.visualizacao = false;
      this.categoriasVisualizacao = [];
      this.tituloModal = 'Cadastrar postagem';
      this.formularioPostagem.controls.titulo.enable();
      this.formularioPostagem.controls.referenciaImagemCapa.enable();
      this.formularioPostagem.controls.descricaoTexto.enable();
      this.formularioPostagem.controls.lstCategorias.enable();
      this.resetarFormulario();
    }
  }

  truncateHTML(text: string): string {
    const limiteCaracteres = 300;
    if (!text || text.length <= limiteCaracteres) {
      return text;
    }
    const semHtml = text.replace(/<(?:.|\n)*?>/gm, '');
    const shortened = semHtml.substring(0, limiteCaracteres) + '...';
    return shortened;
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  private resetarFormulario(): void {
    this.formularioPostagem.reset();
  }

  onCheckChange(event): void {
    const formArray: FormArray = this.formularioPostagem.get('lstCategorias') as FormArray;
    if (event.target.checked) {
      formArray.push(new FormControl(event.target.value));
    } else {
      let i = 0;
      formArray.controls.forEach((ctrl: FormControl) => {
        if (ctrl.value === event.target.value) {
          formArray.removeAt(i);
          return;
        }
        i++;
      });
    }
  }

  salvarPost(): void {
    const lstCategorias: string[] = this.formularioPostagem.get('lstCategorias').value;
    const lstDominioCategoriaNumber: number[] = [];

    lstCategorias.forEach(item => {
      lstDominioCategoriaNumber.push(+item);
    });

    const postagem: PostagemDTO = {
      titulo: this.formularioPostagem.get('titulo').value,
      descricaoTexto: this.formularioPostagem.get('descricaoTexto').value,
      referenciaImagemCapa: this.formularioPostagem.get('referenciaImagemCapa').value,
      lstDominioCategoria: lstDominioCategoriaNumber,
      nomeUsuario: localStorage.getItem('nomeUsuario')
    };

    this.store.dispatch(salvarPost({postagem}));
    this.close();
  }

  convertImage(base64: string): SafeResourceUrl {
    return this.sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + base64);
  }

}
