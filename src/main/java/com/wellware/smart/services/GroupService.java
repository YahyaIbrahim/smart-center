package com.wellware.smart.services;

import com.wellware.smart.DTO.GroupDTO;
import com.wellware.smart.DTO.GroupSearch;
import com.wellware.smart.DTO.StudentGroupDTO;
import com.wellware.smart.entities.*;
import com.wellware.smart.reposetories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    StudentGroupRepo studentGroupRepo;

    @Autowired
    BranchRepo branchRepo;

    @Autowired
    TypeRepo typeRepo;

    @Autowired
    GradeRepo gradeRepo;

    @Autowired
    SubjectRepo subjectRepo;

    public Group addNewGroup(GroupDTO groupDTO){

        Grade grade = gradeRepo.findAllById(groupDTO.getGrade());
        Branch branch = branchRepo.findAllById(groupDTO.getBranch());
        SchoolType type = typeRepo.findAllById(groupDTO.getSchoolType());
        Subject subject = subjectRepo.findAllById(groupDTO.getSubject());
        Group group = new Group();
        group.setGroupName(groupDTO.getGroupName());
        group.setGrade(grade);
        group.setSchoolType(type);
        group.setSubject(subject);
        group.setBranch(branch);

        return groupRepo.save(group);

    }

    public Boolean addStudentToGroup(StudentGroupDTO studentGroupDTO, long id){

        Student student = studentRepo.findAllById(studentGroupDTO.getStudentId());

        Group group = groupRepo.findAllById(id);

        List<StudentGroup> students = studentGroupRepo.findAllByStudent(student);
        if (students.size() == 0)
        {
            StudentGroup s = new StudentGroup();
            s.setGroup(group);
            s.setStudent(student);
            studentGroupRepo.save(s);
            return true;
        }
        return false;

    }

    public void addStudentToGroupAsList(List<StudentGroupDTO> studentGroupDTOS, long id){

        studentGroupDTOS.forEach(studentGroupDTO -> {
            Student student = studentRepo.findAllById(studentGroupDTO.getStudentId());

            Group group = groupRepo.findAllById(id);

            StudentGroup s = new StudentGroup();
            s.setGroup(group);
            s.setStudent(student);

            studentGroupRepo.save(s);
        });


    }

    public List<Group> getAll(){
        return groupRepo.findAll();
    }

    public Group update(long id,GroupDTO groupDTO){
        Group updatedGroup = groupRepo.findAllById(id);
        if(groupDTO.getGroupName() != null)
            updatedGroup.setGroupName(groupDTO.getGroupName());
        /*if(String.valueOf(groupDTO.getGrade()) != null)
            updatedGroup.setGrade(groupDTO.getGrade());
        if(String.valueOf(groupDTO.getSubject()) != null)
            updatedGroup.setSubject(groupDTO.getSubject());
        if(String.valueOf(groupDTO.getSchoolType()) != null)
            updatedGroup.setSchoolType(groupDTO.getSchoolType());*/

        return groupRepo.save(updatedGroup);
    }

    public List<Student> getAllStudentInGroup(long id){
        Group group = groupRepo.findAllById(id);
        return studentRepo.findAllByGroups(group);

    }

    public List<Group> getAllByBranch(Long id){
        Branch branch = branchRepo.findAllById(id);
        return groupRepo.findAllByBranch(branch);

    }

    public List<Group> getAllBySchoolType(Long id){
        SchoolType type = typeRepo.findAllById(id);
        return groupRepo.findAllBySchoolType(type);

    }

    public List<Group> getAllByGrade(Long id){
        Grade grade = gradeRepo.findAllById(id);
        return groupRepo.findAllByGrade(grade);

    }

    public List<Group> getByName(String name){
        return groupRepo.findAllByGroupName(name);

    }

    public List<Group> search(GroupSearch groupSearch){
        Branch branch = branchRepo.findAllById(groupSearch.getBranch());
        SchoolType type = typeRepo.findAllById(groupSearch.getSchoolType());
        Grade grade = gradeRepo.findAllById(groupSearch.getGrade());
        Subject subject = subjectRepo.findAllById(groupSearch.getSubject());

        return groupRepo.findAllByBranchAndSchoolTypeAndGradeAndSubject(branch,
                type,grade,subject);

    }

    public void deleteGroup(long id){
        Group group = groupRepo.findAllById(id);
        groupRepo.delete(group);
    }

    public void deleteStudentFromGroup(StudentGroupDTO studentGroupDTO, long id){

        Student student = studentRepo.findAllById(studentGroupDTO.getStudentId());

        Group group = groupRepo.findAllById(id);

        StudentGroup studentGroup = studentGroupRepo.findAllByGroupAndStudent(group,student);

        studentGroupRepo.delete(studentGroup);

    }




}
