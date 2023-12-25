import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { UsertableComponent } from './usertable/usertable.component';
import { AdminComponent } from './admin.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BooktableComponent } from './booktable/booktable.component';


@NgModule({
  declarations: [UsertableComponent,AdminComponent, DashboardComponent, BooktableComponent],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
