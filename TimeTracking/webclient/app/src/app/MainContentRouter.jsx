import React from "react";
import {Route, Switch} from "react-router-dom";
import EmployeeMain from "./features/employee/EmployeeMain";
import DepartmentMain from "./features/department/DepartmentMain";
import ProjectMain from "./features/project/ProjectMain";
import TimeTrackMain from "./features/timeTrack/TimeTrackMain";
import Home from "./features/home/Home";

function MainContentRouter() {
    return (
        <>
            <Switch>
                <Route path={"/employee"} component={EmployeeMain}/>
                <Route path={"/department"} component={DepartmentMain}/>
                <Route path={"/project"} component={ProjectMain}/>
                <Route path={"/timetrack"} component={TimeTrackMain}/>
            </Switch>
            <Route exact path={"/"} component={Home}/>
            <Route path="/logout" component={() => {
                window.location.href = window.location.pathname + "api/user/logout";
                return null;
            }}/>
        </>
    );
}

export default MainContentRouter;
