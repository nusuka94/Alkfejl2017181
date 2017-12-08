import {Component, OnDestroy, OnInit} from '@angular/core';
import {TimetableService} from '../../services/timetable.service';
import {Observable} from 'rxjs/Observable';
import {Timetable} from '../../models/Timetable';
import {AuthService} from '../../services/auth.service';
import {DataSource} from '@angular/cdk/collections';

@Component({
  selector: 'app-planner',
  templateUrl: './planner.component.html',
  styleUrls: ['./planner.component.css']
})
export class PlannerComponent implements OnInit, OnDestroy {


  constructor(private timetableService: TimetableService, private authService: AuthService) { }

  ngOnInit() {
    this.authService.loggedIn$.subscribe();
  }

  ngOnDestroy() {
    this.authService.loggedIn$.unsubscribe();
  }


}


