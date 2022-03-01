package com.example.restfullapi.util;

import com.example.restfullapi.model.Movie;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Set;

public class MovieSetSerializer extends StdSerializer<Set<Movie>> {

    protected MovieSetSerializer() {
        this(null);
    }

    protected MovieSetSerializer(Class<Set<Movie>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<Movie> movies, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        for (Movie movie : movies) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", movie.getId().toString());
            jsonGenerator.writeStringField("title", movie.getTitle());
            jsonGenerator.writeStringField("budget", movie.getBudget().toString());
            jsonGenerator.writeStringField("dateOfPremiere", movie.getDateOFPremiere().toString());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }
}
