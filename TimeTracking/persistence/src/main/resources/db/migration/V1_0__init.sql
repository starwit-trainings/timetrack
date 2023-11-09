CREATE SEQUENCE IF NOT EXISTS "employee_id_seq";

CREATE TABLE "employee"
(
    "name" VARCHAR(255),
    "givenname" VARCHAR(255),
    "profession" VARCHAR(255),
    "department_id" BIGINT,
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
    "id" BIGINT NOT NULL DEFAULT nextval('project_id_seq'),
    CONSTRAINT "project_pkey" PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS "timetrack_id_seq";

CREATE TABLE "timetrack"
(
    "startdate" DATE,
    "enddate" DATE,
    "project_id" BIGINT,
    "employee_id" BIGINT,
    "id" BIGINT NOT NULL DEFAULT nextval('timetrack_id_seq'),
    CONSTRAINT "timetrack_pkey" PRIMARY KEY ("id")
);

ALTER TABLE "employee"
    ADD CONSTRAINT "fk_employee_department"
    FOREIGN KEY ("department_id")
    REFERENCES "department" ("id");

ALTER TABLE "timetrack"
    ADD CONSTRAINT "fk_timetrack_project"
    FOREIGN KEY ("project_id")
    REFERENCES "project" ("id");

ALTER TABLE "timetrack"
    ADD CONSTRAINT "fk_timetrack_mytimetrack"
    FOREIGN KEY ("employee_id")
    REFERENCES "employee" ("id");

