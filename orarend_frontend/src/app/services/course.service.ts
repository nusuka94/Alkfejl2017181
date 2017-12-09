import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Course} from '../models/Course';

@Injectable()
export class CourseService {

  constructor(private http: Http) { }

  public getCourses(): Observable<Course[]> {
    return this.http.get('api/home/courses')
      .map((response: Response) => response.json());
  }

}
