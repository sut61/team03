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
import { PromotionComponent } from './promotion/Promotion.component';
import {AllserviceService} from './shared/allservice.service';
import { RoomReserveComponent } from './room-reserve/room-reserve.component';
import {RoomReserveService} from './shared/room-reserve/room-reserve.service';
import { RoomComponent } from './room/room.component';
import { RoomService } from './shared/room/room.service';
import {PaidTableComponent} from './paid-table/paid-table.component';
import {CreditpayComponent} from './creditpay/creditpay.component';
import {CashpayComponent} from './cashpay/cashpay.component';
import {PaidService} from './shared/pay/paid.service';
import { MainComponent } from './main/main.component';
import { Delivery1Component } from './delivery1/delivery1.component';
import { Delivery2Component } from './delivery2/delivery2.component';
import { Delivery3Component } from './delivery3/delivery3.component';
import { ShowinfoComponent } from './showinfo/showinfo.component';
import {MainService} from './shared/main.service';
import { BillComponent } from './bill/bill.component';
import { BillService } from './shared/bill/bill.service';
import {CommentComponent} from './comment/comment.component';
import {CommentService} from './shared/comment/comment.service';
import { CourseReserveComponent } from './course-reserve/course-reserve.component';
import {CourseReserveService} from './shared/course-reserve/course-reserve.service';
const appRoutes: Routes = [
{path: 'coursereserve', component: CourseReserveComponent},
{path: 'room', component: RoomComponent},
{path: 'select', component: RoomSelectComponent},
{path: 'reserve/:id', component: RoomReserveComponent},
{path: 'login', component: LoginComponent},
{ path: 'paidtable', component: PaidTableComponent},
{ path: 'creditpay/:id', component: CreditpayComponent},
{ path: 'cashpay/:id', component: CashpayComponent},
{ path: 'main', component: MainComponent },
{ path: 'transport/:item', component: Delivery1Component },
{ path: 'transport_next/:province', component: Delivery2Component },
{ path: 'transport_final/:district', component: Delivery3Component },
{ path: 'infomation_final/:idShop', component: ShowinfoComponent },
{path: 'bill', component: BillComponent },
  {path: 'comment', component: CommentComponent},
  {path: 'promotion', component: PromotionComponent},

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
CashpayComponent,
MainComponent,
Delivery1Component,
Delivery2Component,
Delivery3Component,
ShowinfoComponent,
BillComponent,
PromotionComponent,
  CommentComponent,
CourseReserveComponent,
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
  providers: [LoginService, TokenService, RoomSelectService,AllserviceService, RoomReserveService, RoomService , PaidService, MainService, BillService , CommentService, CourseReserveService],
  bootstrap: [AppComponent]
})
export class AppModule { }
