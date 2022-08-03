package com.parika.inspection.manager.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/inspection/fieldSupervision")
public class FieldSupervisionController {
//    private FieldSupervisionService fieldSupervisionService;
//
//    public FieldSupervisionController(FieldSupervisionService fieldSupervisionService) {
//        super();
//        this.fieldSupervisionService = fieldSupervisionService;
//    }
//    @ApiOperation(value="Create a Field Supervision")
//    @PostMapping("")
//    public ResponseEntity<FieldSupervision> createFieldSupervision(@RequestBody FieldSupervisionDto fieldSupervisionInputHandle){
//        return new ResponseEntity<FieldSupervision>(fieldSupervisionService.createFieldSupervision(fieldSupervisionInputHandle), HttpStatus.CREATED);
//    }
//    @ApiOperation(value="Retrieve a list of Field Supervision")
//    @GetMapping()
//    List<FieldSupervision> getAllFieldSupervision(){
//        return fieldSupervisionService.getAllFieldSupervision();
//    }
//
//    @ApiOperation(value="Retrieve single Field Supervision by using ID")
//    @GetMapping("/{id}")
//    public FieldSupervision getFieldSupervisionById(@PathVariable("id") int id){
//        return fieldSupervisionService.getSingleFieldSupervisionById(id);
//    }
//    @ApiOperation(value="Update a Field Supervision by using ID")
//    @PutMapping("/{id}")
//    public ResponseEntity<FieldSupervision> updateFieldSupervision(@RequestBody FieldSupervisionDto fieldSupervisionInputHandle, @PathVariable("id") int id){
//        return new ResponseEntity<FieldSupervision>(fieldSupervisionService.updateFieldSupervision(fieldSupervisionInputHandle,id),HttpStatus.OK);
//    }
//    @ApiOperation(value="Delete a Field Supervision by using ID")
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteFieldSupervision(@PathVariable("id") int id){
//        fieldSupervisionService.deleteFieldSupervision(id);
//        return new ResponseEntity<String>("Field Supervision deletion successfully!!!",HttpStatus.OK);
//    }
}
