CREATE SEQUENCE IF NOT EXISTS "employee_id_seq";

CREATE TABLE "employee"
(
    "name" VARCHAR(255),
    "givenname" VARCHAR(255),
    "profession" VARCHAR(255),
    "department_id" BIGINT,
    "timetrack_id" BIGINT,
    "id" BIGINT NOT NULL DEFAULT nextval('employee_id_seq'),
    CONSTRAINT "employee_pkey" PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS "department_id_seq";

CREATE TABLE "department"
(
    "name" VARCHAR(255),
    "id" BIGINT NOT NULL DEFAULT nextval('department_id_seq'),
    CONSTRAINT "department_pkey" PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS "project_id_seq";

CREATE TABLE "project"
(
    "name" VARCHAR(255),
    "timetrack_id" BIGINT,
    "id" BIGINT NOT NULL DEFAULT nextval('project_id_seq'),
    CONSTRAINT "project_pkey" PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS "timetrack_id_seq";

CREATE TABLE "timetrack"
(
    "startdate" DATE,
    "enddate" DATE,
    "id" BIGINT NOT NULL DEFAULT nextval('timetrack_id_seq'),
    CONSTRAINT "timetrack_pkey" PRIMARY KEY ("id")
);

ALTER TABLE "employee"
    ADD CONSTRAINT "fk_employee_department"
    FOREIGN KEY ("department_id")
    REFERENCES "department" ("id");

ALTER TABLE "employee"
    ADD CONSTRAINT "fk_employee_employeetimetrack"
    FOREIGN KEY ("timetrack_id")
    REFERENCES "timetrack" ("id");

ALTER TABLE "project"
    ADD CONSTRAINT "fk_project_timetrack"
    FOREIGN KEY ("timetrack_id")
    REFERENCES "timetrack" ("id");

