-- // create_task
-- Migration SQL that makes the change goes here.

CREATE TABLE task
(
  task_id SERIAL PRIMARY KEY,
  description CHARACTER VARYING(255),
  duration CHARACTER VARYING(255)
);

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE task;