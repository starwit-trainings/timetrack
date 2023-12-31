import CrudRest from "./CrudRest";
import axios from "axios";

class EmployeeRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/employee");
    }

    findAllWithoutDepartment(selected) {
        if (isNaN(selected)) {
            return axios.get(this.baseUrl + "/find-without-department");
        } else {
            return axios.get(this.baseUrl + "/find-without-other-department/" + selected);
        }
    }

    findAllWithoutEmployeeTimeTrack(selected) {
        if (isNaN(selected)) {
            return axios.get(this.baseUrl + "/find-without-timetrack");
        } else {
            return axios.get(this.baseUrl + "/find-without-other-timetrack/" + selected);
        }
    }
}
export default EmployeeRest;
