import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {ACCESS_TOKEN, REFRESH_TOKEN} from '../../constants/global.constants';

@Component({
  selector: 'app-erreur',
  templateUrl: './erreur.component.html',
  standalone: false,
  styleUrls: ['./erreur.component.css']
})
export class ErreurComponent {

  accessToken:string="";
  refreshToken:string="";

  constructor(private http: HttpClient,private router: Router) {
    this.accessToken  = localStorage.getItem(ACCESS_TOKEN) || '';
    this.refreshToken = localStorage.getItem(REFRESH_TOKEN) || '';
  }
}
