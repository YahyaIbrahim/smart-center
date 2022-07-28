package com.wellware.smart.controllers;


import com.wellware.smart.DTO.GroupDTO;
import com.wellware.smart.DTO.GroupSearch;
import com.wellware.smart.DTO.StudentGroupDTO;
import com.wellware.smart.entities.Group;
import com.wellware.smart.entities.Student;
import com.wellware.smart.services.GroupService;
import com.wellware.smart.success.Success;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Group APIs", tags = {"Group Management"},
        description = "Group operations")
@RestController
@CrossOrigin(origins = {"*"}, allowedHeaders = {"*"})
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping(path = "/group/add-new-group")
    public Success addNewGroup(@RequestBody GroupDTO groupDTO){
        try {
            Group group =  groupService.addNewGroup(groupDTO);
            return new Success(200,true,group,"");
        }catch (Exception e) {
            return new Success(400,false,null,e.getMessage());
        }
    }

    @PostMapping(path = "/group/{id}/add-student-group")
    public Success addStudentToGroup(@RequestBody StudentGroupDTO groupDTO, @PathVariable long id){
        if(groupService.addStudentToGroup(groupDTO,id))
            return new Success(200,true,null,"");
        return new Success(400,false,null,"This student already in this Group");

    }

    @PostMapping(path = "/group/{id}/add-student-group-list")
    public Success addStudentToGroupAsList(@RequestBody List<StudentGroupDTO> groupDTOs, @PathVariable long id){
        try {
            groupService.addStudentToGroupAsList(groupDTOs,id);
            return new Success(200,true,null,"");
        }catch (Exception e) {
            return new Success(400,false,null,e.getMessage());
        }
    }

    @GetMapping(path = "/group/get-all-groups")
    public Success getAll(){
        List<Group> groups = groupService.getAll();
        return new Success(200,true,groups,"");
    }


    @PostMapping(path = "/group/{id}/update-group",consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Success update(@RequestBody GroupDTO groupDTO, @PathVariable long id){
        try {
            Group updateStudent = groupService.update(id,groupDTO);
            return new Success(200,true,updateStudent,"");
        }catch (Exception e){
            return new Success(400,false,null,e.getMessage());
        }

    }


    @GetMapping(path = "/group/{id}/get-student-group")
    public Success getAllStudentInGroup(@PathVariable long id){
        List<Student> studentGroups = groupService.getAllStudentInGroup(id);
        if(studentGroups.size() != 0)
            return new Success(200,true,studentGroups,"");
        return new Success(400,false,null,"There's no student here");
    }

    @GetMapping(path = "/group/{name}/find")
    public Success findByName(@PathVariable String name){
        List<Group> groups = groupService.getByName(name);
        if(groups.size() != 0)
            return new Success(200,true,groups,"");
        return new Success(400,false,null,"There's no group with this name");
    }

    @PostMapping(path = "/group/search")
    public Success search(@RequestBody GroupSearch groupSearch){
        List<Group> groups = groupService.search(groupSearch);
        if(groups.size() != 0)
            return new Success(200,true,groups,"");
        return new Success(400,false,null,"There's no groups here");

    }

    @DeleteMapping(path = "/group/{id}/delete")
    public Success deleteGroup( @PathVariable long id){
         groupService.deleteGroup(id);
        return new Success(200,true,null,"Done deleting group");

    }
    @DeleteMapping(path = "/group/{id}/delete-student")
    public Success deleteStudentFromGroup(@RequestBody StudentGroupDTO groupDTO, @PathVariable long id){
        groupService.deleteStudentFromGroup(groupDTO,id);
        return new Success(200,true,null,"Done deleting group");

    }


}
