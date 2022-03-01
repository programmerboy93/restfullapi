package com.example.restfullapi.util;

import com.example.restfullapi.model.Actor;
import com.example.restfullapi.model.Movie;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Set;

public class ActorSetSerializer extends StdSerializer<Set<Actor>> {

    protected ActorSetSerializer() {
        this(null);
    }

    protected ActorSetSerializer(Class<Set<Actor>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<Actor> actors, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartArray();
        for (Actor actor : actors) {
            gen.writeStartObject();
            gen.writeStringField("id", actor.getId().toString());
            gen.writeStringField("firstName", actor.getFirstName());
            gen.writeStringField("lastName", actor.getLastName());
            gen.writeStringField("dateOfBirth", actor.getDateOfBirth().toString());
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
}
