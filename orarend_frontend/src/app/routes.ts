import {Routes} from '@angular/router';
import {RouteGuard} from './route.guard';
import {LoginComponent} from './pages/login/login.component';
import {Role} from './models/User';
import {RegisterComponent} from './pages/register/register.component';
import {PlannerComponent} from './pages/planner/planner.component';
import {NewTimetableComponent} from './pages/new-timetable/new-timetable.component';

//export const appRoutes: Routes = [
//  {
//    path: '',
//    canActivateChild: [RouteGuard],
//    children: [
//      {path: '', redirectTo: 'login', pathMatch: 'full'},
//      {path: 'login', component: LoginComponent, data: {roles: [Role.GUEST]}, pathMatch: 'full'},
//      {path: 'register', component: RegisterComponent, data: {roles: [Role.GUEST]}, pathMatch: 'full'},
//      {path: 'planner', component: PlannerComponent, data: {roles: [Role.USER, Role.GUEST]}, pathMatch: 'full'},
//      {path: 'planner/new', component: NewTimetableComponent, data: {roles: [Role.USER, Role.GUEST]}, pathMatch: 'full'}
//
//    ]
//  }
//]

export const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full'
  },
  {
    path: 'register',
    component: RegisterComponent,
    pathMatch: 'full'
  },
  {
    path: 'planner',
    component: PlannerComponent,
    data: {roles: [Role.USER, Role.GUEST]},
    pathMatch: 'full'
  },
  {path: 'planner/new', component: NewTimetableComponent, data: {roles: [Role.USER, Role.GUEST]}, pathMatch: 'full'}
]
