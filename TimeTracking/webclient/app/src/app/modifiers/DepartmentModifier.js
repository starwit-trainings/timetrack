const entityDefault = {
    name: "",
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
        name: "employee",
        type: "OneToMany",
        regex: null,
        selectList: [],
        display: [
            "name",
            "givenname",
            "profession"
        ],
        selectedIds: []
    }
];

const departmentOverviewFields = [
    {name: "name", type: "string", regex: null}
];

export {
    entityDefault,
    entityFields,
    departmentOverviewFields
};
