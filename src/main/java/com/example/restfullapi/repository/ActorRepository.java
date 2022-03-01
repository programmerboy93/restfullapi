package com.example.restfullapi.repository;

import com.example.restfullapi.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    Optional<Actor> findById(Long id);

    Actor save(Actor actor);

    @Transactional
    void deleteById(@Param("id") Long id);


}


