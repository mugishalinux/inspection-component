package com.parika.inspection.manager.controller;

import com.parika.inspection.manager.models.ParkingInspections;
import com.parika.inspection.manager.services.ParkingInspectionService;
import com.parika.inspection.manager.dto.*;
import com.parika.inspection.manager.util.DeleteApiResponse;
import com.parika.inspection.manager.util.PostApiResponse;
import com.parika.inspection.manager.util.PutApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/inspection/parkingInspection")
public class ParkingInspectionsController {
    private ParkingInspectionService parkingInspectionService;

    public ParkingInspectionsController(ParkingInspectionService parkingInspectionService) {
        super();
        this.parkingInspectionService = parkingInspectionService;
    }

    @PostMapping("")
    public ResponseEntity<PostApiResponse> createParkingInspections(@RequestBody ParkingInspectionDto parkingInspectionDto){
        PostApiResponse response = new PostApiResponse();
        try{
            parkingInspectionService.createParkingInspections(parkingInspectionDto);
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
    Page<ParkingInspections> getAllParkingInspections(@RequestParam Optional<Integer> slotId,
                                                      @RequestParam Optional<Integer> fieldAgentId,
                                                      @RequestParam Optional<Integer> vehicleId,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int sizePage,
                                                      @RequestParam(defaultValue = "id") String sortBy){
        return parkingInspectionService.getAllParkingInspections(slotId,fieldAgentId,vehicleId,page,sizePage,sortBy);
    }


    @GetMapping("/{id}")
    public ParkingInspections getParkingInspectionsById(@PathVariable("id") int id){
        return parkingInspectionService.getSingleParkingInspectionsById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PutApiResponse> updateParkingInspections(@RequestBody ParkingInspectionDto parkingInspectionDto, @PathVariable("id") int id){
        PutApiResponse response = new PutApiResponse();
        try{
            parkingInspectionService.updateParkingInspections(parkingInspectionDto,id);
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
    public ResponseEntity<DeleteApiResponse> deleteParkingInspection(@PathVariable("id") int id){
        DeleteApiResponse response = new DeleteApiResponse();
        try{
            parkingInspectionService.deleteParkingInspections(id);
            response.setMessage("Parking Inspection Deleted");
            response.setResponseCode(HttpStatus.OK);
            return new ResponseEntity<>(response,response.getResponseCode());
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setResponseCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,response.getResponseCode());
        }
    }
}
