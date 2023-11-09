import CrudRest from "./CrudRest";

class DepartmentRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/department");
    }
}
export default DepartmentRest;
