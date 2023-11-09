import {Container, Typography, Button, Stack} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useTranslation} from "react-i18next";
import {OverviewTable} from "@starwit/react-starwit";
import EmployeeRest from "../../services/EmployeeRest";
import {useHistory} from "react-router";
import {employeeOverviewFields} from "../../modifiers/EmployeeModifier";

function EmployeeOverview() {
    const [selected, setSelected] = useState(undefined);
    const {t} = useTranslation();
    const employeeRest = useMemo(() => new EmployeeRest(), []);
    const history = useHistory();
    const [employeeAll, setEmployeeAll] = useState();

    useEffect(() => {
        reload();
    }, []);

    function reload() {
        employeeRest.findAll().then(response => {
            setEmployeeAll(response.data);
        });
    }

    function goToCreate() {
        history.push("/employee/create");
    }

    function goToUpdate() {
        if (!!selected) {
            history.push("/employee/update/" + selected.id);
            setSelected(undefined);
        }
    }

    function handleDelete() {
        if (!!selected) {
            employeeRest.delete(selected.id).then(reload);
            setSelected(undefined);
        }
    }

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>{t("employee.title")}</Typography>
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
                entities={employeeAll}
                prefix={"employee"}
                selected={selected}
                onSelect={setSelected}
                fields={employeeOverviewFields}/>
        </Container>
    );
}

export default EmployeeOverview;
