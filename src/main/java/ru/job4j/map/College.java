package ru.job4j.map;


import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> opt = Optional.empty();
        for (Student student : students.keySet()) {
            if (account.equals(student.getAccount())) {
                opt = Optional.of(student);
                break;
            }
        }
        return opt;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> opt = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            Set<Subject> subjects = students.get(s.get());
            for (Subject subject : subjects) {
                if (name.equals(subject.getName())) {
                    opt = Optional.of(subject);
                    break;
                }
            }
        }
        return opt;

    }
}
