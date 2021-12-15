import UserList from "./users/user-list";
import UserFormEditor from "./users/user-form-editor";
import VehicleList from "./vehicles/vehicle-list";
import VehicleFormEditor from "./vehicles/vehicle-form-editor";
import EngineList from "./engines/engine-list";
import EngineFormEditor from "./engines/engine-form-editor";
const {HashRouter, Route} = window.ReactRouterDOM;
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/users", "/"]} exact={true}>
                    <UserList/>
                </Route>
                <Route path="/users/:id" exact={true}>
                    <UserFormEditor/>
                </Route>
                <Route path="/vehicles" exact={true}>
                    <VehicleList/>
                </Route>
                <Route path="/vehicles/:id" exact={true}>
                    <VehicleFormEditor/>
                </Route>
                <Route path="/engines" exact={true}>
                    <EngineList/>
                </Route>
                <Route path="/engines/:id" exact={true}>
                    <EngineFormEditor/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
