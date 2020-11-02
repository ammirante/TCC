import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { Store } from '@ngrx/store';
import { exhaustMap, map, mergeMap } from 'rxjs/operators';
import { PostagemActions } from '../actions';
import { recuperarPostagens } from '../actions/postagem.action';
import { BlogService } from '../blog.service';

@Injectable()
export class PostagemEffects {

    constructor(
        private actions$: Actions,
        private blogService: BlogService,
        private store: Store<any>
    ) { }

    salvarPostagem$ = createEffect(
        () => this.actions$.pipe(
            ofType(PostagemActions.salvarPost),
            mergeMap(action =>
                this.blogService.adicionarPostagem(action.postagem).pipe(
                    map(
                        () => recuperarPostagens({})
                    )
                )
            )
        )
    );

    recuperarPostagens$ = createEffect(
        () => this.actions$.pipe(
            ofType(PostagemActions.recuperarPostagens),
            exhaustMap(() =>
                this.blogService.getPostagens().pipe(
                    map(postagens => PostagemActions.recuperarPostagensSuccess({ retorno: postagens }))
                )
            )
        )
    );
}
