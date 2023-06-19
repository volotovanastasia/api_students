package com.example.api_students;

import java.util.List;

public class StudentService {
    private List<Student> students;

    public Integer getGrade(Integer id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student.getGrade();
            }
        }
        return 0;
    }

    public void addGrade(Integer id, Integer grade) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setGrade(grade);
            }
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return this.students;
    }
}
