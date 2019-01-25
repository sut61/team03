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
import { RoomSelectComponent } from './room-select/room-select.component';
import {RoomSelectService} from './shared/room-select/room-select.service';
import { RoomReserveComponent } from './room-reserve/room-reserve.component';
import {RoomReserveService} from './shared/room-reserve/room-reserve.service';
import { RoomComponent } from './room/room.component';
import { RoomService } from './shared/room/room.service';
import {PaidTableComponent} from './paid-table/paid-table.component';
import {CreditpayComponent} from './creditpay/creditpay.component';
import {CashpayComponent} from './cashpay/cashpay.component';
import {PaidService} from './shared/pay/paid.service';

const appRoutes: Routes = [
  {path: 'room', component: RoomComponent},
  {path: 'select', component: RoomSelectComponent},
  {path: 'reserve/:id', component: RoomReserveComponent},
  {path: 'login', component: LoginComponent},
  { path: 'paidtable', component: PaidTableComponent},
  { path: 'creditpay/:id', component: CreditpayComponent},
  { path: 'cashpay/:id', component: CashpayComponent},

  {path: '', redirectTo: 'login', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RoomSelectComponent,
    RoomReserveComponent,
    RoomComponent,
    PaidTableComponent,
    CreditpayComponent,
    CashpayComponent
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
  providers: [LoginService, TokenService, RoomSelectService, RoomReserveService, RoomService , PaidService],
  bootstrap: [AppComponent]
})
export class AppModule { }
