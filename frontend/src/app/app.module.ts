import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {LoginService} from './shared/login/login.service';
import {
  MatAutocompleteModule, MatButtonModule,
  MatButtonToggleModule, MatCardModule,
  MatCheckboxModule, MatDatepickerModule, MatExpansionModule,
  MatFormFieldModule, MatGridListModule, MatInputModule, MatListModule, MatNativeDateModule,
  MatOptionModule, MatPaginatorModule,
  MatSelectModule, MatTableModule, MatTabsModule, MatToolbarModule
} from '@angular/material';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import {TokenService} from './shared/token/token.service';

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: 'login', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatTableModule,
    MatExpansionModule,
    MatPaginatorModule,
    MatGridListModule,
    MatTabsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonToggleModule,
    MatSelectModule,
    MatAutocompleteModule,
    MatOptionModule,
    MatCheckboxModule,
    MatFormFieldModule
  ],
  providers: [LoginService, TokenService],
  bootstrap: [AppComponent]
})
export class AppModule { }
