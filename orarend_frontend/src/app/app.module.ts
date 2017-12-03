import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule} from '@angular/router';
import {appRoutes} from './routes';
import {AuthService} from './services/auth.service';
import {RouteGuard} from './route.guard';
import { MenuComponent } from './menu/menu.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MaterialItemsModule} from './MaterialItemsModule';
import { PlannerComponent } from './pages/planner/planner.component';
import { NewTimetableComponent } from './pages/new-timetable/new-timetable.component';
import {TimetableService} from "./services/timetable.service";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    MenuComponent,
    PlannerComponent,
    NewTimetableComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    MaterialItemsModule
  ],
  providers: [AuthService, TimetableService, RouteGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
