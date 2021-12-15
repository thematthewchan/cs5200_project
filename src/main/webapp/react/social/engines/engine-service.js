// TODO: declare URL where server listens for HTTP requests
const ENGINES_URL = "http://localhost:8080/api/engines"

// TODO: retrieve all users from the server
export const findAllEngines = () =>
  fetch(ENGINES_URL).then(response =>
    response.json())

// TODO: retrieve a single user by their ID
export const findEngineById = (id) => fetch(`${ENGINES_URL}/${id}`).then(response => response.json())

// TODO: delete a user by their ID
export const deleteEngine = (id) =>
    fetch(`${ENGINES_URL}/${id}`, {
      method: "DELETE"
    })

// TODO: create a new user
export const createEngine = (engine) => fetch(ENGINES_URL, {
  method: 'POST',
  body: JSON.stringify(engine),
  headers: {'content-type': 'application/json'}
})
.then(response => response.json())


// TODO: update a user by their ID
export const updateEngine = (id, engine) =>
    fetch(`${ENGINES_URL}/${id}`, {
      method: 'PUT',
      body: JSON.stringify(engine),
      headers: {'content-type': 'application/json'}
    })
    .then(response => response.json())


// TODO: export all functions as the API to this service
export default {
  findAllEngines,
  findEngineById,
  deleteEngine,
  createEngine,
  updateEngine
}
