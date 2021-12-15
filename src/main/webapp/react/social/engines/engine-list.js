// import userService from '../users/user-service'
import engineService from "./engine-service";

const {Link, useHistory} = window.ReactRouterDOM;
const {useState, useEffect} = React;

const EngineList = () => {
  const history = useHistory()

  const [engines, setEngines] = useState([])
  useEffect(() => {
    findAllEngines()
  }, [])

  const findAllEngines = () =>
      engineService.findAllEngines().then(engines => setEngines(engines))

  return(
      <div>
        <h2>Engine List</h2>
        <button className="btn btn-primary" onClick={() => history.push("/engines/new")}>
          Add Engine
        </button>
        <ul className="list-group">
          {
            engines.map(engine =>
                <li className="list-group-item"
                    key={engine.id}>
                  <Link to={`/engines/${engine.id}`}>
                  {engine.id},
                  {engine.layout}-
                    {engine.cylinder},
                    {engine.displacement} liters,
                  {engine.horsepower} hp,
                  {engine.torque} lb-ft,
                  {engine.redline} rpm
                  </Link>
                </li>)
          }
        </ul>

      </div>
  )
}

export default EngineList;