import { Injectable } from '@angular/core';
import {User} from '../models/User';
import {Http, Response} from '@angular/http';
import {Routes, Server} from '../utils/ServerRoutes';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {tap} from 'rxjs/operators';

@Injectable()
export class AuthService {
  user: User;
  isLoggedIn: boolean;
  redirectUrl: string;

  public loggedIn$ = new BehaviorSubject<boolean>(this.isLoggedIn);

  constructor(private http: Http) {
    // this.user = new User();
  }

  getUsers(): Observable<any[]> {
    return this.http.get('api/account/').map((response: Response) => response.json());
  }

  /*login(user: User) {
    return this.http.post('api/account/login', user).map((response: Response) => response.json());

  }*/

  login(user: User) {
    return this.http.post('api/account/login', user)
      .map((response: Response) => response.json() as User || null)
      .pipe(
        tap((userx: User) => this.setLoggedIn(userx))
      );

  }

  register(user: User) {
    return this.http.post('api/account/register', user).map((response: Response) => response.json());

  }

  public setLoggedIn(user?: User) {
    this.user = user;
    this.isLoggedIn = !!user;
    this.loggedIn$.next(this.isLoggedIn);
  }

  /*logout() {
    return this.http.get(Server.routeTo(Routes.LOGOUT))
      .map(res => {
        this.user = new User();
        this.isLoggedIn = false;
      })
  }*/

}
