package com.doddlecode.braintriproject.repository;

import com.doddlecode.braintriproject.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PositionRepository extends JpaRepository<Position, Long> {
    Position findByPositionName(String name);
}
