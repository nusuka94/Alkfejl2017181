import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
// import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class TimetableService {
data: any = {};

constructor(private http: Http) {
    this.getCourses();
    this.getData();
  }

  getCourses() {
    return this.http.get('/api/home/asd').map((response: Response) => response.json());
  }

  getData() {
    this.getCourses().subscribe(data => {
      console.log(data);
      this.data = data
	  })
  }
}
