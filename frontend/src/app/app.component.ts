import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StudentRequest } from './models/studentRequest';
import { StudentResponse } from './models/studentResponse';
import { StudentService } from './services/student.service';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public loggedIn = false;
  public studenti: StudentResponse[];
  public editStudent: StudentResponse;
  public deleteStudent: StudentResponse;

  constructor(private studentService: StudentService, private authService: AuthService) { }

  ngOnInit(): void {
    this.getStudents();
  }

  public onLogin(loginForm: NgForm): void {
    const form = {
      ime: loginForm.value.ime,
      lozinka: loginForm.value.lozinka
    }
    this.authService.login(form).subscribe(
      (response: string) => {
        this.loggedIn = true;
        console.log(`Response: ${response}`);
        this.getStudents();
        loginForm.reset();
        let closeButton = document.getElementById('close-login-form') as HTMLElement;
        closeButton.click();
      },
      (error: HttpErrorResponse) => {
        console.log(error.error);
        alert(error.error);
      },
    )
  }

  public getStudents(): void {
    this.studentService.getStudents().subscribe(
      (response: StudentResponse[]) => {
        this.studenti = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

  }

  public onAddStudent(addForm: NgForm): void {

    const newStudent = {
      fakultetId: addForm.value.fakultetId,
      ime: addForm.value.ime,
      slikaUrl: addForm.value.slikaUrl
    }

    document.getElementById('add-student-form').click();
    this.studentService.addStudent(newStudent).subscribe(
      (response: StudentResponse) => {
        console.log(response);
        this.getStudents();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      },
    );
  }

  public onUpdateStudent(editForm: NgForm): void {

    const updateStudent = {
      fakultetId: 1,
      ime: editForm.value.ime,
      slikaUrl: editForm.value.slikaUrl
    }

    this.studentService.updateStudent(this.editStudent.id, updateStudent).subscribe(
      (response: StudentResponse) => {
        console.log(response);
        this.getStudents();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      },
    );
  }

  public onDeleteStudent(studentId: number): void {
    this.studentService.deleteStudent(studentId).subscribe(
      (response: void) => {
        console.log(response);
        this.getStudents();
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      },
    );
  }

  public searchStudente(key: string): void {
    console.log(key);
    const results: StudentResponse[] = [];
    for (const student of this.studenti) {
      if (student.ime.toLowerCase().indexOf(key.toLowerCase()) !== -1 || student.nazivFakulteta.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(student);
      }
    }
    this.studenti = results;
    if (results.length === 0 || !key) {
      this.getStudents();
    }
  }

  public onOpenModal(student: StudentResponse, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addStudentModal');
    }
    if (mode === 'edit') {
      this.editStudent = student;
      button.setAttribute('data-target', '#updateStudentModal');
    }
    if (mode === 'delete') {
      this.deleteStudent = student;
      button.setAttribute('data-target', '#deleteStudentModal');
    }
    if (mode === 'login') {
      button.setAttribute('data-target', '#loginModal');
    }
    container.appendChild(button);
    button.click();
    container.removeChild(button);
  }

}
