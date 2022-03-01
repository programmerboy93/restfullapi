package com.example.restfullapi.util;

import com.example.restfullapi.model.Director;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class DirectorSerializer extends StdSerializer<Director> {

    protected DirectorSerializer() {
        this(null);
    }

    protected DirectorSerializer(Class<Director> t) {
        super(t);
    }

    @Override
    public void serialize(Director director, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("id", director.getId().toString());
        gen.writeStringField("firstName", director.getFirstName());
        gen.writeStringField("id", director.getLastName());
        gen.writeStringField("dateOfBirth", director.getDateOfBirth().toString());
        gen.writeEndObject();
    }
}
