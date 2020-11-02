import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Actions, createEffect, ofType} from '@ngrx/effects';
import {Store} from '@ngrx/store';
import {of} from 'rxjs';
import {catchError, exhaustMap, map, mergeMap, tap} from 'rxjs/operators';
import {LoginActions} from '../actions';
import {LoginService} from '../login.service';

@Injectable()
export class LoginEffects {

  constructor(
    private actions$: Actions,
    private loginService: LoginService,
    private store: Store<any>,
    private router: Router,
  ) {
  }

  recuperarSenha$ = createEffect(
    () => this.actions$.pipe(
      ofType(LoginActions.recuperarSenha),
      mergeMap(action =>
        this.loginService.recuperarSenha(action.usuario, action.email)
      )
    )
  );

  autenticar$ = createEffect(
    () => this.actions$.pipe(
      ofType(LoginActions.autenticar),
      exhaustMap(action =>
        this.loginService.autenticar(action.usuario, action.senha).pipe(
          map(retorno => LoginActions.autenticacaoSuccess({autenticado: retorno})),
          catchError(falha => of(LoginActions.loginFailure({falha})))
        )
      )
    )
  );

  autenticacaoSucess$ = createEffect(
    () => this.actions$.pipe(
      ofType(LoginActions.autenticacaoSuccess),
      tap(() => this.router.navigateByUrl('/'))
    ),
    {dispatch: false}
  );
}
