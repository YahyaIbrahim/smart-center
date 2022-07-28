package com.wellware.smart.Serializable;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.wellware.smart.entities.Group;
import com.wellware.smart.entities.Student;

import java.io.IOException;

public class GroupJson extends StdSerializer<Group> {

    public GroupJson() {
        this(null);
    }
    public GroupJson(Class<Group> t) {
        super(t);
    }


    @Override
    public void serialize(
            Group value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id",value.getId());
        gen.writeStringField("name",value.getGroupName());
        gen.writeStringField("grade",value.getGrade().getName());
        gen.writeStringField("schoolType",value.getSchoolType().getType());
        gen.writeStringField("branch",value.getBranch().getName());
        gen.writeStringField("subject",value.getSubject().getName());
        gen.writeEndObject();

    }
}