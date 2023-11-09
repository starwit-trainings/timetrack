const entityDefault = {
    startDate: null,
    endDate: null,
    id: undefined
};

const entityFields = [
    {
        name: "startDate",
        type: "date",
        regex: null,
        notNull: false
    },
    {
        name: "endDate",
        type: "date",
        regex: null,
        notNull: false
    },
    {
        name: "project",
        type: "OneToMany",
        regex: null,
        selectList: [],
        display: [
            "name"
        ],
        selectedIds: []
    },
    {
        name: "myTimetrack",
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

const timeTrackOverviewFields = [
    {name: "startDate", type: "date", regex: null},
    {name: "endDate", type: "date", regex: null}
];

export {
    entityDefault,
    entityFields,
    timeTrackOverviewFields
};
