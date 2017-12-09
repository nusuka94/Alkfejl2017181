import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {Timetable} from '../models/Timetable';
import {User} from '../models/User';
import {AuthService} from './auth.service';

@Injectable()
export class TimetableService {
  constructor(private http: Http, private authService: AuthService) {}

  public getTimetables(): Observable<Timetable[]> {
    return this.http.get('api/home/timetables')
      .map((response: Response) => response.json());
  }

  public newTimetable(timetable: Timetable): Observable<Timetable> {
    return this.http.post('/api/home/newtimetable', timetable)
      .map((response: Response) => response.json());
  }

  public getUserTimetables(user: User): Observable<Timetable[]> {
    return this.http.get('api/home/usertimetables?user=' + user)
      .map((response: Response) => response.json());
  }

  // public addCourse(timetableId: number, courseId: number) {
  //
  // }
}
