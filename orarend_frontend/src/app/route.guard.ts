import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivateChild, Router} from '@angular/router';
import { Observable } from 'rxjs/Observable';
import {AuthService} from './services/auth.service';

//@Injectable()
//export class RouteGuard implements CanActivate, CanActivateChild {
//  constructor(private authService: AuthService) {
//  }
//  canActivate(
//    next: ActivatedRouteSnapshot,
//    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
//    return next.data.roles == null ? true : next.data.roles.includes(this.authService.user.role);
//  }
//  canActivateChild(
//    next: ActivatedRouteSnapshot,
//    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
//    return this.canActivate(next, state);
//  }
//
//}

@Injectable()
export class RouteGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    if (this.authService.isLoggedIn) {
      if (next.data.roles && next.data.roles.includes(this.authService.user.role)) {
        return true;
      } else {
        // this.router.navigate(['/login']);
        console.log('No permission');
        return false;
      }
    }
    this.authService.redirectUrl = state.url;
    this.router.navigate(['/login']);
    return false;
  }
}
