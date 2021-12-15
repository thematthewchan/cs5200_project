// import userService from '../users/user-service'
import vehicleService from "vehicle-service";

const {Link, useHistory} = window.ReactRouterDOM;
const {useState, useEffect} = React;

const VehicleList = () => {
  const history = useHistory()

  const [vehicles, setVehicles] = useState([])
  useEffect(() => {
    findAllVehicles()
  }, [])

  const findAllVehicles = () =>
      vehicleService.findAllVehicles().then(vehicles => setVehicles(vehicles))

  return(
      <div>
        <h2>Vehicle List</h2>
        <button className="btn btn-primary" onClick={() => history.push("/vehicles/new")}>
          Add Vehicle
        </button>
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

export default VehicleList;