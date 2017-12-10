import { Component, OnInit } from '@angular/core';
import {TimetableService} from '../../services/timetable.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Timetable} from '../../models/Timetable';
import {Observable} from 'rxjs/Observable';
import {Course} from '../../models/Course';
import {AuthService} from '../../services/auth.service';
import {CourseService} from '../../services/course.service';
import {DataSource} from '@angular/cdk/collections';

@Component({
  selector: 'app-timetable-details',
  templateUrl: './timetable-details.component.html',
  styleUrls: ['./timetable-details.component.css']
})
export class TimetableDetailsComponent{
  id: number;
  timetable: Observable<Timetable>;
  courses: Course[];

  public displayedColumns = ['id', 'subject', 'room', 'courseCode', 'instructor', 'day', 'startTime', 'endTime', 'subjectType', 'add'];
  public dataSource: CourseDataSource;

  constructor(private timetableService: TimetableService,
              private router: Router,
              private route: ActivatedRoute, private authService: AuthService,
              private courseService: CourseService) {
    if (this.authService.isAuthenticated) {
      this.route.params.subscribe(
        params => this.id = params.id,
        err => console.log(err)
      );
      this.timetable = this.timetableService.read(this.id);
      this.refreshCourses();
    } else {
      console.log('Unauthorized.');
      this.router.navigate(['/login']);
    }
  }

  public refreshCourses() {
    this.dataSource = new CourseDataSource(this.courseService);
  }

  public addCourse(cid: number) {
    console.log(this.id + ' ' + cid);
    this.timetableService.addCourse(this.id, cid);
  }

}

export class CourseDataSource implements DataSource<Course> {
  constructor(private courseService: CourseService) {

  }

  connect(): Observable<Course[]> {
    return this.courseService.getCourses();
  }

  disconnect() {}
}
