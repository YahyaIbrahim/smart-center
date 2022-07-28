package com.wellware.smart.Serializable;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.wellware.smart.entities.Branch;
import com.wellware.smart.entities.Group;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BranchJson extends StdSerializer<Branch> {

    public BranchJson() {
        this(null);
    }
    public BranchJson(Class<Branch> t) {
        super(t);
    }


    @Override
    public void serialize(
            Branch value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        List<String> subjectNames = new ArrayList<>();
        List<String> groupNames = new ArrayList<>();
        List<String> studentNames = new ArrayList<>();
        value.getSubject().forEach(subject -> subjectNames.add(subject.getName()));
        value.getStudent().forEach(student -> studentNames.add(student.getName()));
        value.getGroup().forEach(group -> groupNames.add(group.getGroupName()));
        gen.writeStringField("name",value.getName());
        gen.writeObjectField("subject",subjectNames);
        gen.writeObjectField("group",groupNames);
        gen.writeObjectField("student",studentNames);
        gen.writeEndObject();

    }
}