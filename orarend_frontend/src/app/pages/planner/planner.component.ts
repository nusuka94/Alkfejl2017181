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

  constructor(private timetableService: TimetableService, private authService: AuthService, private router: Router) {

  }

  ngOnInit() {
    this.refreshTimetables();
    this.subscription = this.authService.loggedIn$.subscribe();
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  new() {
    if (this.authService.isAuthenticated) {
      // this.timetableService.newTimetable(new Timetable(this.authService.currentUserId))
      //   .subscribe(
      //     res => this.router.navigate(['/planner/new']),
      //     err => console.log(err)
      //   );
      this.router.navigate(['/planner/new']);
    } else {
      console.log('Unauthorized.');
      this.router.navigate(['/login']);
    }
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
  public isLoadingResults = false;

  constructor(private timetableService: TimetableService) {

  }

  connect(): Observable<Timetable[]> {
    return Observable.merge([])
      .startWith(() => this.isLoadingResults = true)
      .switchMap(() => {
        return this.timetableService.getTimetables();
      })
      .map((data: Timetable[]) => {
        this.isLoadingResults = false;

        return data;
      });
  }

  disconnect(): void {
  }
}


