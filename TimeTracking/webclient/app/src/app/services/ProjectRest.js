import CrudRest from "./CrudRest";

class ProjectRest extends CrudRest {
    constructor() {
        super(window.location.pathname + "api/project");
    }
}
export default ProjectRest;
