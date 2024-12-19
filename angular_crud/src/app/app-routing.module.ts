import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostCustomerComponent } from './components/post-customer/post-customer.component';
import { GetAllCustomersComponent } from './components/get-all-customers/get-all-customers.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';

const routes: Routes = [
  {path: "customer", component: PostCustomerComponent},
  {path: "home", component: GetAllCustomersComponent},
  {path: "findCustomer/:id", component: UpdateCustomerComponent},


  { path: '', redirectTo: 'home', pathMatch: 'full' }, 
  { path: '**', redirectTo: 'home' } 

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
