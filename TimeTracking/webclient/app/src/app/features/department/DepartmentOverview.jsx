import {Container, Typography, Button, Stack} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useTranslation} from "react-i18next";
import {OverviewTable} from "@starwit/react-starwit";
import DepartmentRest from "../../services/DepartmentRest";
import {useHistory} from "react-router";
import {departmentOverviewFields} from "../../modifiers/DepartmentModifier";

function DepartmentOverview() {
    const [selected, setSelected] = useState(undefined);
    const {t} = useTranslation();
    const departmentRest = useMemo(() => new DepartmentRest(), []);
    const history = useHistory();
    const [departmentAll, setDepartmentAll] = useState();

    useEffect(() => {
        reload();
    }, []);

    function reload() {
        departmentRest.findAll().then(response => {
            setDepartmentAll(response.data);
        });
    }

    function goToCreate() {
        history.push("/department/create");
    }

    function goToUpdate() {
        if (!!selected) {
            history.push("/department/update/" + selected.id);
            setSelected(undefined);
        }
    }

    function handleDelete() {
        if (!!selected) {
            departmentRest.delete(selected.id).then(reload);
            setSelected(undefined);
        }
    }

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>{t("department.title")}</Typography>
            <Stack spacing={2} direction={"row"}>
                <Button onClick={goToCreate} variant="contained" color="secondary">{t("button.create")}</Button>
                <Button onClick={goToUpdate} variant="contained" color="secondary" disabled={!selected?.id} >
                    {t("button.update")}
                </Button>
                <Button onClick={handleDelete} variant="contained" color="secondary" disabled={!selected?.id}>
                    {t("button.delete")}
                </Button>
            </Stack>
            <OverviewTable
                entities={departmentAll}
                prefix={"department"}
                selected={selected}
                onSelect={setSelected}
                fields={departmentOverviewFields}/>
        </Container>
    );
}

export default DepartmentOverview;
