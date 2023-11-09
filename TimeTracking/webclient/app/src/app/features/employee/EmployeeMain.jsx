import React from "react";
import {Route} from "react-router-dom";
import EmployeeOverview from "./EmployeeOverview";
import EmployeeDetail from "./EmployeeDetail";

function EmployeeMain() {
    return (
        <>
            <React.Fragment>
                <Route exact path="/employee" component={EmployeeOverview}/>
                <Route exact path="/employee/create" component={EmployeeDetail}/>
                <Route exact path="/employee/update/:id" component={EmployeeDetail}/>
            </React.Fragment>
        </>
    );
}

export default EmployeeMain;
