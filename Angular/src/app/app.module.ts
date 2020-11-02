import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { environment } from 'src/environments/environment';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginEffects } from './components/login/effects/login.effects';
import { TemplateComponent } from './components/template/template.component';
import { BasePathInterceptor } from './interceptors/basepath.interceptor';
import { StorageService } from './util/storage.service';
import * as loginreducer from './components/login/reducers/login.reducer';

@NgModule({
  declarations: [
    AppComponent,
    TemplateComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    StoreModule.forRoot({ recuperarUsuario: loginreducer.reducer }),
    StoreDevtoolsModule.instrument({
      maxAge: 25,
      logOnly: environment.production
    }),
    FormsModule,
    ReactiveFormsModule,
    EffectsModule.forRoot([LoginEffects]),
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: BasePathInterceptor, multi: true },
    StorageService
  ],
  exports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
