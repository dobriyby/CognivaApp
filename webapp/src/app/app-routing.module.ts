import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainPageComponent} from "./main-page/main-page.component";
import {UsersPageComponent} from "./users-page/users-page.component";
import {PushesPageComponent} from "./pushes-page/pushes-page.component";
import {RolesPageComponent} from "./roles-page/roles-page.component";


const routes: Routes = [
  {path: '' , component: MainPageComponent},
  {path: 'users' , component: UsersPageComponent},
  {path: 'pushes' , component: PushesPageComponent},
  {path: 'roles' , component: RolesPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
