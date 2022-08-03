package com.parika.inspection.manager.services.serviceImpl;

import com.parika.inspection.manager.exceptions.ApiRequestException;
import com.parika.inspection.manager.models.FieldAgents;
import com.parika.inspection.manager.models.Status;
import com.parika.inspection.manager.models.ParkingInspections;
import com.parika.inspection.manager.models.ParkingSlot;
import com.parika.inspection.manager.models.Vehicle;
import com.parika.inspection.manager.repositories.*;
import com.parika.inspection.manager.services.ParkingInspectionService;
import com.parika.inspection.manager.dto.ParkingInspectionDto;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class ParkingInspectionServiceImpl implements ParkingInspectionService {
    private ParkingSlotRepo parkingSlotRepo;
    private FieldAgentsRepo fieldAgentsRepo;
    private VehicleRepo vehicleRepo;
    private ParkingInspectionsRepo parkingInspectionsRepo;
    private StatusesRepo statusesRepo;

    public ParkingInspectionServiceImpl(ParkingSlotRepo parkingSlotRepo, FieldAgentsRepo fieldAgentsRepo, VehicleRepo vehicleRepo, ParkingInspectionsRepo parkingInspectionsRepo, StatusesRepo statusesRepo) {
        super();
        this.parkingSlotRepo = parkingSlotRepo;
        this.fieldAgentsRepo = fieldAgentsRepo;
        this.vehicleRepo = vehicleRepo;
        this.parkingInspectionsRepo = parkingInspectionsRepo;
        this.statusesRepo = statusesRepo;
    }

    @Override
    public ParkingInspections createParkingInspections(ParkingInspectionDto parkingInspectionDto) {

            //check if parking slot id exist
            ParkingSlot parkingSlot = parkingSlotRepo.findById(parkingInspectionDto.getSlotId()).orElseThrow(()->new ApiRequestException("This parking slot id don't exist in our database"));

            //check if field agent exist into database
            FieldAgents fieldAgent = fieldAgentsRepo.findById(parkingInspectionDto.getFieldAgentId()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));

            //check if vehicle id exist into database
            Vehicle paVehicle = vehicleRepo.findById(parkingInspectionDto.getVehicleId()).orElseThrow(()->new ApiRequestException("This Vehicle Id don't exist in our database"));

          try{
              ParkingInspections parkingInspections = new ParkingInspections();
              parkingInspections.setSlotId(parkingSlot);
              parkingInspections.setFieldAgents(fieldAgent);
              parkingInspections.setVehicle(paVehicle);
              parkingInspections.setIsSystemInitiated(parkingInspectionDto.getIsSystemInitiated());
              parkingInspections.setInitiationTime(LocalDateTime.now());
              parkingInspections.setInspectionTime(LocalDateTime.now());
              parkingInspections.setInspectionCallTimeout(LocalDateTime.now());
              parkingInspections.setStatus(null);
              parkingInspections.setCreatedOnDt(new Date());
              parkingInspections.setCreatedBy(null);
              parkingInspections.setUpdatedOnDt(new Date());
              parkingInspections.setUpdatedBy(null);
              return parkingInspectionsRepo.save(parkingInspections);
          }catch (Exception e){
              throw new ApiRequestException(e.getMessage());
          }
    }

    @Override
    public Page<ParkingInspections> getAllParkingInspections(Optional<Integer> slotId, Optional<Integer> fieldAgentId, Optional<Integer> vehicleId,int page, int sizePage, String sortBy) {
        if(slotId.isPresent() && !fieldAgentId.isPresent() && !vehicleId.isPresent()){
            //check if parking slot id exist
            ParkingSlot parkingSlot = parkingSlotRepo.findById(slotId.get()).orElseThrow(()->new ApiRequestException("This parking slot id don't exist in our database"));
            Pageable pageable = PageRequest.of(page, sizePage);
            Slice<ParkingInspections> slicedResult = new PageImpl<>(parkingInspectionsRepo.findBySlotId(parkingSlot,pageable));
            return new PageImpl<>(slicedResult.getContent());
        } else if (!slotId.isPresent() && fieldAgentId.isPresent() && vehicleId.isPresent()) {
            //check if field agent exist into database
            FieldAgents fieldAgent = fieldAgentsRepo.findById(fieldAgentId.get()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));
            Pageable pageable = PageRequest.of(page, sizePage);
            Slice<ParkingInspections> slicedResult = new PageImpl<>(parkingInspectionsRepo.findByFieldAgents(fieldAgent,pageable));
            return new PageImpl<>(slicedResult.getContent());
        } else if (!slotId.isPresent() && !fieldAgentId.isPresent() && vehicleId.isPresent()) {
            //check if vehicle id exist into database
            Vehicle vehicle = vehicleRepo.findById(vehicleId.get()).orElseThrow(()->new ApiRequestException("This Vehicle Id don't exist in our database"));
            Pageable pageable = PageRequest.of(page, sizePage);
            Slice<ParkingInspections> slicedResult = new PageImpl<>(parkingInspectionsRepo.findByVehicle(vehicle,pageable));
            return new PageImpl<>(slicedResult.getContent());
        } else if (slotId.isPresent() && fieldAgentId.isPresent() && vehicleId.isPresent()) {
            //check if parking slot id exist
            ParkingSlot parkingSlot = parkingSlotRepo.findById(slotId.get()).orElseThrow(()->new ApiRequestException("This parking slot id don't exist in our database"));

            //check if field agent exist into database
            FieldAgents fieldAgent = fieldAgentsRepo.findById(fieldAgentId.get()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));

            //check if vehicle id exist into database
            Vehicle vehicle = vehicleRepo.findById(vehicleId.get()).orElseThrow(()->new ApiRequestException("This Vehicle Id don't exist in our database"));
            Pageable pageable = PageRequest.of(page, sizePage);
            Slice<ParkingInspections> slicedResult = new PageImpl<>(parkingInspectionsRepo.findBySlotIdAndFieldAgentsAndVehicle(parkingSlot,fieldAgent,vehicle,pageable));
            return new PageImpl<>(slicedResult.getContent());
        }else {
            return parkingInspectionsRepo.findAll(PageRequest.of(page,sizePage , Sort.Direction.ASC ,sortBy));
        }
    }

    @Override
    public ParkingInspections getSingleParkingInspectionsById(int id) {
        return parkingInspectionsRepo.findById(id).orElseThrow(()->new ApiRequestException("This Parking Inspection Id don't exist in our database"));
    }

    @Override
    public ParkingInspections updateParkingInspections(ParkingInspectionDto parkingInspectionDto, int id) {

        //check if the Parking inspection id exist into db
        ParkingInspections parkingInspections = parkingInspectionsRepo.findById(id).orElseThrow(()->new ApiRequestException("This Parking Inspection Id don't exist in our database"));

            //check if parking slot id exist
            ParkingSlot parkingSlot = parkingSlotRepo.findById(parkingInspectionDto.getSlotId()).orElseThrow(()->new ApiRequestException("This parking slot id don't exist in our database"));

            //check if field agent exist into database
            FieldAgents fieldAgent = fieldAgentsRepo.findById(parkingInspectionDto.getFieldAgentId()).orElseThrow(()->new ApiRequestException("This field agent id don't exist in our database"));

            //check if vehicle id exist into database
            Vehicle paVehicle = vehicleRepo.findById(parkingInspectionDto.getVehicleId()).orElseThrow(()->new ApiRequestException("This Vehicle Id don't exist in our database"));
            //check if status id exist
            Status status = statusesRepo.findById(parkingInspectionDto.getStatusId()).orElseThrow(()->new ApiRequestException("This Status don't exist in our database"));

            String n = String.valueOf(parkingInspectionDto.getIsSystemInitiated());

                parkingInspections.setSlotId(parkingSlot);
                parkingInspections.setFieldAgents(fieldAgent);
                parkingInspections.setVehicle(paVehicle);
                parkingInspections.setIsSystemInitiated(parkingInspectionDto.getIsSystemInitiated());
                parkingInspections.setInitiationTime(LocalDateTime.now());
                parkingInspections.setInspectionTime(LocalDateTime.now());
                parkingInspections.setInspectionCallTimeout(LocalDateTime.now());
                parkingInspections.setStatus(status);
                parkingInspections.setCreatedOnDt(parkingInspections.getCreatedOnDt());
                parkingInspections.setCreatedBy(parkingInspections.getCreatedBy());
                parkingInspections.setUpdatedOnDt(new Date());
                parkingInspections.setUpdatedBy(null);
                return parkingInspectionsRepo.save(parkingInspections);

    }

    @Override
    public void deleteParkingInspections(int id) {
        parkingInspectionsRepo.findById(id).orElseThrow(()->new ApiRequestException("This Parking Inspection Id don't exist in our database"));
        try{
            parkingInspectionsRepo.deleteById(id);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }
    }
}
