import React, {useMemo, useEffect} from "react";
import {useParams} from "react-router";
import {useImmer} from "use-immer";
import TimeTrackRest from "../../services/TimeTrackRest";
import ProjectRest from "../../services/ProjectRest";
import EmployeeRest from "../../services/EmployeeRest";
import {
    entityDefault,
    entityFields
} from "../../modifiers/TimeTrackModifier";
import {EntityDetail, addSelectLists} from "@starwit/react-starwit";

function TimeTrackDetail() {
    const [entity, setEntity] = useImmer(entityDefault);
    const [fields, setFields] = useImmer(entityFields);
    const entityRest = useMemo(() => new TimeTrackRest(), []);
    const projectRest = useMemo(() => new ProjectRest(), []);
    const employeeRest = useMemo(() => new EmployeeRest(), []);
    const {id} = useParams();

    useEffect(() => {
        reloadSelectLists();
    }, [id]);

    function reloadSelectLists() {
        const selectLists = [];
        const functions = [
            projectRest.findAll(),
            employeeRest.findAll()
        ];
        Promise.all(functions).then(values => {
            selectLists.push({name: "project", data: values[0].data});
            selectLists.push({name: "myTimetrack", data: values[1].data});
            if (id) {
                entityRest.findById(id).then(response => {
                    setEntity(response.data);
                    addSelectLists(response.data, fields, setFields, selectLists);
                });
            } else {
                addSelectLists(entity, fields, setFields, selectLists);
            }
        });
    }

    return (
        <>
            <EntityDetail
                id={id}
                entity={entity}
                setEntity={setEntity}
                fields={fields}
                setFields={setFields}
                entityRest={entityRest}
                prefix="timeTrack"
            />
        </>

    );
}

export default TimeTrackDetail;
