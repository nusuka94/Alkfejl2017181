import {Routes} from '@angular/router';
import {RouteGuard} from './route.guard';
import {LoginComponent} from './pages/login/login.component';
import {Role} from './models/User';
import {RegisterComponent} from './pages/register/register.component';
import {PlannerComponent} from './pages/planner/planner.component';

export const appRoutes: Routes = [
  {
    path: '',
    canActivateChild: [RouteGuard],
    children: [
      {path: '', redirectTo: 'login', pathMatch: 'full'},
      {path: 'login', component: LoginComponent, data: {roles: [Role.GUEST]}},
      {path: 'register', component: RegisterComponent, data: {roles: [Role.GUEST]}},
      {path: 'planner', component: PlannerComponent, data: {roles: [Role.USER, Role.GUEST]}}
    ]
  }
]
