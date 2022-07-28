package com.wellware.smart.reposetories;


import com.wellware.smart.entities.Student;
import com.wellware.smart.entities.StudentSubject;
import com.wellware.smart.entities.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSubjectRepo extends CrudRepository<StudentSubject,Long> {
    List<StudentSubject> findStudentSubjectBySubject(Subject subject);
    List<StudentSubject> findStudentSubjectByStudent(Student student);

}
