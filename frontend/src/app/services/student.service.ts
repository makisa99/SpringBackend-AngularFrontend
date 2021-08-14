import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StudentResponse } from '../models/studentResponse';
import { StudentRequest } from '../models/studentRequest';

@Injectable({ providedIn: 'root' })
export class StudentService {
    private readonly apiStudentUrl = 'http://localhost:8080/api/students';

    constructor(private http: HttpClient) { }

    public getStudents(): Observable<StudentResponse[]> {
        return this.http.get<StudentResponse[]>(`${this.apiStudentUrl}`);
    }

    public addStudent(student: StudentRequest): Observable<StudentResponse> {
        return this.http.post<StudentResponse>(`${this.apiStudentUrl}`, student);
    }

    public updateStudent(studentId: number, student: StudentRequest): Observable<StudentResponse> {
        return this.http.put<StudentResponse>(`${this.apiStudentUrl}/${studentId}`, student);
    }

    public deleteStudent(studentId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiStudentUrl}/${studentId}`);
    }
}