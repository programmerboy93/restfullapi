package com.example.restfullapi.util;

import com.example.restfullapi.model.Movie;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class MovieSerializer extends StdSerializer<Movie> {

    protected MovieSerializer() {
        this(null);
    }

    protected MovieSerializer(Class<Movie> t) {
        super(t);
    }

    @Override
    public void serialize(Movie movie, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("id",movie.getId().toString());
        gen.writeStringField("title",movie.getTitle());
        gen.writeStringField("dateOFPremiere",movie.getDateOFPremiere().toString());
        gen.writeStringField("budget",movie.getBudget().toString());

        gen.writeStringField("id", movie.getDirector().getId().toString());
        gen.writeStringField("firstName", movie.getDirector().getFirstName());
        gen.writeStringField("id", movie.getDirector().getLastName());
        gen.writeStringField("dateOfBirth", movie.getDirector().getDateOfBirth().toString());



//        gen.writeStartArray();
//        for (Actor actor : movie.getActors()) {
//
//            gen.writeStringField("id", actor.getId().toString());
//            gen.writeStringField("firstName", actor.getFirstName());
//            gen.writeStringField("lastName", actor.getLastName());
//            gen.writeStringField("dateOfBirth", actor.getDateOfBirth().toString());
//
//        }
//        gen.writeEndArray();

        gen.writeEndObject();
    }
}
