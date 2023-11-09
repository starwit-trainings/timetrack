import CrudRest from "./CrudRest";
import axios from "axios";

class TimeTrackRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/timetrack");
    }

    findAllWithoutProject(selected) {
        if (isNaN(selected)) {
            return axios.get(this.baseUrl + "/find-without-project");
        } else {
            return axios.get(this.baseUrl + "/find-without-other-project/" + selected);
        }
    }

    findAllWithoutMyTimetrack(selected) {
        if (isNaN(selected)) {
            return axios.get(this.baseUrl + "/find-without-myTimetrack");
        } else {
            return axios.get(this.baseUrl + "/find-without-other-myTimetrack/" + selected);
        }
    }
}
export default TimeTrackRest;
