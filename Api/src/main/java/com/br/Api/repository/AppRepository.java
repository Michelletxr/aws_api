package com.br.Api.repository;

import com.br.Api.model.AppModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AppRepository extends JpaRepository<AppModel, UUID> {
    Optional<AppModel> findAppByName(String name);

}