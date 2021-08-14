package com.metropolitan.studentlist.services;

import com.metropolitan.studentlist.exceptions.FakultetNotFoundException;
import com.metropolitan.studentlist.exceptions.StudentNotFoundException;
import com.metropolitan.studentlist.models.Fakultet;
import com.metropolitan.studentlist.models.Student;
import com.metropolitan.studentlist.payload.request.StudentDtoRequest;
import com.metropolitan.studentlist.payload.response.StudentDtoResponse;
import com.metropolitan.studentlist.repos.FakultetRepository;
import com.metropolitan.studentlist.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final FakultetRepository fakultetRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, FakultetRepository fakultetRepository) {
        this.studentRepository = studentRepository;
        this.fakultetRepository = fakultetRepository;
    }

    public StudentDtoResponse addStudent(StudentDtoRequest studentDtoRequest) {
        Student student = mapToEntity(studentDtoRequest);

        long fakultetId = studentDtoRequest.getFakultetId();
        Fakultet fakultet = fakultetRepository.findById(fakultetId).
                orElseThrow(() -> new FakultetNotFoundException("Fakultet sa id-jem: " + fakultetId + " nije pronadjen!"));

        student.setFakultet(fakultet);

        Student newStudent = studentRepository.save(student);

        return mapToDto(newStudent);
    }

    public List<StudentDtoResponse> findAllStudents() {
        List<Student> studenti = studentRepository.findAll();

        return studenti.stream().map(student -> mapToDto(student)).collect(Collectors.toList());
    }

    public StudentDtoResponse findStudentById(long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student sa id-jem " + studentId + " nije pronadjen!"));

        return mapToDto(student);
    }

    public StudentDtoResponse updateStudent(long studentId, StudentDtoRequest studentDtoRequest) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student sa id-jem: " + studentId + " nije pronadjen!"));

        student.setIme(studentDtoRequest.getIme());
        student.setSlikaUrl(studentDtoRequest.getSlikaUrl());

        Student updatedStudent = studentRepository.save(student);

        return mapToDto(updatedStudent);
    }

    public void deleteStudent(long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student sa id-jem: " + studentId + " nije pronadjen!"));

        studentRepository.delete(student);
    }

    private Student mapToEntity(StudentDtoRequest studentDtoRequest) {
        Student student = new Student();

        student.setIme(studentDtoRequest.getIme());
        student.setSlikaUrl(studentDtoRequest.getSlikaUrl());

        return student;
    }

    private StudentDtoResponse mapToDto(Student student) {
        StudentDtoResponse studentDto = new StudentDtoResponse();

        studentDto.setId(student.getId());
        studentDto.setIme(student.getIme());
        studentDto.setSlikaUrl(student.getSlikaUrl());
        studentDto.setNazivFakulteta(student.getFakultet().getNaziv());

        return studentDto;
    }
}