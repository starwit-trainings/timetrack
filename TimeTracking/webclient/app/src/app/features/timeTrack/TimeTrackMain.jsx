import React from "react";
import {Route} from "react-router-dom";
import TimeTrackOverview from "./TimeTrackOverview";
import TimeTrackDetail from "./TimeTrackDetail";

function TimeTrackMain() {
    return (
        <>
            <React.Fragment>
                <Route exact path="/timetrack" component={TimeTrackOverview}/>
                <Route exact path="/timetrack/create" component={TimeTrackDetail}/>
                <Route exact path="/timetrack/update/:id" component={TimeTrackDetail}/>
            </React.Fragment>
        </>
    );
}

export default TimeTrackMain;
