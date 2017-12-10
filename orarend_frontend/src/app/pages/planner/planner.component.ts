import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {TimetableService} from '../../services/timetable.service';
import {Observable} from 'rxjs/Observable';
import {Timetable} from '../../models/Timetable';
import {AuthService} from '../../services/auth.service';
import {DataSource} from '@angular/cdk/collections';
import {Router} from '@angular/router';
import {Subscription} from 'rxjs/Subscription';
import {Course} from '../../models/Course';
import {CourseService} from '../../services/course.service';

@Component({
  selector: 'app-planner',
  templateUrl: './planner.component.html',
  styleUrls: ['./planner.component.css']
})
export class PlannerComponent implements OnInit, OnDestroy {
  subscription: Subscription;
  public displayedColumns = ['id', 'userId'];
  public dataSource: TimetableDataSource;

  timetable: Timetable;
  timetableId: number;

  constructor(private timetableService: TimetableService, private authService: AuthService, private router: Router) {

  }

  ngOnInit() {
    this.refreshTimetables();
    this.subscription = this.authService.loggedIn$.subscribe();
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  mytimetables() {
    if (this.authService.isAuthenticated) {
      this.router.navigate(['/planner/mytimetables']);
    } else {
      console.log('Unauthorized.');
      this.router.navigate(['/login']);
    }
  }

  public refreshTimetables() {
    this.dataSource = new TimetableDataSource(this.timetableService);
  }
}

export class TimetableDataSource implements DataSource<Timetable> {
  constructor(private timetableService: TimetableService) {

  }

  connect(): Observable<Timetable[]> {
    return this.timetableService.getTimetables();
  }

  disconnect() {

  }
}


