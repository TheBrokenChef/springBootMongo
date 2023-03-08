package com.chefscode.springBootMongo.service;

import com.chefscode.springBootMongo.dto.StudentRequest;
import com.chefscode.springBootMongo.model.Student;
import com.chefscode.springBootMongo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    public String insertStudent(StudentRequest studentRequest) {
        var ref = new Object() {
            String str = "";
        };
        studentRepository.findStudentByEmail(studentRequest.getEmail())
                        .ifPresentOrElse(stu -> {
                                    ref.str = "Student with email " + stu.getEmail() + " already exists";
                                },
                                () -> {
                                    Student student = new Student();
                                    student.setAddress(studentRequest.getAddress());
                                    student.setFirstName(studentRequest.getFirstName());
                                    student.setLastName(studentRequest.getLastName());
                                    student.setEmail(studentRequest.getEmail());
                                    student.setFavouriteSubjects(studentRequest.getFavouriteSubjects());
                                    student.setGender(studentRequest.getGender());
                                    student.setTotalSpentInBooks(studentRequest.getTotalSpentInBooks());
                                    student.setCreated(studentRequest.getCreated());
                                    studentRepository.insert(student);
                                    ref.str = "Student with email " + student.getEmail() + " added";
                                });
        return ref.str;
    }

    public String updateStudent(String email, StudentRequest studentRequest) {
        var ref = new Object() {
            String str;
        };
        studentRepository.findStudentByEmail(email)
                .ifPresentOrElse(stu -> {
                            stu.setAddress(studentRequest.getAddress());
                            stu.setFirstName(studentRequest.getFirstName());
                            stu.setLastName(studentRequest.getLastName());
                            stu.setEmail(studentRequest.getEmail());
                            stu.setFavouriteSubjects(studentRequest.getFavouriteSubjects());
                            stu.setGender(studentRequest.getGender());
                            stu.setTotalSpentInBooks(studentRequest.getTotalSpentInBooks());
                            stu.setCreated(studentRequest.getCreated());
                            studentRepository.save(stu);
                            ref.str = "Student with email " + stu.getEmail() + " has been updated";
                        },
                        () -> {
                            ref.str = "Please enter a valid email address";
                        });
        return ref.str;
    }

    public String deleteStudent(String email) {
        var ref = new Object() {
            String str;
        };
        studentRepository.findStudentByEmail(email)
                .ifPresentOrElse(stu -> {
                            studentRepository.delete(stu);
                            ref.str = "Student with email " + stu.getEmail() + " has been deleted";
                        },
                        () -> {
                            ref.str = "Please enter a valid email address";
                        });
        return ref.str;
    }
}
