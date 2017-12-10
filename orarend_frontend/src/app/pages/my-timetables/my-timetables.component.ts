import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Observable} from 'rxjs/Observable';
import {DataSource} from '@angular/cdk/collections';
import {TimetableService} from '../../services/timetable.service';
import {Timetable} from '../../models/Timetable';
import {Router} from '@angular/router';

@Component({
  selector: 'app-my-timetables',
  templateUrl: './my-timetables.component.html',
  styleUrls: ['./my-timetables.component.css']
})
export class MyTimetablesComponent {
  public dataSource: MyTimetablesDataSource;
  public displayedColumns = ['id', 'userId', 'edit'];
  timetable: Timetable;
  timetableId: number;
  // timetables: Observable<Timetable[]>;

  constructor(private timetableService: TimetableService, private authService: AuthService, private router: Router) {
    // if (this.authService.isAuthenticated) {
    //   // this.timetables = this.timetableService.getUserTimetables(this.authService.currentUserId);
    //   // console.log(this.timetables);
    // } else {
    //   console.log('Unauthorized.');
    //   this.router.navigate(['/login']);
    // }

    if (!this.authService.isAuthenticated) {
      console.log('Unauthorized.');
      this.router.navigate(['/login']);
    } else {
      this.refreshMyTimetables();
    }
  }

  deleteTimetable(id: number) {
    this.timetableService.deleteTimetable(id)
      .subscribe(res => console.log(res),
        err => console.log(err));
  }

  new() {
    this.timetable = new Timetable(this.authService.currentUser);
    this.timetableService.newTimetable(this.timetable)
      .subscribe(res => res, err => console.log(err));
    this.timetableId = this.timetable.id;
  }

  public refreshMyTimetables() {
    this.dataSource = new MyTimetablesDataSource(this.timetableService, this.authService.currentUserId);
  }

}

export class MyTimetablesDataSource implements DataSource<Timetable> {
  constructor(private timetableService: TimetableService, private id: number) {

  }

  connect(): Observable<Timetable[]> {
    return this.timetableService.getUserTimetables(this.id);
  }

  disconnect() {

  }
}
