import CrudRest from "./CrudRest";
import axios from "axios";

class ProjectRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/project");
    }

    findAllWithoutTimeTrack(selected) {
        if (isNaN(selected)) {
            return axios.get(this.baseUrl + "/find-without-timetrack");
        } else {
            return axios.get(this.baseUrl + "/find-without-other-timetrack/" + selected);
        }
    }
}
export default ProjectRest;
