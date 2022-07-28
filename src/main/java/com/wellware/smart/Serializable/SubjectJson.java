package com.wellware.smart.Serializable;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.wellware.smart.DTO.GDTO;
import com.wellware.smart.entities.Student;
import com.wellware.smart.entities.Subject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubjectJson extends StdSerializer<Subject> {

    public SubjectJson() {
        this(null);
    }
    public SubjectJson(Class<Subject> t) {
        super(t);
    }

    @Override
    public void serialize(
            Subject value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {

        gen.writeStartObject();
        gen.writeNumberField("id",value.getId());
        gen.writeStringField("name",value.getName());
        gen.writeStringField("price",value.getPrice());
        gen.writeStringField("branch",value.getBranch().getName());
        gen.writeStringField("grade",value.getGrade().getName());
        gen.writeStringField("schoolType",value.getSchoolType().getType());
        List<GDTO> names = new ArrayList<>();
        value.getGroups().forEach(group -> {
            GDTO gdto = new GDTO();
            gdto.setGroupName(group.getGroupName());
            names.add(gdto);
        });
        gen.writeObjectField("groups",names);

        gen.writeEndObject();

    }

}
