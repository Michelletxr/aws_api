package com.br.Api.service;

import com.br.Api.model.AppModel;
import com.br.Api.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppService {
    @Autowired
    AppRepository repository;
    public UUID save(AppModel app) {
        return repository.save(app).getId();
    }

    public List<AppModel> findAll() {
        List<AppModel> apps = repository.findAll();
        return  apps;
    }

    public AppModel findById(UUID id) {
        AppModel appModel = null;
        Optional<AppModel> app = repository.findById(id);

        if(app.isPresent()){
           appModel=app.get();
        }

        return appModel;
    }


    public boolean delete(UUID id) {
        boolean isDelet;
        Optional<AppModel> app = repository.findById(id);
        if(!app.isPresent()){
            isDelet = false;
        }else{
            repository.delete(app.get());
            isDelet = true;
        }
        return isDelet;
    }

}
