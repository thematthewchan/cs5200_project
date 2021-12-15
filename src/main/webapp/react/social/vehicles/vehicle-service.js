// TODO: declare URL where server listens for HTTP requests
const USERS_URL = "http://localhost:8080/api/users"
const VEHICLES_URL = "http://localhost:8080/api/vehicles"
const ENGINES_URL = "http://localhost:8080/api/engines"

// TODO: retrieve all users from the server
export const findAllVehicles = () =>
  fetch(VEHICLES_URL).then(response =>
    response.json())

// TODO: retrieve a single user by their ID
export const findVehicleById = (id) => fetch(`${VEHICLES_URL}/${id}`).then(response => response.json())

export const findVehicleByUserId = (userid) => fetch(`${USERS_URL}/${userid}/vehicles`).then(response => response.json())

export const findVehicleByEngineId = (engineId) => fetch(`${ENGINES_URL}/${engineId}/vehicles`).then(response => response.json())


// TODO: delete a user by their ID
export const deleteVehicle = (id) =>
    fetch(`${VEHICLES_URL}/${id}`, {
      method: "DELETE"
    })

// TODO: create a new user
export const createVehicle = (vehicle) => fetch(VEHICLES_URL, {
  method: 'POST',
  body: JSON.stringify(vehicle),
  headers: {'content-type': 'application/json'}
})
.then(response => response.json())


// TODO: update a user by their ID
export const updateVehicle = (id, vehicle) =>
    fetch(`${VEHICLES_URL}/${id}`, {
      method: 'PUT',
      body: JSON.stringify(vehicle),
      headers: {'content-type': 'application/json'}
    })
    .then(response => response.json())


// TODO: export all functions as the API to this service
export default {
  findAllVehicles,
  findVehicleById,
  findVehicleByUserId,
  findVehicleByEngineId,
  deleteVehicle,
  createVehicle,
  updateVehicle
}
