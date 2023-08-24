package com.example.app.rest.service;


import com.example.app.rest.model.CrudModel;
import com.example.app.rest.repository.CrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrudService {

    @Autowired
    private CrudRepo crudRepo;


    public Optional<CrudModel> getCrudId(Long id) {
           return crudRepo.findById(id);
    }

    public List<CrudModel> getAllCrud(){
        List<CrudModel> dataAllMapping = new ArrayList<>();
        crudRepo.findAll().forEach(dataAllMapping::add);
        return  dataAllMapping;
    }

    public CrudModel addCrud(CrudModel crudModel){

        return  crudRepo.save(crudModel);
    }

    public  CrudModel updateCrud(Long id, CrudModel crudModel){
        CrudModel dataId = crudRepo.findById(id).orElse(null);
        if (dataId != null){
            dataId.setTittle    (crudModel.getTittle()      );
            dataId.setAge       (crudModel.getAge()         );
            dataId.setFirstName (crudModel.getFirstName()   );
            dataId.setLastName(  crudModel.getLastName()    );
            return  crudRepo.save(dataId);
        }
        return new CrudModel();
    }

    public CrudModel deleteCrud (Long id){
       Optional<CrudModel> dataFix =  crudRepo.findById(id);

        return null;
    }
}
