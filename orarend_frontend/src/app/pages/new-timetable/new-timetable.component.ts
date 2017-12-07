import { Component, OnInit } from '@angular/core';
import {TimetableService} from '../../services/timetable.service';
import {Router} from '@angular/router';
import {CourseService} from '../../services/course.service';
import {Course} from '../../models/Course';
import {DataSource} from '@angular/cdk/collections';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/merge';
import 'rxjs/add/operator/startWith';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'app-new-timetable',
  templateUrl: './new-timetable.component.html',
  styleUrls: ['./new-timetable.component.css']
})
export class NewTimetableComponent implements OnInit {
  public loadInProgress = false;
  public displayedColumns = ['subject', 'room', 'courseCode', 'instructor', 'day', 'startTime', 'endTime', 'subjectType'];
  public dataSource: CourseDataSource;
  private courses: Course[];

  constructor(private courseService: CourseService, private router: Router) { }

  ngOnInit() {

  }

}

export class CourseDataSource extends DataSource<Course> {
  public resultsLength = 0;
  public isLoadingResults = false;

  constructor(private courseService: CourseService) {
    super();
  }

  // connect(): Observable<Course[]> {
  //   /*return Observable.merge([])
  //     .switchMap(() => {
  //       return this.courseService.getCourses();
  //     })
  //     .map((data: Course[]) => {
  //       return data;
  //     });*/
  //   return this.courseService.getCourses();
  //
  // }

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
