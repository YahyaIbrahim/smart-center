package com.wellware.smart.reposetories;

import com.wellware.smart.entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface GroupRepo extends CrudRepository<Group,Long> {

    Group findAllById(long id);

    List<Group> findAll();

    List<Group> findAllByBranch(Branch branch);

    List<Group> findAllBySchoolType(SchoolType schoolType);

    List<Group> findAllByGrade(Grade grade);

    List<Group> findAllByGroupName(String name);


    List<Group> findAllByBranchAndSchoolTypeAndGradeAndSubject(@NotNull Branch branch, @NotNull SchoolType schoolType, @NotNull Grade grade, Subject subject);


}
