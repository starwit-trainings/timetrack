const entityDefault = {
    name: "",
    givenname: "",
    profession: "",
    id: undefined
};

const entityFields = [
    {
        name: "name",
        type: "string",
        regex: null,
        notNull: false
    },
    {
        name: "givenname",
        type: "string",
        regex: null,
        notNull: false
    },
    {
        name: "profession",
        type: "string",
        regex: null,
        notNull: false
    },
];

const employeeOverviewFields = [
    {name: "name", type: "string", regex: null},
    {name: "givenname", type: "string", regex: null},
    {name: "profession", type: "string", regex: null}
];

export {
    entityDefault,
    entityFields,
    employeeOverviewFields
};
