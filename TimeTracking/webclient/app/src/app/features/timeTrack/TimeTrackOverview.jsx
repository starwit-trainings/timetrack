import {Container, Typography, Button, Stack} from "@mui/material";
import React, {useState, useMemo, useEffect} from "react";
import {useTranslation} from "react-i18next";
import {OverviewTable} from "@starwit/react-starwit";
import TimeTrackRest from "../../services/TimeTrackRest";
import {useHistory} from "react-router";
import {timeTrackOverviewFields} from "../../modifiers/TimeTrackModifier";

function TimeTrackOverview() {
    const [selected, setSelected] = useState(undefined);
    const {t} = useTranslation();
    const timetrackRest = useMemo(() => new TimeTrackRest(), []);
    const history = useHistory();
    const [timeTrackAll, setTimeTrackAll] = useState();

    useEffect(() => {
        reload();
    }, []);

    function reload() {
        timetrackRest.findAll().then(response => {
            setTimeTrackAll(response.data);
        });
    }

    function goToCreate() {
        history.push("/timetrack/create");
    }

    function goToUpdate() {
        if (!!selected) {
            history.push("/timetrack/update/" + selected.id);
            setSelected(undefined);
        }
    }

    function handleDelete() {
        if (!!selected) {
            timetrackRest.delete(selected.id).then(reload);
            setSelected(undefined);
        }
    }

    return (
        <Container>
            <Typography variant={"h2"} gutterBottom>{t("timeTrack.title")}</Typography>
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
                entities={timeTrackAll}
                prefix={"timeTrack"}
                selected={selected}
                onSelect={setSelected}
                fields={timeTrackOverviewFields}/>
        </Container>
    );
}

export default TimeTrackOverview;
