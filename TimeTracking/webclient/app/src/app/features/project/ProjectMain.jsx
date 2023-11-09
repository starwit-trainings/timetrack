import React from "react";
import {Route} from "react-router-dom";
import ProjectOverview from "./ProjectOverview";
import ProjectDetail from "./ProjectDetail";

function ProjectMain() {
    return (
        <>
            <React.Fragment>
                <Route exact path="/project" component={ProjectOverview}/>
                <Route exact path="/project/create" component={ProjectDetail}/>
                <Route exact path="/project/update/:id" component={ProjectDetail}/>
            </React.Fragment>
        </>
    );
}

export default ProjectMain;
