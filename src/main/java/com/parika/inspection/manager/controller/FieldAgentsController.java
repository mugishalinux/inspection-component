package com.parika.inspection.manager.controller;

import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.services.FieldAgentService;
import com.parika.inspection.manager.util.DeleteApiResponse;
import com.parika.inspection.manager.dto.FieldAgentDto;
import com.parika.inspection.manager.util.PostApiResponse;
import com.parika.inspection.manager.util.PutApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/inspection/fieldAgents")
public class FieldAgentsController {
    private FieldAgentService fieldAgentService;

    public FieldAgentsController(FieldAgentService fieldAgentService) {
        super();
        this.fieldAgentService = fieldAgentService;
    }

    @PostMapping("")
    public ResponseEntity<PostApiResponse> createFieldAgents(@RequestBody FieldAgentDto fieldAgentDto){
        PostApiResponse response = new PostApiResponse();
        try{
            fieldAgentService.createFieldAgents(fieldAgentDto);
            response.setMessage("Successfully");
            response.setResponseCode(HttpStatus.CREATED);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }

    @GetMapping()
    Page<FieldAgents> getAllFieldAgents(@RequestParam Optional<Integer> profileId,
                                        @RequestParam Optional<Integer> roleId,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int sizePage,
                                        @RequestParam(defaultValue = "id") String sortBy){
        return fieldAgentService.getAllFieldAgents(profileId,roleId,page,sizePage,sortBy);
    }


    @GetMapping("/{id}")
    public FieldAgents getFieldAgentsById(@PathVariable("id") int id){
        return fieldAgentService.getSingleFieldAgentsById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PutApiResponse> updateFieldAgents(@RequestBody FieldAgentDto fieldAgentDto, @PathVariable("id") int id){
        PutApiResponse response = new PutApiResponse();
        try{
            fieldAgentService.updateFieldAgents(fieldAgentDto,id);
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
    public ResponseEntity<DeleteApiResponse> deleteFieldAgents(@PathVariable("id") int id){
        DeleteApiResponse response = new DeleteApiResponse();
        try{
            fieldAgentService.deleteFieldAgents(id);
            response.setMessage("Field Agent Deleted");
            response.setResponseCode(HttpStatus.OK);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }
}
