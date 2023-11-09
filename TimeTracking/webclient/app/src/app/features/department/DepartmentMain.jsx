import React from "react";
import {Route} from "react-router-dom";
import DepartmentOverview from "./DepartmentOverview";
import DepartmentDetail from "./DepartmentDetail";

function DepartmentMain() {
    return (
        <>
            <React.Fragment>
                <Route exact path="/department" component={DepartmentOverview}/>
                <Route exact path="/department/create" component={DepartmentDetail}/>
                <Route exact path="/department/update/:id" component={DepartmentDetail}/>
            </React.Fragment>
        </>
    );
}

export default DepartmentMain;
