import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from '../models/login';

@Injectable({ providedIn: 'root' })
export class AuthService {
    private readonly apiStudentUrl = 'http://localhost:8080/api/auth';

    constructor(private http: HttpClient) { }

    public login(login: Login): Observable<string> {
        return this.http.post(`${this.apiStudentUrl}/login`, login, { responseType: 'text' });
    }
}