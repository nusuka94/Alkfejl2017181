import {Component} from '@angular/core';
import {CourseService} from '../../services/course.service';
import {Course} from '../../models/Course';
import {DataSource} from '@angular/cdk/collections';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/merge';
import 'rxjs/add/operator/startWith';
import 'rxjs/add/operator/switchMap';
import {AuthService} from '../../services/auth.service';
import {MatTableDataSource} from '@angular/material';
import {Timetable} from '../../models/Timetable';
import {TimetableService} from '../../services/timetable.service';
import {Router} from '@angular/router';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-new-timetable',
  templateUrl: './new-timetable.component.html',
  styleUrls: ['./new-timetable.component.css']
})
export class NewTimetableComponent {
   public displayedColumns = ['id', 'subject', 'room', 'courseCode', 'instructor', 'day', 'startTime', 'endTime', 'subjectType'];
   public dataSource: CourseDataSource;
   timetable: Timetable;
   courses: number[];

   addForm: FormGroup = new FormGroup({
     courseid: new FormControl('', [Validators.required])
   });

   constructor(private timetableService: TimetableService, private courseService: CourseService,
               private authService: AuthService, private router: Router) {
     if (this.authService.isAuthenticated) {
       this.refreshCourses();
       this.timetable = new Timetable(this.authService.currentUser);
       (this.timetableService.newTimetable(this.timetable))
         .subscribe(res => res, err => console.log(err));
       console.log(this.timetable);
     } else {
       console.log('Unauthorized.');
       this.router.navigate(['/login']);
     }
   }

    public refreshCourses() {
     this.dataSource = new CourseDataSource(this.courseService);
    }

    get courseid(): AbstractControl {
     return this.addForm.get('courseid');
    }

  // applyFilter(filterValue: string) {
  //   filterValue = filterValue.trim();
  //   filterValue = filterValue.toLowerCase();
  //   this.dataSource.filter = filterValue;
  // }

  addCourse() {
     this.courses.push(this.courseid.value);
      // this.timetableService.addCourse(this.timetable.id, this.courseid.value);
  }

  submit() {

  }
}

export class CourseDataSource implements DataSource<Course> {
  public isLoadingResults = false;

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

        return data;
      });
  }

  disconnect(): void {}
}


