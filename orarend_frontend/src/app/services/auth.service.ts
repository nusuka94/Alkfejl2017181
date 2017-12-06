import { Injectable } from '@angular/core';
import {User} from '../models/User';
import {Http, Response} from '@angular/http';
import {Routes, Server} from '../utils/ServerRoutes';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class AuthService {
  user: User;
  isLoggedIn: boolean;
  redirectUrl: string;

  constructor(private http: Http) {
    // this.user = new User();
  }

  getUsers(): Observable<any[]> {
    return this.http.get('/api/account/').map((response: Response) => response.json());
  }

  login(user: User) {
    return this.http.post('/api/account/login', user).map((response: Response) => response.json());
    
  }

  register(user: User) {
    return this.http.post('/api/account/register', user).map((response: Response) => response.json());
    
  }

  /*logout() {
    return this.http.get(Server.routeTo(Routes.LOGOUT))
      .map(res => {
        this.user = new User();
        this.isLoggedIn = false;
      })
  }*/

}
