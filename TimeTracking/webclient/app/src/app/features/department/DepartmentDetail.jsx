import React, {useMemo, useEffect} from "react";
import {useParams} from "react-router";
import {useImmer} from "use-immer";
import DepartmentRest from "../../services/DepartmentRest";
import EmployeeRest from "../../services/EmployeeRest";
import {
    entityDefault,
    entityFields
} from "../../modifiers/DepartmentModifier";
import {EntityDetail, addSelectLists} from "@starwit/react-starwit";

function DepartmentDetail() {
    const [entity, setEntity] = useImmer(entityDefault);
    const [fields, setFields] = useImmer(entityFields);
    const entityRest = useMemo(() => new DepartmentRest(), []);
    const employeeRest = useMemo(() => new EmployeeRest(), []);
    const {id} = useParams();

    useEffect(() => {
        reloadSelectLists();
    }, [id]);

    function reloadSelectLists() {
        const selectLists = [];
        const functions = [
            employeeRest.findAllWithoutDepartment(id)
        ];
        Promise.all(functions).then(values => {
            selectLists.push({name: "employee", data: values[0].data});
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
                prefix="department"
            />
        </>

    );
}

export default DepartmentDetail;
