package com.wellware.smart.reposetories;


import com.wellware.smart.entities.Group;
import com.wellware.smart.entities.Student;
import com.wellware.smart.entities.StudentGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGroupRepo extends CrudRepository<StudentGroup,Long>
 {

    List<StudentGroup> findStudentIdGroupByGroup(Group group);

    List<StudentGroup> findAllByStudent(Student student);

    StudentGroup findAllByGroupAndStudent(Group group, Student student);
}
