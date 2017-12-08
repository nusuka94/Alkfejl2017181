import {Component, OnDestroy, OnInit} from '@angular/core';
import {CourseService} from '../../services/course.service';
import {Course} from '../../models/Course';
import {DataSource} from '@angular/cdk/collections';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/merge';
import 'rxjs/add/operator/startWith';
import 'rxjs/add/operator/switchMap';
import {AuthService} from '../../services/auth.service';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-new-timetable',
  templateUrl: './new-timetable.component.html',
  styleUrls: ['./new-timetable.component.css']
})
export class NewTimetableComponent implements OnInit, OnDestroy {
  // public loadInProgress = false;
  // public displayedColumns = ['subject', 'room', 'courseCode', 'instructor', 'day', 'startTime', 'endTime', 'subjectType'];
  // public dataSource: CourseDataSource;
  // private courses: Course[];
  //
  // constructor(private courseService: CourseService, private authService: AuthService) { }
  //
  // ngOnInit() {
  //   this.refreshCourses();
  //   /*this.authService.loggedIn$.subscribe(
  //     (p: boolean) => {
  //       this.refreshCourses();
  //     }
  //   );*/
  // }
  //
  // ngOnDestroy() {
  //   // this.authService.loggedIn$.unsubscribe();
  // }
  //

  public ELEMENT_DATA: Course[];
  public displayedColumns = ['subject', 'room', 'courseCode', 'instructor', 'day', 'startTime', 'endTime', 'subjectType'];
  public dataSource: MatTableDataSource<Course>;

  public refreshCourses() {
    this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);
    this.courseService.getCourses().subscribe((courses: Course[]) => this.ELEMENT_DATA = courses);
  }



  constructor(private courseService: CourseService) {
    this.courseService.getCourses().subscribe((courses: Course[]) => this.ELEMENT_DATA = courses);

  }

  ngOnInit() {
        this.refreshCourses();
    //   /*this.authService.loggedIn$.subscribe(
    //     (p: boolean) => {
    //       this.refreshCourses();
    //     }
    //   );*/
  }

  ngOnDestroy() {
    //   // this.authService.loggedIn$.unsubscribe();
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim();
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }
}

export class CourseDataSource implements DataSource<Course> {
  public resultsLength = 0;
  public isLoadingResults = false;
  // public filter: string;

  constructor(private courseService: CourseService) {

  }

  connect(): Observable<Course[]> {
    return Observable.merge([])
      .startWith(() => this.isLoadingResults = true)
      .switchMap(() => {
        return this.courseService.getCourses();
      })
      .map((data: Course[]) => {
        this.isLoadingResults = false;
        this.resultsLength = data.length;

        return data;
      });
  }




  disconnect(): void {}
}
