package com.example.restfullapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto extends RepresentationModel<RoleDto> {

    private ActorDto actor;

    private MovieDto movie;
}
