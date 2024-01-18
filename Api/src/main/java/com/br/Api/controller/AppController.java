package com.br.Api.controller;
import com.br.Api.model.AppModel;
import com.br.Api.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AppController {

        @Autowired
        AppService service;
        @GetMapping(value = "welcome")
        public  String welcomeService() {
            return "Welcome to App!";
        }

    @PostMapping()
    public ResponseEntity<UUID> saveBook(@RequestBody @Validated AppModel app){
        UUID bookId = service.save(app);
        ResponseEntity<UUID> response = new ResponseEntity<UUID>(bookId, HttpStatus.OK);
        return response;
    }

    @GetMapping(value = "book")
    public ResponseEntity<?> findAll(){
        ResponseEntity<?> response;
        List<AppModel> apps = service.findAll();
        response = new ResponseEntity<>(apps, HttpStatus.OK);
        return response;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> find(@PathVariable UUID id){

        AppModel appModel =  service.findById(id);
        ResponseEntity<Object> response;

        if(Objects.isNull(appModel)){
            response = new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity<>(appModel, HttpStatus.OK);
        }
        return response;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){

        ResponseEntity<?> response;
        boolean isDelet = service.delete(id);

        if(!isDelet){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity<>(HttpStatus.OK);
        }

        return response;
    }



}
