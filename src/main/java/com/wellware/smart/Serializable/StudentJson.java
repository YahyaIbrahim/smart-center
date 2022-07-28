package com.wellware.smart.Serializable;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.wellware.smart.DTO.MaterialDTO;
import com.wellware.smart.entities.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentJson extends StdSerializer<Student> {

    public StudentJson() {
        this(null);
    }
    public StudentJson(Class<Student> t) {
        super(t);
    }


    @Override
    public void serialize(
            Student value, JsonGenerator gen,
            SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id",value.getId());
        gen.writeStringField("name",value.getName());
        gen.writeStringField("phone",value.getPhone());
        gen.writeStringField("grade",value.getGrade().getName());
        gen.writeStringField("schoolType",value.getSchoolType().getType());
        gen.writeStringField("branch",value.getBranch().getName());
        List<MaterialDTO> names = new ArrayList<>();
        value.getSubjectList().forEach(subject -> {
            MaterialDTO materialDTO = new MaterialDTO();
            materialDTO.setName(subject.getName());
            names.add(materialDTO);
        });
        gen.writeObjectField("Subjects",names);

        gen.writeEndObject();

    }
}
