import {Routes} from '@angular/router';
import {RouteGuard} from './route.guard';
import {LoginComponent} from './pages/login/login.component';
import {Role} from './models/User';
import {RegisterComponent} from './pages/register/register.component';
import {PlannerComponent} from './pages/planner/planner.component';
import {MyTimetablesComponent} from './pages/my-timetables/my-timetables.component';
import {TimetableDetailsComponent} from './pages/timetable-details/timetable-details.component';

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
    data: {roles: [Role.USER]},
    pathMatch: 'full'
  },
  {path: 'planner/mytimetables', component: MyTimetablesComponent, data: {roles: [Role.USER]}, pathMatch: 'full'},
  {path: 'planner/mytimetables/:id', component: TimetableDetailsComponent, data: {roles: [Role.USER]}, pathMatch: 'full'}
]
