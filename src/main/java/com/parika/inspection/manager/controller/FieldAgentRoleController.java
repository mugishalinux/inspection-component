package com.parika.inspection.manager.controller;

import com.parika.inspection.manager.models.FieldAgentRole;
import com.parika.inspection.manager.services.FieldAgentRoleService;
import com.parika.inspection.manager.util.DeleteApiResponse;
import com.parika.inspection.manager.util.PostApiResponse;
import com.parika.inspection.manager.util.PutApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import javax.validation.Valid;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/inspection/fieldAgentRole")
public class FieldAgentRoleController {
    private FieldAgentRoleService fieldAgentRoleService;

    public FieldAgentRoleController(FieldAgentRoleService fieldAgentRoleService) {
        super();
        this.fieldAgentRoleService = fieldAgentRoleService;
    }

    @PostMapping("")
    public ResponseEntity<PostApiResponse> createFieldAgentRole(@RequestBody @Valid  FieldAgentRole fieldAgentRole, BindingResult result){
        PostApiResponse response = new PostApiResponse();
        try{
            fieldAgentRoleService.createFieldAgentRole(fieldAgentRole);
            response.setMessage("Successfully");
            response.setResponseCode(HttpStatus.CREATED);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            System.out.println("Controller Level");
            response.setMessage(result.toString());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }

    @GetMapping()
    Page<FieldAgentRole> getAllFieldAgentRole(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int sizePage,
                                              @RequestParam(defaultValue = "id") String sortBy){
        return fieldAgentRoleService.getAllFieldAgentRole(page,sizePage,sortBy);
    }


    @GetMapping("/{id}")
    public FieldAgentRole getFieldAgentRoleById(@PathVariable("id") int id){
        return fieldAgentRoleService.getSingleFieldAgentRole(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PutApiResponse> updateFieldAgentRole(@RequestBody FieldAgentRole fieldAgentRole , @PathVariable("id") int id){
        PutApiResponse response = new PutApiResponse();
        try{
            fieldAgentRoleService.updateTariff(fieldAgentRole,id);
            response.setMessage("Successfully Updated");
            response.setResponseCode(HttpStatus.OK);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteApiResponse> deleteFieldAgentRole(@PathVariable("id") int id){
        DeleteApiResponse response = new DeleteApiResponse();
        try{
            fieldAgentRoleService.deleteFieldAgentRole(id);
            response.setMessage("Field Agent Role Deleted");
            response.setResponseCode(HttpStatus.OK);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }
}
