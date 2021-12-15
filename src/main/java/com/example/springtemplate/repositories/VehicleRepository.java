package com.example.springtemplate.repositories;

import com.example.springtemplate.models.User;
import com.example.springtemplate.models.Vehicle;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
  @Query(value = "SELECT * FROM vehicles", nativeQuery = true)
  public List<Vehicle> findAllVehicles();

  @Query(value = "SELECT * FROM vehicles WHERE id=:vehicleId", nativeQuery = true)
  public Vehicle findVehicleById(@Param("vehicleId") Integer id);

  @Query(value = "SELECT * FROM vehicles WHERE user_id=:userId", nativeQuery = true)
  public List<Vehicle> findVehicleByUserId(@Param("userId") Integer id);

  @Query(value = "SELECT * FROM vehicles WHERE engine_id=:engineId", nativeQuery = true)
  public List<Vehicle> findVehicleByEngineId(@Param("engineId") Integer id);
}
