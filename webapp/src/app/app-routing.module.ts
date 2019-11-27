import { NgModule } from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {MainPageComponent} from "./main-page/main-page.component";
import {UsersPageComponent} from "./users-page/users-page.component";
import {PushesPageComponent} from "./pushes-page/pushes-page.component";
import {RolesPageComponent} from "./roles-page/roles-page.component";
import {LoginPageComponent} from "./login-page/login-page.component";

let routes: Routes = [
    {path: '' , component: MainPageComponent, children: [
        {path: 'users' , component: UsersPageComponent},
        {path: 'pushes' , component: PushesPageComponent},
        {path: 'roles' , component: RolesPageComponent}
      ]},
    {path: 'login' , component: LoginPageComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }

