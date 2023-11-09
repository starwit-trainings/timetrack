import CrudRest from "./CrudRest";

class TimeTrackRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/timetrack");
    }
}
export default TimeTrackRest;
