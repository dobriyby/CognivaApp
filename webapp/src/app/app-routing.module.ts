import { NgModule } from '@angular/core';
import {Routes, RouterModule, ROUTES} from '@angular/router';

const routes: Routes = [
 {path: '' , loadChildren: ()=> import('./rout-handler.module').then(mod => mod.RoutHandlerModule)}
];


@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }

