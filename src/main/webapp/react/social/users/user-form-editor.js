import userService from "./user-service";
import vehicleService from "../vehicles/vehicle-service";

const {useState, useEffect} = React;
const {useParams, Link, useHistory} = window.ReactRouterDOM;

const UserFormEditor = () => {
        const {id} = useParams()
  const [user, setUser] = useState([])
  const [vehicles, setVehicles] = useState([])
  useEffect(() => {
    if(id !== "new") {
      findUserById(id);
      findVehiclesByUserId(id);

    }
  }, []);

    const findUserById = (id) => userService.findUserById(id).then(user => setUser(user))
    // .then(findVehiclesByUserId(id))
    const deleteUser = (id) => {
      console.log(user)
      userService.deleteUser(id)
      .then(() => history.back())
    }
  const createUser = (user) =>
      userService.createUser(user)
      .then(() => history.back())

  const updateUser = (id, newUser) =>
      userService.updateUser(id, newUser)
      .then(() => history.back())

  const findVehiclesByUserId = (id) => vehicleService.findVehicleByUserId(id).then(vehicles => setVehicles(vehicles))

  return (
        <div>
            <h2>User Editor</h2>
          <label>Id</label>
          <input className="form-control" value={user.id}/><br/>

          <label>First Name</label>
          <input
              className="form-control"
              value={user.firstName}
              onChange={(e) => setUser(user => ({...user, firstName: e.target.value}))}/><br/>
          <label>Last Name</label>
          <input className="form-control" value={user.lastName} onChange={(e) =>
              setUser(user =>
                  ({...user, lastName: e.target.value}))}
          /><br/>
          <label>Username</label>
          <input className="form-control" value={user.username} onChange={(e) =>
              setUser(user =>
                  ({...user, username: e.target.value}))}
          /><br/>
          <label>Password</label>
          <input className="form-control" value={user.password} onChange={(e) =>
              setUser(user =>
                  ({...user, password: e.target.value}))}
          /><br/>

          <button onClick={() => {
            console.log(user)
            history.back()}}
                  className="btn btn-warning">
            Cancel
          </button>
          <button className="btn btn-danger" onClick={() => deleteUser(id)}>
            Delete
          </button>
          <button className="btn btn-primary" onClick={() => updateUser(user.id, user)}>Save</button>
          <button className="btn btn-success" onClick={() => createUser(user)}>Create</button>



          <br/>

          <h3>User's Vehicles</h3>
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

export default UserFormEditor


