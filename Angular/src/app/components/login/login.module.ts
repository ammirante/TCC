import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { EffectsModule } from '@ngrx/effects';
import { StorageService } from 'src/app/util/storage.service';
import { RecuperarSenhaComponent } from './components/recuperar-senha/recuperar-senha.component';
import { ContainerLoginComponent } from './containers/login-container.component';
import { LoginEffects } from './effects/login.effects';
import { LoginRoutingModule } from './login-routing.module';

@NgModule({
    declarations: [
        ContainerLoginComponent,
        RecuperarSenhaComponent
    ],
    imports: [
        LoginRoutingModule,
        CommonModule,
        NgbModule,
        ReactiveFormsModule,
        FormsModule,
        EffectsModule.forFeature([LoginEffects]),
        /*StoreModule.forFeature('recuperarCategorias', categoriaReducer.reducer),
        StoreModule.forFeature('recuperarPostagens', postagemReducer.reducer),*/
    ],
    entryComponents: [
        RecuperarSenhaComponent
    ],
    providers: [
        StorageService
    ]
})
export class LoginModule { }
