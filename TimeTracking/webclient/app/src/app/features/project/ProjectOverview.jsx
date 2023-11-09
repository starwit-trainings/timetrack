import {Container, Typography, Button, Stack} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useTranslation} from "react-i18next";
import {OverviewTable} from "@starwit/react-starwit";
import ProjectRest from "../../services/ProjectRest";
import {useHistory} from "react-router";
import {projectOverviewFields} from "../../modifiers/ProjectModifier";

function ProjectOverview() {
    const [selected, setSelected] = useState(undefined);
    const {t} = useTranslation();
    const projectRest = useMemo(() => new ProjectRest(), []);
    const history = useHistory();
    const [projectAll, setProjectAll] = useState();

    useEffect(() => {
        reload();
    }, []);

    function reload() {
        projectRest.findAll().then(response => {
            setProjectAll(response.data);
        });
    }

    function goToCreate() {
        history.push("/project/create");
    }

    function goToUpdate() {
        if (!!selected) {
            history.push("/project/update/" + selected.id);
            setSelected(undefined);
        }
    }

    function handleDelete() {
        if (!!selected) {
            projectRest.delete(selected.id).then(reload);
            setSelected(undefined);
        }
    }

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>{t("project.title")}</Typography>
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
                entities={projectAll}
                prefix={"project"}
                selected={selected}
                onSelect={setSelected}
                fields={projectOverviewFields}/>
        </Container>
    );
}

export default ProjectOverview;
