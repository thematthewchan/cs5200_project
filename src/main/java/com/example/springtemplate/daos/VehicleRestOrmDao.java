package com.example.springtemplate.daos;

import com.example.springtemplate.models.Course;
import com.example.springtemplate.models.Section;
import com.example.springtemplate.models.User;
import com.example.springtemplate.models.Vehicle;
import com.example.springtemplate.repositories.UserRestRepository;
import com.example.springtemplate.repositories.VehicleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class VehicleRestOrmDao {

  @Autowired
  VehicleRepository vehicleRepository;


  @PostMapping("/api/vehicles")
  public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }

  @PostMapping("/api/users/{userId}/vehicles")
  public Vehicle createVehicleForUser(
      @PathVariable("userId") Integer uid,
      @RequestBody Vehicle vehicle) {
    vehicle = vehicleRepository.save(vehicle);
    vehicle.setUserId(uid);
    return vehicleRepository.save(vehicle);
  }

  @GetMapping("/api/users/{userId}/vehicles")
  public List<Vehicle> findVehiclesForUser(
      @PathVariable("userId") Integer uid) {
    System.out.println("finding for uid: " + uid);
    return vehicleRepository.findVehicleByUserId(uid);
  }

  @GetMapping("/api/engines/{engineId}/vehicles")
  public List<Vehicle> findVehiclesWithEngine(
      @PathVariable("engineId") Integer eid) {
    return vehicleRepository.findVehicleByEngineId(eid);
  }


  @GetMapping("/api/vehicles")
  public List<Vehicle> findAllVehicles() {
    System.out.println("finding all vehicles");
    return vehicleRepository.findAllVehicles();
  }

  @GetMapping("/api/vehicles/{vid}")
  public Vehicle findVehicleById(
      @PathVariable("vid") Integer vid) {
    System.out.println("finding vehicle: " + vid);
    return vehicleRepository.findById(vid).get();
  }

  @PutMapping("/api/vehicles/{vid}")
  public Vehicle updateVehicle(
      @PathVariable("vid") Integer id,
      @RequestBody() Vehicle newVehicle) {
    Vehicle vehicle = this.findVehicleById(id);
    vehicle.setId(newVehicle.getId());
    vehicle.setYear(newVehicle.getYear());
    vehicle.setMake(newVehicle.getMake());
    vehicle.setModel(newVehicle.getModel());
    vehicle.setBodystyle(newVehicle.getBodystyle());
    vehicle.setColor(newVehicle.getColor());
    vehicle.setUserId(newVehicle.getUserId());
    vehicle.setEngineId(newVehicle.getEngineId());
    return vehicleRepository.save(vehicle);
  }

  @DeleteMapping("/api/vehicles/{vid}")
  public void deleteVehicle(
      @PathVariable("vid") Integer id) {
    vehicleRepository.deleteById(id);
  }
}
