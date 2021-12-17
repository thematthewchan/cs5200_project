import engineService from "./engine-service";
import vehicleService from "../vehicles/vehicle-service";

const {useState, useEffect} = React;
const {useParams, useHistory, Link} = window.ReactRouterDOM;

const EngineFormEditor = () => {
  const history1 = useHistory()
        const {id} = useParams()
  const [engine, setEngine] = useState([])
  const [vehicles, setVehicles] = useState([])
  useEffect(() => {
    if(id !== "new") {
      findEngineById(id);
      findVehiclesByEngineId(id);
    }
  }, []);

    const findEngineById = (id) => engineService.findEngineById(id).then(engine => setEngine(engine))


  const deleteEngine = (id) => {
      engineService.deleteEngine(id)
      .then(() => history.back())
    }
  const createEngine = (engine) =>
      engineService.createEngine(engine)
      .then(() => history.back())

  const updateEngine = (id, newEngine) =>
      engineService.updateEngine(id, newEngine)
      .then(() => history.back())

  const findVehiclesByEngineId = (id) => vehicleService.findVehicleByEngineId(id).then(vehicles => setVehicles(vehicles))

  return (
        <div>
            <h2>Engine Editor</h2>
            <label>Id</label>
                <input className="form-control" value={engine.id}/><br/>

            <label>Layout</label>
          <input
              className="form-control"
              value={engine.layout}
              onChange={(e) => setEngine(vehicle => ({...vehicle, layout: e.target.value}))}
              /><br/>
          <label>Cylinder</label>

          <input className="form-control" value={engine.cylinder}
                 onChange={(e) => setEngine(vehicle => ({...vehicle, cylinder: e.target.value}))}
          /><br/>
            <label>Displacement</label>
          <input className="form-control" value={engine.displacement}
                 onChange={(e) => setEngine(vehicle => ({...vehicle, displacement: e.target.value}))}
          /><br/>
          <label>Horsepower</label>

          <input className="form-control" value={engine.horsepower}
                 onChange={(e) => setEngine(vehicle => ({...vehicle, horsepower: e.target.value}))}
          /><br/>
          <label>Torque</label>

          <input className="form-control" value={engine.torque}
                 onChange={(e) => setEngine(vehicle => ({...vehicle, torque: e.target.value}))}
          /><br/>
          <label>Redline</label>

          <input className="form-control" value={engine.redline}
                 onChange={(e) => setEngine(vehicle => ({...vehicle, redline: e.target.value}))}
          /><br/>


            <button onClick={() => {
                    history.back()}}
                    className="btn btn-warning">
              Cancel
            </button>
          <button className="btn btn-danger" onClick={() => deleteEngine(id)}>
            Delete
          </button>
          <button className="btn btn-primary" onClick={() => updateEngine(engine.id, engine)}>Save</button>
          <button className="btn btn-success" onClick={() => createEngine(engine)}>Create</button>

          <br/>

          <h3>Vehicles With This Engine</h3>
          <ul className="list-group">
            {
              vehicles.map(vehicle =>
                  <li className="list-group-item"
                      key={vehicle.id}>
                     <Link to={`/vehicles/${vehicle.id}`}>
                       {vehicle.id},
                       {vehicle.year},
                       {vehicle.make},
                       {vehicle.model},
                       {vehicle.bodystyle},
                       {vehicle.color},
                       {vehicle.userId}
                     </Link>
                   </li>)
            }
          </ul>
        </div>
    )
}

export default EngineFormEditor