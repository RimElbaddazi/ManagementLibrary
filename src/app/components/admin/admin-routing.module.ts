import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsertableComponent } from './usertable/usertable.component';
import { AdminComponent } from './admin.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { BooktableComponent } from './booktable/booktable.component';

const routes: Routes = [
  {path:'',component:AdminComponent,children:[
    {path:'users',component:UsertableComponent},
    {path:'books',component:BooktableComponent},
    {path:'',component:DashboardComponent},
  ]}

  

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
