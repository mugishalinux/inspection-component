package com.parika.inspection.manager.controller;

import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.models.ParkingInspections;
import com.parika.inspection.manager.services.ParkingInspectionService;
import com.parika.inspection.manager.util.FieldAgentInputHandel;
import com.parika.inspection.manager.util.ParkingIspInputHandle;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/inspection/parkingInspection")
public class ParkingInspectionsController {
    private ParkingInspectionService parkingInspectionService;

    public ParkingInspectionsController(ParkingInspectionService parkingInspectionService) {
        super();
        this.parkingInspectionService = parkingInspectionService;
    }
    @ApiOperation(value="Create a Parking Inspections")
    @PostMapping("")
    public ResponseEntity<ParkingInspections> createParkingInspections(@RequestBody ParkingIspInputHandle parkingIspInputHandle){
        return new ResponseEntity<ParkingInspections>(parkingInspectionService.createParkingInspections(parkingIspInputHandle), HttpStatus.CREATED);
    }
    @ApiOperation(value="Retrieve a list of Parking Inspections")
    @GetMapping()
    List<ParkingInspections> getAllParkingInspections(){
        return parkingInspectionService.getAllParkingInspections();
    }

    @ApiOperation(value="Retrieve single Parking Inspections by using ID")
    @GetMapping("/{id}")
    public ParkingInspections getParkingInspectionsById(@PathVariable("id") int id){
        return parkingInspectionService.getSingleParkingInspectionsById(id);
    }
    @ApiOperation(value="Update a Parking Inspections by using ID")
    @PutMapping("/{id}")
    public ResponseEntity<ParkingInspections> updateParkingInspections(@RequestBody ParkingIspInputHandle parkingIspInputHandle, @PathVariable("id") int id){
        return new ResponseEntity<ParkingInspections>(parkingInspectionService.updateParkingInspections(parkingIspInputHandle,id),HttpStatus.OK);
    }
    @ApiOperation(value="Delete a Parking Inspections by using ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFieldAgents(@PathVariable("id") int id){
        parkingInspectionService.deleteParkingInspections(id);
        return new ResponseEntity<String>("Parking Inspections deletion successfully!!!",HttpStatus.OK);
    }
}
