package com.example.app.rest.controller;
import com.example.app.rest.model.CrudModel;
import com.example.app.rest.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CrudController {

    @Autowired
    private CrudService crudService;
    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping("/getCrudById/{id}")
    public Optional<CrudModel> getCrudById(@PathVariable Long id) {
        Optional<CrudModel> dataCrudById = crudService.getCrudId(id);
        return  dataCrudById;
    }

    @GetMapping("/getAllCrud")
        public List<CrudModel> getAllCrud(){
        List<CrudModel> dataList = crudService.getAllCrud();
        return dataList;
    }

    @PostMapping("/addCrud")
    public  CrudModel addCrud(@RequestBody CrudModel crudModel){
        CrudModel crudObj = crudService.addCrud(crudModel);
        return crudObj;
    }

    @PostMapping("/updateCrud/{id}")
    public CrudModel crudUodate(@PathVariable Long id, @RequestBody CrudModel crudModel){
        CrudModel crudObj = crudService.updateCrud(id,crudModel);
        return crudObj;
    }
//    @DeleteMapping("deleteCrud/{id}")
//    public CrudModel crudDelete(@PathVariable Long id){
//         CrudModel dataFix =     crudService.deleteCrud(id);
//        return  new CrudModel(crudService);
//    }


}
