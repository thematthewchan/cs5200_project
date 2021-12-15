package com.example.springtemplate.daos;

import com.example.springtemplate.models.Engine;
import com.example.springtemplate.models.Vehicle;
import com.example.springtemplate.repositories.EngineRepository;
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
public class EngineRestOrmDao {

  @Autowired
  EngineRepository engineRepository;


  @PostMapping("/api/engines")
  public Engine createEngine(@RequestBody Engine engine) {
    return engineRepository.save(engine);
  }

//  @GetMapping("/api/users/{userId}/vehicles")
//  public List<Vehicle> findVehiclesForUser(
//      @PathVariable("userId") Integer uid) {
//    System.out.println("finding for uid: " + uid);
//    return engineRepository.findVehicleByUserId(uid);
//  }

  @GetMapping("/api/engines")
  public List<Engine> findAllEngines() {
    System.out.println("finding all vehicles");
    return engineRepository.findAllEngines();
  }

  @GetMapping("/api/engines/{eid}")
  public Engine findEngineById(
      @PathVariable("eid") Integer eid) {
    System.out.println("finding vehicle: " + eid);
    return engineRepository.findEngineById(eid);
  }

  @PutMapping("/api/engines/{eid}")
  public Engine updateEngine(
      @PathVariable("eid") Integer id,
      @RequestBody() Engine newEngine) {
    Engine engine = this.findEngineById(id);
    engine.setId(newEngine.getId());
    engine.setCylinder(newEngine.getCylinder());
    engine.setDisplacement(newEngine.getDisplacement());
    engine.setHorsepower(newEngine.getHorsepower());
    engine.setLayout(newEngine.getLayout());
    engine.setRedline(newEngine.getRedline());
    engine.setTorque(newEngine.getTorque());
    return engineRepository.save(engine);
  }

  @DeleteMapping("/api/engines/{eid}")
  public void deleteEngine(
      @PathVariable("eid") Integer id) {
    engineRepository.deleteById(id);
  }
}
