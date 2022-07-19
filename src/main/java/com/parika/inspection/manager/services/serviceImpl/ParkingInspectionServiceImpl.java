package com.parika.inspection.manager.services.serviceImpl;

import com.parika.inspection.manager.exceptions.ApiRequestException;
import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.models.ParkingInspections;
import com.parika.inspection.manager.models.ParkingSlot;
import com.parika.inspection.manager.models.Vehicle;
import com.parika.inspection.manager.repositories.FieldAgentsRepo;
import com.parika.inspection.manager.repositories.ParkingInspectionsRepo;
import com.parika.inspection.manager.repositories.ParkingSlotRepo;
import com.parika.inspection.manager.repositories.VehicleRepo;
import com.parika.inspection.manager.services.ParkingInspectionService;
import com.parika.inspection.manager.util.ParkingIspInputHandle;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParkingInspectionServiceImpl implements ParkingInspectionService {
    private ParkingSlotRepo parkingSlotRepo;
    private FieldAgentsRepo fieldAgentsRepo;
    private VehicleRepo vehicleRepo;
    private ParkingInspectionsRepo parkingInspectionsRepo;

    public ParkingInspectionServiceImpl(ParkingSlotRepo parkingSlotRepo, FieldAgentsRepo fieldAgentsRepo, VehicleRepo vehicleRepo, ParkingInspectionsRepo parkingInspectionsRepo) {
        super();
        this.parkingSlotRepo = parkingSlotRepo;
        this.fieldAgentsRepo = fieldAgentsRepo;
        this.vehicleRepo = vehicleRepo;
        this.parkingInspectionsRepo = parkingInspectionsRepo;
    }

    @Override
    public ParkingInspections createParkingInspections(ParkingIspInputHandle parkingIspInputHandle) {

        if(parkingIspInputHandle.getSlotId() == 0){
            throw new ApiRequestException("please provide the parking slot id");
        } else if (parkingIspInputHandle.getFieldAgentId() == 0) {
            throw new ApiRequestException("please provide the field agent id");
        } else if (parkingIspInputHandle.getVehicleId() == 0) {
            throw new ApiRequestException("please provide the vehicle id");
        } else if (parkingIspInputHandle.getIsSystemInitiated() == '\0') {
            throw new ApiRequestException("please provide the status whether is system initiated");
        } else if (parkingIspInputHandle.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (parkingIspInputHandle.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator name");
        }else {

            //check if parking slot id exist
            ParkingSlot parkingSlot = parkingSlotRepo.findById(parkingIspInputHandle.getSlotId()).orElseThrow(()->new ApiRequestException("This parking slot id don't exist in our database"));

            //check if field agent exist into database
            FieldAgents fieldAgent = fieldAgentsRepo.findById(parkingIspInputHandle.getFieldAgentId()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));

            //check if vehicle id exist into database
            Vehicle paVehicle = vehicleRepo.findById(parkingIspInputHandle.getVehicleId()).orElseThrow(()->new ApiRequestException("This Vehicle Id don't exist in our database"));

            String n = String.valueOf(parkingIspInputHandle.getIsSystemInitiated());

            //check if is system initiated character is only one

            if(n.length() > 1){
                throw new ApiRequestException("is system initiated should be one character");
            }else {
                ParkingInspections parkingInspections = new ParkingInspections();
                parkingInspections.setSlotId(parkingSlot);
                parkingInspections.setFieldAgents(fieldAgent);
                parkingInspections.setVehicle(paVehicle);
                parkingInspections.setIsSystemInitiated(parkingIspInputHandle.getIsSystemInitiated());
                parkingInspections.setInitiationTime(LocalDateTime.now());
                parkingInspections.setInspectionTime(LocalDateTime.now());
                parkingInspections.setInspectionCallTimeout(LocalDateTime.now());
                parkingInspections.setStatusId(parkingIspInputHandle.getStatusId());
                parkingInspections.setCreatedAt(LocalDateTime.now());
                parkingInspections.setCreatedBy(parkingIspInputHandle.getCreatedBy());
                parkingInspections.setUpdatedAt(LocalDateTime.now());
                parkingInspections.setUpdatedBy(parkingIspInputHandle.getCreatedBy());
                return parkingInspectionsRepo.save(parkingInspections);
            }
        }
    }

    @Override
    public List<ParkingInspections> getAllParkingInspections() {
        return parkingInspectionsRepo.findAll();
    }

    @Override
    public ParkingInspections getSingleParkingInspectionsById(int id) {
        return parkingInspectionsRepo.findById(id).orElseThrow(()->new ApiRequestException("This Parking Inspection Id don't exist in our database"));
    }

    @Override
    public ParkingInspections updateParkingInspections(ParkingIspInputHandle parkingIspInputHandle, int id) {

        //check if the Parking inspection id exist into db
        ParkingInspections parkingInspections = parkingInspectionsRepo.findById(id).orElseThrow(()->new ApiRequestException("This Parking Inspection Id don't exist in our database"));

        if(parkingIspInputHandle.getSlotId() == 0){
            throw new ApiRequestException("please provide the parking slot id");
        } else if (parkingIspInputHandle.getFieldAgentId() == 0) {
            throw new ApiRequestException("please provide the field agent id");
        } else if (parkingIspInputHandle.getVehicleId() == 0) {
            throw new ApiRequestException("please provide the vehicle id");
        } else if (parkingIspInputHandle.getIsSystemInitiated() == '\0') {
            throw new ApiRequestException("please provide the status whether is system initiated");
        } else if (parkingIspInputHandle.getStatusId() == 0) {
            throw new ApiRequestException("please provide the status id");
        } else if (parkingIspInputHandle.getCreatedBy() == null) {
            throw new ApiRequestException("please provide the creator name");
        }else {

            //check if parking slot id exist
            ParkingSlot parkingSlot = parkingSlotRepo.findById(parkingIspInputHandle.getSlotId()).orElseThrow(()->new ApiRequestException("This parking slot id don't exist in our database"));

            //check if field agent exist into database
            FieldAgents fieldAgent = fieldAgentsRepo.findById(parkingIspInputHandle.getFieldAgentId()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));

            //check if vehicle id exist into database
            Vehicle paVehicle = vehicleRepo.findById(parkingIspInputHandle.getVehicleId()).orElseThrow(()->new ApiRequestException("This Vehicle Id don't exist in our database"));

            String n = String.valueOf(parkingIspInputHandle.getIsSystemInitiated());

            //check if is system initiated character is only one

            if(n.length() > 1){
                throw new ApiRequestException("is system initiated should be one character");
            }else {
                parkingInspections.setSlotId(parkingSlot);
                parkingInspections.setFieldAgents(fieldAgent);
                parkingInspections.setVehicle(paVehicle);
                parkingInspections.setIsSystemInitiated(parkingIspInputHandle.getIsSystemInitiated());
                parkingInspections.setInitiationTime(LocalDateTime.now());
                parkingInspections.setInspectionTime(LocalDateTime.now());
                parkingInspections.setInspectionCallTimeout(LocalDateTime.now());
                parkingInspections.setStatusId(parkingIspInputHandle.getStatusId());
                parkingInspections.setCreatedAt(parkingInspections.getCreatedAt());
                parkingInspections.setCreatedBy(parkingInspections.getCreatedBy());
                parkingInspections.setUpdatedAt(LocalDateTime.now());
                parkingInspections.setUpdatedBy(parkingIspInputHandle.getUpdatedBy());
                return parkingInspectionsRepo.save(parkingInspections);
            }
        }
    }

    @Override
    public void deleteParkingInspections(int id) {
        parkingInspectionsRepo.findById(id).orElseThrow(()->new ApiRequestException("This Parking Inspection Id don't exist in our database"));
        parkingInspectionsRepo.deleteById(id);
    }
}
