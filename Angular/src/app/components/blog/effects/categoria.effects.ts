import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { exhaustMap, map } from 'rxjs/operators';
import { CategoriaActions } from '../actions';
import { BlogService } from '../blog.service';

@Injectable()
export class CategoriaEffects {

    constructor(
        private actions$: Actions,
        private blogService: BlogService,
    ) { }

    recuperarCategorias$ = createEffect(
        () => this.actions$.pipe(
            ofType(CategoriaActions.recuperarCategorias),
            exhaustMap(() =>
                this.blogService.getCategorias().pipe(
                    map(categorias => CategoriaActions.recuperarCategoriasSuccess({ retorno: categorias }))
                )
            )
        )
    );
}
