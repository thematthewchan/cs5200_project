import vehicleService, {findVehicleById} from "./vehicle-service";

const {useState, useEffect} = React;
const {useParams, useHistory} = window.ReactRouterDOM;

const VehicleFormEditor = () => {
  const history1 = useHistory()
        const {id} = useParams()
  const [vehicle, setVehicle] = useState({})
  useEffect(() => {
    if(id !== "new") {
      findVehicleById(id);
    }
  }, []);

    const findVehicleById = (id) => vehicleService.findVehicleById(id).then(vehicle => setVehicle(vehicle))

    const deleteVehicle = (id) => {
      vehicleService.deleteVehicle(id)
      .then(() => history.back())
    }
  const createUser = (vehicle) =>
      vehicleService.createVehicle(vehicle)
      .then(() => history.back())

  const updateUser = (id, newVehicle) =>
      vehicleService.updateVehicle(id, newVehicle)
      .then(() => history.back())

  return (
        <div>
            <h2>Vehicle Editor</h2>
            <label>Id</label>
                <input className="form-control" value={vehicle.id}/><br/>

            <label>Year</label>
          <input
              className="form-control"
              value={vehicle.year}
              onChange={(e) => setVehicle(vehicle => ({...vehicle, year: e.target.value}))}
              /><br/>
            <label>Make</label>
          <input className="form-control" value={vehicle.make}
                 onChange={(e) => setVehicle(vehicle => ({...vehicle, make: e.target.value}))}
          /><br/>
          <label>Model</label>

          <input className="form-control" value={vehicle.model}
                 onChange={(e) => setVehicle(vehicle => ({...vehicle, model: e.target.value}))}
          /><br/>
          <label>Bodystyle</label>

          <input className="form-control" value={vehicle.bodystyle}
                 onChange={(e) => setVehicle(vehicle => ({...vehicle, bodystyle: e.target.value}))}
          /><br/>
          <label>Color</label>

          <input className="form-control" value={vehicle.color}
                 onChange={(e) => setVehicle(vehicle => ({...vehicle, color: e.target.value}))}
          /><br/>
          <button onClick={() => history1.push(`/users/${vehicle.userId}`)}>User ID</button>

          <input className="form-control" value={vehicle.userId}
                 onChange={(e) => setVehicle(vehicle => ({...vehicle, userId: e.target.value}))}
          /><br/>

          <button onClick={() => history1.push(`/engines/${vehicle.engineId}`)}>Engine ID</button>
          <input className="form-control" value={vehicle.engineId}
                 onChange={(e) => setVehicle(vehicle => ({...vehicle, engineId: e.target.value}))}
          /><br/>


            <button onClick={() => {
                    history.back()}}
                    className="btn btn-warning">
              Cancel
            </button>
          <button className="btn btn-danger" onClick={() => deleteVehicle(id)}>
            Delete
          </button>
          <button className="btn btn-primary" onClick={() => updateUser(vehicle.id, vehicle)}>Save</button>
          <button className="btn btn-success" onClick={() => createUser(vehicle)}>Create</button>

          <br/>

        </div>
    )
}

export default VehicleFormEditor