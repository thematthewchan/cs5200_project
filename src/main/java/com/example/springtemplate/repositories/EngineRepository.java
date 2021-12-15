package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Engine;
import com.example.springtemplate.models.Vehicle;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EngineRepository extends CrudRepository<Engine, Integer> {
  @Query(value = "SELECT * FROM engines", nativeQuery = true)
  public List<Engine> findAllEngines();

  @Query(value = "SELECT * FROM engines WHERE id=:engineId", nativeQuery = true)
  public Engine findEngineById(@Param("engineId") Integer id);

}
