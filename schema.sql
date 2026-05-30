--
-- PostgreSQL database dump
--

\restrict btmB2GVUIipoIFcccPiYfh8Pfrcu3q5TWx2ZDlNMUNefGkIS9ji9KH6eOqQIaIl

-- Dumped from database version 16.14 (Ubuntu 16.14-0ubuntu0.24.04.1)
-- Dumped by pg_dump version 16.14 (Ubuntu 16.14-0ubuntu0.24.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: lmsnew
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO lmsnew;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: answeroption; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.answeroption (
    id integer NOT NULL,
    optionvalue character varying(255),
    sequence integer,
    question integer
);


ALTER TABLE public.answeroption OWNER TO lmsnew;

--
-- Name: answeroption_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.answeroption_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.answeroption_id_seq OWNER TO lmsnew;

--
-- Name: answeroption_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.answeroption_id_seq OWNED BY public.answeroption.id;


--
-- Name: answeroptiontemplate; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.answeroptiontemplate (
    id integer NOT NULL,
    answeroptiontemplate character varying(255)
);


ALTER TABLE public.answeroptiontemplate OWNER TO lmsnew;

--
-- Name: answeroptiontemplate_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.answeroptiontemplate_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.answeroptiontemplate_id_seq OWNER TO lmsnew;

--
-- Name: answeroptiontemplate_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.answeroptiontemplate_id_seq OWNED BY public.answeroptiontemplate.id;


--
-- Name: answeroptiontemplateitem; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.answeroptiontemplateitem (
    id integer NOT NULL,
    answeroption character varying(255),
    answeroptiontemplateid integer
);


ALTER TABLE public.answeroptiontemplateitem OWNER TO lmsnew;

--
-- Name: answeroptiontemplateitem_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.answeroptiontemplateitem_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.answeroptiontemplateitem_id_seq OWNER TO lmsnew;

--
-- Name: answeroptiontemplateitem_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.answeroptiontemplateitem_id_seq OWNED BY public.answeroptiontemplateitem.id;


--
-- Name: assignment; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.assignment (
    id integer NOT NULL,
    assignment character varying(255),
    content text,
    assignmentkey text,
    module integer,
    durationdays integer,
    archivedat timestamp without time zone
);


ALTER TABLE public.assignment OWNER TO lmsnew;

--
-- Name: assignment_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.assignment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.assignment_id_seq OWNER TO lmsnew;

--
-- Name: assignment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.assignment_id_seq OWNED BY public.assignment.id;


--
-- Name: assignmentsubmission; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.assignmentsubmission (
    id integer NOT NULL,
    content text,
    assignment integer,
    enrollment integer,
    submissionstatus integer,
    file_url character varying(255),
    comment character varying(255),
    createdat timestamp without time zone,
    score numeric(19,2),
    submittedat timestamp without time zone
);


ALTER TABLE public.assignmentsubmission OWNER TO lmsnew;

--
-- Name: assignmentsubmission_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.assignmentsubmission_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.assignmentsubmission_id_seq OWNER TO lmsnew;

--
-- Name: assignmentsubmission_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.assignmentsubmission_id_seq OWNED BY public.assignmentsubmission.id;


--
-- Name: attachment; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.attachment (
    id integer NOT NULL,
    file_url character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    link_id integer NOT NULL,
    created_at timestamp without time zone,
    type character varying(255),
    link_type character varying(255) NOT NULL
);


ALTER TABLE public.attachment OWNER TO lmsnew;

--
-- Name: attachment_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.attachment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.attachment_id_seq OWNER TO lmsnew;

--
-- Name: attachment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.attachment_id_seq OWNED BY public.attachment.id;


--
-- Name: attendance; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.attendance (
    id integer NOT NULL,
    ispresent boolean,
    enrollment integer,
    module integer,
    session character varying(255)
);


ALTER TABLE public.attendance OWNER TO lmsnew;

--
-- Name: attendance_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.attendance_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.attendance_id_seq OWNER TO lmsnew;

--
-- Name: attendance_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.attendance_id_seq OWNED BY public.attendance.id;


--
-- Name: batch; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.batch (
    id bigint NOT NULL,
    batch character varying(255),
    location character varying(255),
    start_date timestamp with time zone,
    batch_status_id integer,
    country_id integer,
    course_id integer,
    startdate timestamp with time zone,
    batchstatus integer,
    country integer,
    course integer,
    enddate timestamp with time zone
);


ALTER TABLE public.batch OWNER TO lmsnew;

--
-- Name: batch_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.batch_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.batch_id_seq OWNER TO lmsnew;

--
-- Name: batch_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.batch_id_seq OWNED BY public.batch.id;


--
-- Name: batch_module_enrollment_assignment; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.batch_module_enrollment_assignment (
    id integer NOT NULL,
    createdat timestamp without time zone,
    assignment_id integer NOT NULL,
    batch_module_id integer NOT NULL,
    created_by integer,
    enrollment_id integer NOT NULL
);


ALTER TABLE public.batch_module_enrollment_assignment OWNER TO lmsnew;

--
-- Name: batch_module_enrollment_assignment_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.batch_module_enrollment_assignment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.batch_module_enrollment_assignment_id_seq OWNER TO lmsnew;

--
-- Name: batch_module_enrollment_assignment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.batch_module_enrollment_assignment_id_seq OWNED BY public.batch_module_enrollment_assignment.id;


--
-- Name: batch_module_progress; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.batch_module_progress (
    id integer NOT NULL,
    createdat timestamp without time zone,
    status character varying(255) NOT NULL,
    batch_module_id integer NOT NULL,
    enrollment_id integer NOT NULL,
    updated_by integer
);


ALTER TABLE public.batch_module_progress OWNER TO lmsnew;

--
-- Name: batch_module_progress_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.batch_module_progress_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.batch_module_progress_id_seq OWNER TO lmsnew;

--
-- Name: batch_module_progress_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.batch_module_progress_id_seq OWNED BY public.batch_module_progress.id;


--
-- Name: batch_module_trainer; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.batch_module_trainer (
    id integer NOT NULL,
    batchmodule integer NOT NULL,
    batchtrainer integer NOT NULL
);


ALTER TABLE public.batch_module_trainer OWNER TO lmsnew;

--
-- Name: batch_module_trainer_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.batch_module_trainer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.batch_module_trainer_id_seq OWNER TO lmsnew;

--
-- Name: batch_module_trainer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.batch_module_trainer_id_seq OWNED BY public.batch_module_trainer.id;


--
-- Name: batchmentor; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.batchmentor (
    id integer NOT NULL,
    batchid integer,
    mentorid integer
);


ALTER TABLE public.batchmentor OWNER TO lmsnew;

--
-- Name: batchmentor_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.batchmentor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.batchmentor_id_seq OWNER TO lmsnew;

--
-- Name: batchmentor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.batchmentor_id_seq OWNED BY public.batchmentor.id;


--
-- Name: batchmodule; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.batchmodule (
    id integer NOT NULL,
    batchid integer,
    moduleid integer
);


ALTER TABLE public.batchmodule OWNER TO lmsnew;

--
-- Name: batchmodule_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.batchmodule_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.batchmodule_id_seq OWNER TO lmsnew;

--
-- Name: batchmodule_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.batchmodule_id_seq OWNED BY public.batchmodule.id;


--
-- Name: batchstatus; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.batchstatus (
    id integer NOT NULL,
    batchstatus character varying(255)
);


ALTER TABLE public.batchstatus OWNER TO lmsnew;

--
-- Name: batchstatus_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.batchstatus_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.batchstatus_id_seq OWNER TO lmsnew;

--
-- Name: batchstatus_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.batchstatus_id_seq OWNED BY public.batchstatus.id;


--
-- Name: batchsurvey; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.batchsurvey (
    id integer NOT NULL,
    linkrole character varying(255),
    receipientrole character varying(255),
    surveyid integer,
    batchid integer,
    assigntoallroles boolean
);


ALTER TABLE public.batchsurvey OWNER TO lmsnew;

--
-- Name: batchsurvey_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.batchsurvey_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.batchsurvey_id_seq OWNER TO lmsnew;

--
-- Name: batchsurvey_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.batchsurvey_id_seq OWNED BY public.batchsurvey.id;


--
-- Name: batchtrainer; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.batchtrainer (
    id integer NOT NULL,
    batchid integer,
    trainerid integer
);


ALTER TABLE public.batchtrainer OWNER TO lmsnew;

--
-- Name: batchtrainer_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.batchtrainer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.batchtrainer_id_seq OWNER TO lmsnew;

--
-- Name: batchtrainer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.batchtrainer_id_seq OWNED BY public.batchtrainer.id;


--
-- Name: competencycategory; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.competencycategory (
    id integer NOT NULL,
    competencycategory character varying(255)
);


ALTER TABLE public.competencycategory OWNER TO lmsnew;

--
-- Name: competencycategory_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.competencycategory_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.competencycategory_id_seq OWNER TO lmsnew;

--
-- Name: competencycategory_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.competencycategory_id_seq OWNED BY public.competencycategory.id;


--
-- Name: competencycriterion; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.competencycriterion (
    id integer NOT NULL,
    comptenecycriterion character varying(255),
    competencycategoryid integer
);


ALTER TABLE public.competencycriterion OWNER TO lmsnew;

--
-- Name: competencycriterion_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.competencycriterion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.competencycriterion_id_seq OWNER TO lmsnew;

--
-- Name: competencycriterion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.competencycriterion_id_seq OWNED BY public.competencycriterion.id;


--
-- Name: country; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.country (
    id integer NOT NULL,
    country character varying(255)
);


ALTER TABLE public.country OWNER TO lmsnew;

--
-- Name: country_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.country_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.country_id_seq OWNER TO lmsnew;

--
-- Name: country_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.country_id_seq OWNED BY public.country.id;


--
-- Name: course; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.course (
    id integer NOT NULL,
    title character varying(255),
    description character varying(255)
);


ALTER TABLE public.course OWNER TO lmsnew;

--
-- Name: course_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.course_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.course_id_seq OWNER TO lmsnew;

--
-- Name: course_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.course_id_seq OWNED BY public.course.id;


--
-- Name: coursesurvey; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.coursesurvey (
    id integer NOT NULL,
    surveyid integer,
    courseid integer,
    linkrole character varying(255),
    receipientrole character varying(255)
);


ALTER TABLE public.coursesurvey OWNER TO lmsnew;

--
-- Name: coursesurvey_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.coursesurvey_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.coursesurvey_id_seq OWNER TO lmsnew;

--
-- Name: coursesurvey_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.coursesurvey_id_seq OWNED BY public.coursesurvey.id;


--
-- Name: dailyupdate; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.dailyupdate (
    id integer NOT NULL,
    date timestamp without time zone,
    field1 character varying(255),
    field2 character varying(255),
    field3 character varying(255),
    batchid integer
);


ALTER TABLE public.dailyupdate OWNER TO lmsnew;

--
-- Name: dailyupdate_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.dailyupdate_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.dailyupdate_id_seq OWNER TO lmsnew;

--
-- Name: dailyupdate_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.dailyupdate_id_seq OWNED BY public.dailyupdate.id;


--
-- Name: dailyupdatemodule; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.dailyupdatemodule (
    id integer NOT NULL,
    dailyupdateid integer,
    moduleid integer
);


ALTER TABLE public.dailyupdatemodule OWNER TO lmsnew;

--
-- Name: dailyupdatemodule_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.dailyupdatemodule_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.dailyupdatemodule_id_seq OWNER TO lmsnew;

--
-- Name: dailyupdatemodule_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.dailyupdatemodule_id_seq OWNED BY public.dailyupdatemodule.id;


--
-- Name: dailyupdatemoduleattendance; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.dailyupdatemoduleattendance (
    id integer NOT NULL,
    attendance boolean,
    dailyupdatemoduleid integer,
    enrollmentid integer,
    session character varying(255)
);


ALTER TABLE public.dailyupdatemoduleattendance OWNER TO lmsnew;

--
-- Name: dailyupdatemoduleattendance_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.dailyupdatemoduleattendance_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.dailyupdatemoduleattendance_id_seq OWNER TO lmsnew;

--
-- Name: dailyupdatemoduleattendance_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.dailyupdatemoduleattendance_id_seq OWNED BY public.dailyupdatemoduleattendance.id;


--
-- Name: enrollment; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.enrollment (
    id integer NOT NULL,
    batch bigint,
    student integer,
    role character varying(255)
);


ALTER TABLE public.enrollment OWNER TO lmsnew;

--
-- Name: enrollment_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.enrollment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.enrollment_id_seq OWNER TO lmsnew;

--
-- Name: enrollment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.enrollment_id_seq OWNED BY public.enrollment.id;


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.hibernate_sequence OWNER TO lmsnew;

--
-- Name: image; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.image (
    id integer NOT NULL,
    defaultimage boolean,
    filename character varying(255),
    filesize integer,
    filetype character varying(255),
    image oid
);


ALTER TABLE public.image OWNER TO lmsnew;

--
-- Name: image_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.image_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.image_id_seq OWNER TO lmsnew;

--
-- Name: image_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.image_id_seq OWNED BY public.image.id;


--
-- Name: language; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.language (
    id integer NOT NULL,
    block character varying(255),
    district character varying(255),
    languagename character varying(255),
    state character varying(255),
    village character varying(255),
    personid integer,
    tempid bigint
);


ALTER TABLE public.language OWNER TO lmsnew;

--
-- Name: language_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.language_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.language_id_seq OWNER TO lmsnew;

--
-- Name: language_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.language_id_seq OWNED BY public.language.id;


--
-- Name: mentor; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.mentor (
    id integer NOT NULL,
    mentorid integer
);


ALTER TABLE public.mentor OWNER TO lmsnew;

--
-- Name: mentor_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.mentor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.mentor_id_seq OWNER TO lmsnew;

--
-- Name: mentor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.mentor_id_seq OWNED BY public.mentor.id;


--
-- Name: module; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.module (
    id integer NOT NULL,
    description character varying(255),
    module character varying(255),
    course integer
);


ALTER TABLE public.module OWNER TO lmsnew;

--
-- Name: module_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.module_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.module_id_seq OWNER TO lmsnew;

--
-- Name: module_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.module_id_seq OWNED BY public.module.id;


--
-- Name: participant; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.participant (
    id integer NOT NULL,
    person integer,
    role character varying(255)
);


ALTER TABLE public.participant OWNER TO lmsnew;

--
-- Name: participant_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.participant_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.participant_id_seq OWNER TO lmsnew;

--
-- Name: participant_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.participant_id_seq OWNED BY public.participant.id;


--
-- Name: person; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.person (
    id integer NOT NULL,
    email character varying(255),
    firstname character varying(255),
    lastname character varying(255),
    phone character varying(255),
    country character varying(255),
    dob date,
    fathername character varying(255),
    gender character varying(255),
    maritalstatus character varying(255),
    address character varying(255),
    presentaddresscountry character varying(255),
    presentaddresspin character varying(255),
    presentaddressstate character varying(255),
    zone character varying(255),
    presentstatus character varying(255),
    rollnumber character varying(255),
    spousename character varying(255),
    state character varying(100),
    region character varying(100),
    country_id integer,
    validationstatus character varying(255),
    enrollmentdate date,
    highestqualification character varying(255),
    middlename character varying(255),
    photo character varying(255),
    validationcomment character varying(255),
    pincode character varying(10),
    presentaddresscity character varying(255),
    presentaddressstreet character varying(255),
    date_of_joining date,
    date_of_leaving date,
    reasonofleaving character varying(255)
);


ALTER TABLE public.person OWNER TO lmsnew;

--
-- Name: person_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.person_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.person_id_seq OWNER TO lmsnew;

--
-- Name: person_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.person_id_seq OWNED BY public.person.id;


--
-- Name: question; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.question (
    id integer NOT NULL,
    childorder integer,
    section character varying(255),
    surveyorder integer,
    text character varying(255),
    parentquestion integer,
    questiontype integer,
    surveyid integer
);


ALTER TABLE public.question OWNER TO lmsnew;

--
-- Name: question_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.question_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.question_id_seq OWNER TO lmsnew;

--
-- Name: question_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.question_id_seq OWNED BY public.question.id;


--
-- Name: questiontype; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.questiontype (
    id integer NOT NULL,
    questiontype character varying(255)
);


ALTER TABLE public.questiontype OWNER TO lmsnew;

--
-- Name: questiontype_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.questiontype_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.questiontype_id_seq OWNER TO lmsnew;

--
-- Name: questiontype_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.questiontype_id_seq OWNED BY public.questiontype.id;


--
-- Name: response; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.response (
    id integer NOT NULL,
    link_id integer,
    link_type character varying(255),
    participant integer,
    survey integer,
    linkcomment character varying(255),
    batchid integer,
    role character varying(255),
    language integer
);


ALTER TABLE public.response OWNER TO lmsnew;

--
-- Name: response_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.response_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.response_id_seq OWNER TO lmsnew;

--
-- Name: response_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.response_id_seq OWNED BY public.response.id;


--
-- Name: responseanswers; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.responseanswers (
    id integer NOT NULL,
    answertext character varying(255),
    answeroption integer,
    question integer,
    response integer,
    multipleansweroptions character varying(255)
);


ALTER TABLE public.responseanswers OWNER TO lmsnew;

--
-- Name: responseanswers_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.responseanswers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.responseanswers_id_seq OWNER TO lmsnew;

--
-- Name: responseanswers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.responseanswers_id_seq OWNED BY public.responseanswers.id;


--
-- Name: role; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.role (
    id integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.role OWNER TO lmsnew;

--
-- Name: session_attendance; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.session_attendance (
    id integer NOT NULL,
    attendance boolean NOT NULL,
    enrollmentid integer NOT NULL,
    sessionid integer NOT NULL
);


ALTER TABLE public.session_attendance OWNER TO lmsnew;

--
-- Name: session_attendance_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.session_attendance_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.session_attendance_id_seq OWNER TO lmsnew;

--
-- Name: session_attendance_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.session_attendance_id_seq OWNED BY public.session_attendance.id;


--
-- Name: session_batch_module; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.session_batch_module (
    id integer NOT NULL,
    createdat timestamp without time zone,
    batch_module_id integer NOT NULL,
    session_id integer NOT NULL
);


ALTER TABLE public.session_batch_module OWNER TO lmsnew;

--
-- Name: session_batch_module_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.session_batch_module_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.session_batch_module_id_seq OWNER TO lmsnew;

--
-- Name: session_batch_module_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.session_batch_module_id_seq OWNED BY public.session_batch_module.id;


--
-- Name: sessions; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.sessions (
    id integer NOT NULL,
    date date,
    name character varying(255) NOT NULL,
    batch integer NOT NULL,
    batchmodule integer NOT NULL
);


ALTER TABLE public.sessions OWNER TO lmsnew;

--
-- Name: sessions_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.sessions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.sessions_id_seq OWNER TO lmsnew;

--
-- Name: sessions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.sessions_id_seq OWNED BY public.sessions.id;


--
-- Name: submission_reviews; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.submission_reviews (
    id integer NOT NULL,
    comments character varying(255),
    created_at timestamp without time zone,
    score numeric(19,2),
    status character varying(255),
    assignmentsubmission integer,
    reviewedby integer
);


ALTER TABLE public.submission_reviews OWNER TO lmsnew;

--
-- Name: submission_reviews_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.submission_reviews_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.submission_reviews_id_seq OWNER TO lmsnew;

--
-- Name: submission_reviews_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.submission_reviews_id_seq OWNED BY public.submission_reviews.id;


--
-- Name: submissionstatus; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.submissionstatus (
    id integer NOT NULL,
    submissionstatus character varying(255)
);


ALTER TABLE public.submissionstatus OWNER TO lmsnew;

--
-- Name: submissionstatus_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.submissionstatus_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.submissionstatus_id_seq OWNER TO lmsnew;

--
-- Name: submissionstatus_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.submissionstatus_id_seq OWNED BY public.submissionstatus.id;


--
-- Name: survey; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.survey (
    id integer NOT NULL,
    survey character varying(255),
    survey_type character varying(255),
    surveyrole character varying(255)
);


ALTER TABLE public.survey OWNER TO lmsnew;

--
-- Name: survey_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.survey_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.survey_id_seq OWNER TO lmsnew;

--
-- Name: survey_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.survey_id_seq OWNED BY public.survey.id;


--
-- Name: test_table; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.test_table (
    id integer NOT NULL,
    name character varying(100)
);


ALTER TABLE public.test_table OWNER TO lmsnew;

--
-- Name: test_table_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.test_table_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.test_table_id_seq OWNER TO lmsnew;

--
-- Name: test_table_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.test_table_id_seq OWNED BY public.test_table.id;


--
-- Name: trainer; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.trainer (
    id integer NOT NULL,
    trainerid integer
);


ALTER TABLE public.trainer OWNER TO lmsnew;

--
-- Name: trainer_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.trainer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.trainer_id_seq OWNER TO lmsnew;

--
-- Name: trainer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.trainer_id_seq OWNED BY public.trainer.id;


--
-- Name: user; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public."user" (
    id integer NOT NULL,
    login character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    "personId" integer
);


ALTER TABLE public."user" OWNER TO lmsnew;

--
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: lmsnew
--

CREATE SEQUENCE public.user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_id_seq OWNER TO lmsnew;

--
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: lmsnew
--

ALTER SEQUENCE public.user_id_seq OWNED BY public."user".id;


--
-- Name: user_role; Type: TABLE; Schema: public; Owner: lmsnew
--

CREATE TABLE public.user_role (
    user_id integer NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE public.user_role OWNER TO lmsnew;

--
-- Name: answeroption id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.answeroption ALTER COLUMN id SET DEFAULT nextval('public.answeroption_id_seq'::regclass);


--
-- Name: answeroptiontemplate id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.answeroptiontemplate ALTER COLUMN id SET DEFAULT nextval('public.answeroptiontemplate_id_seq'::regclass);


--
-- Name: answeroptiontemplateitem id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.answeroptiontemplateitem ALTER COLUMN id SET DEFAULT nextval('public.answeroptiontemplateitem_id_seq'::regclass);


--
-- Name: assignment id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.assignment ALTER COLUMN id SET DEFAULT nextval('public.assignment_id_seq'::regclass);


--
-- Name: assignmentsubmission id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.assignmentsubmission ALTER COLUMN id SET DEFAULT nextval('public.assignmentsubmission_id_seq'::regclass);


--
-- Name: attachment id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.attachment ALTER COLUMN id SET DEFAULT nextval('public.attachment_id_seq'::regclass);


--
-- Name: attendance id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.attendance ALTER COLUMN id SET DEFAULT nextval('public.attendance_id_seq'::regclass);


--
-- Name: batch id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch ALTER COLUMN id SET DEFAULT nextval('public.batch_id_seq'::regclass);


--
-- Name: batch_module_enrollment_assignment id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_enrollment_assignment ALTER COLUMN id SET DEFAULT nextval('public.batch_module_enrollment_assignment_id_seq'::regclass);


--
-- Name: batch_module_progress id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_progress ALTER COLUMN id SET DEFAULT nextval('public.batch_module_progress_id_seq'::regclass);


--
-- Name: batch_module_trainer id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_trainer ALTER COLUMN id SET DEFAULT nextval('public.batch_module_trainer_id_seq'::regclass);


--
-- Name: batchmentor id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchmentor ALTER COLUMN id SET DEFAULT nextval('public.batchmentor_id_seq'::regclass);


--
-- Name: batchmodule id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchmodule ALTER COLUMN id SET DEFAULT nextval('public.batchmodule_id_seq'::regclass);


--
-- Name: batchstatus id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchstatus ALTER COLUMN id SET DEFAULT nextval('public.batchstatus_id_seq'::regclass);


--
-- Name: batchsurvey id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchsurvey ALTER COLUMN id SET DEFAULT nextval('public.batchsurvey_id_seq'::regclass);


--
-- Name: batchtrainer id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchtrainer ALTER COLUMN id SET DEFAULT nextval('public.batchtrainer_id_seq'::regclass);


--
-- Name: competencycategory id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.competencycategory ALTER COLUMN id SET DEFAULT nextval('public.competencycategory_id_seq'::regclass);


--
-- Name: competencycriterion id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.competencycriterion ALTER COLUMN id SET DEFAULT nextval('public.competencycriterion_id_seq'::regclass);


--
-- Name: country id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.country ALTER COLUMN id SET DEFAULT nextval('public.country_id_seq'::regclass);


--
-- Name: course id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.course ALTER COLUMN id SET DEFAULT nextval('public.course_id_seq'::regclass);


--
-- Name: coursesurvey id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.coursesurvey ALTER COLUMN id SET DEFAULT nextval('public.coursesurvey_id_seq'::regclass);


--
-- Name: dailyupdate id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.dailyupdate ALTER COLUMN id SET DEFAULT nextval('public.dailyupdate_id_seq'::regclass);


--
-- Name: dailyupdatemodule id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.dailyupdatemodule ALTER COLUMN id SET DEFAULT nextval('public.dailyupdatemodule_id_seq'::regclass);


--
-- Name: dailyupdatemoduleattendance id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.dailyupdatemoduleattendance ALTER COLUMN id SET DEFAULT nextval('public.dailyupdatemoduleattendance_id_seq'::regclass);


--
-- Name: enrollment id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.enrollment ALTER COLUMN id SET DEFAULT nextval('public.enrollment_id_seq'::regclass);


--
-- Name: image id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.image ALTER COLUMN id SET DEFAULT nextval('public.image_id_seq'::regclass);


--
-- Name: language id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.language ALTER COLUMN id SET DEFAULT nextval('public.language_id_seq'::regclass);


--
-- Name: mentor id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.mentor ALTER COLUMN id SET DEFAULT nextval('public.mentor_id_seq'::regclass);


--
-- Name: module id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.module ALTER COLUMN id SET DEFAULT nextval('public.module_id_seq'::regclass);


--
-- Name: participant id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.participant ALTER COLUMN id SET DEFAULT nextval('public.participant_id_seq'::regclass);


--
-- Name: person id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.person ALTER COLUMN id SET DEFAULT nextval('public.person_id_seq'::regclass);


--
-- Name: question id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.question ALTER COLUMN id SET DEFAULT nextval('public.question_id_seq'::regclass);


--
-- Name: questiontype id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.questiontype ALTER COLUMN id SET DEFAULT nextval('public.questiontype_id_seq'::regclass);


--
-- Name: response id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.response ALTER COLUMN id SET DEFAULT nextval('public.response_id_seq'::regclass);


--
-- Name: responseanswers id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.responseanswers ALTER COLUMN id SET DEFAULT nextval('public.responseanswers_id_seq'::regclass);


--
-- Name: session_attendance id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.session_attendance ALTER COLUMN id SET DEFAULT nextval('public.session_attendance_id_seq'::regclass);


--
-- Name: session_batch_module id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.session_batch_module ALTER COLUMN id SET DEFAULT nextval('public.session_batch_module_id_seq'::regclass);


--
-- Name: sessions id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.sessions ALTER COLUMN id SET DEFAULT nextval('public.sessions_id_seq'::regclass);


--
-- Name: submission_reviews id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.submission_reviews ALTER COLUMN id SET DEFAULT nextval('public.submission_reviews_id_seq'::regclass);


--
-- Name: submissionstatus id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.submissionstatus ALTER COLUMN id SET DEFAULT nextval('public.submissionstatus_id_seq'::regclass);


--
-- Name: survey id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.survey ALTER COLUMN id SET DEFAULT nextval('public.survey_id_seq'::regclass);


--
-- Name: test_table id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.test_table ALTER COLUMN id SET DEFAULT nextval('public.test_table_id_seq'::regclass);


--
-- Name: trainer id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.trainer ALTER COLUMN id SET DEFAULT nextval('public.trainer_id_seq'::regclass);


--
-- Name: user id; Type: DEFAULT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public."user" ALTER COLUMN id SET DEFAULT nextval('public.user_id_seq'::regclass);


--
-- Name: answeroption answeroption_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.answeroption
    ADD CONSTRAINT answeroption_pkey PRIMARY KEY (id);


--
-- Name: answeroptiontemplate answeroptiontemplate_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.answeroptiontemplate
    ADD CONSTRAINT answeroptiontemplate_pkey PRIMARY KEY (id);


--
-- Name: answeroptiontemplateitem answeroptiontemplateitem_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.answeroptiontemplateitem
    ADD CONSTRAINT answeroptiontemplateitem_pkey PRIMARY KEY (id);


--
-- Name: assignment assignment_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.assignment
    ADD CONSTRAINT assignment_pkey PRIMARY KEY (id);


--
-- Name: assignmentsubmission assignmentsubmission_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.assignmentsubmission
    ADD CONSTRAINT assignmentsubmission_pkey PRIMARY KEY (id);


--
-- Name: attachment attachment_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.attachment
    ADD CONSTRAINT attachment_pkey PRIMARY KEY (id);


--
-- Name: attendance attendance_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.attendance
    ADD CONSTRAINT attendance_pkey PRIMARY KEY (id);


--
-- Name: batch_module_enrollment_assignment batch_module_enrollment_assignment_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_enrollment_assignment
    ADD CONSTRAINT batch_module_enrollment_assignment_pkey PRIMARY KEY (id);


--
-- Name: batch_module_progress batch_module_progress_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_progress
    ADD CONSTRAINT batch_module_progress_pkey PRIMARY KEY (id);


--
-- Name: batch_module_trainer batch_module_trainer_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_trainer
    ADD CONSTRAINT batch_module_trainer_pkey PRIMARY KEY (id);


--
-- Name: batch batch_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch
    ADD CONSTRAINT batch_pkey PRIMARY KEY (id);


--
-- Name: batchmentor batchmentor_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchmentor
    ADD CONSTRAINT batchmentor_pkey PRIMARY KEY (id);


--
-- Name: batchmodule batchmodule_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchmodule
    ADD CONSTRAINT batchmodule_pkey PRIMARY KEY (id);


--
-- Name: batchstatus batchstatus_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchstatus
    ADD CONSTRAINT batchstatus_pkey PRIMARY KEY (id);


--
-- Name: batchsurvey batchsurvey_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchsurvey
    ADD CONSTRAINT batchsurvey_pkey PRIMARY KEY (id);


--
-- Name: batchtrainer batchtrainer_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchtrainer
    ADD CONSTRAINT batchtrainer_pkey PRIMARY KEY (id);


--
-- Name: competencycategory competencycategory_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.competencycategory
    ADD CONSTRAINT competencycategory_pkey PRIMARY KEY (id);


--
-- Name: competencycriterion competencycriterion_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.competencycriterion
    ADD CONSTRAINT competencycriterion_pkey PRIMARY KEY (id);


--
-- Name: country country_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.country
    ADD CONSTRAINT country_pkey PRIMARY KEY (id);


--
-- Name: course course_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);


--
-- Name: coursesurvey coursesurvey_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.coursesurvey
    ADD CONSTRAINT coursesurvey_pkey PRIMARY KEY (id);


--
-- Name: dailyupdate dailyupdate_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.dailyupdate
    ADD CONSTRAINT dailyupdate_pkey PRIMARY KEY (id);


--
-- Name: dailyupdatemodule dailyupdatemodule_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.dailyupdatemodule
    ADD CONSTRAINT dailyupdatemodule_pkey PRIMARY KEY (id);


--
-- Name: dailyupdatemoduleattendance dailyupdatemoduleattendance_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.dailyupdatemoduleattendance
    ADD CONSTRAINT dailyupdatemoduleattendance_pkey PRIMARY KEY (id);


--
-- Name: enrollment enrollment_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.enrollment
    ADD CONSTRAINT enrollment_pkey PRIMARY KEY (id);


--
-- Name: image image_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT image_pkey PRIMARY KEY (id);


--
-- Name: language language_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.language
    ADD CONSTRAINT language_pkey PRIMARY KEY (id);


--
-- Name: mentor mentor_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.mentor
    ADD CONSTRAINT mentor_pkey PRIMARY KEY (id);


--
-- Name: module module_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.module
    ADD CONSTRAINT module_pkey PRIMARY KEY (id);


--
-- Name: participant participant_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.participant
    ADD CONSTRAINT participant_pkey PRIMARY KEY (id);


--
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


--
-- Name: questiontype questiontype_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.questiontype
    ADD CONSTRAINT questiontype_pkey PRIMARY KEY (id);


--
-- Name: response response_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.response
    ADD CONSTRAINT response_pkey PRIMARY KEY (id);


--
-- Name: responseanswers responseanswers_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.responseanswers
    ADD CONSTRAINT responseanswers_pkey PRIMARY KEY (id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: session_attendance session_attendance_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.session_attendance
    ADD CONSTRAINT session_attendance_pkey PRIMARY KEY (id);


--
-- Name: session_batch_module session_batch_module_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.session_batch_module
    ADD CONSTRAINT session_batch_module_pkey PRIMARY KEY (id);


--
-- Name: sessions sessions_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.sessions
    ADD CONSTRAINT sessions_pkey PRIMARY KEY (id);


--
-- Name: submission_reviews submission_reviews_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.submission_reviews
    ADD CONSTRAINT submission_reviews_pkey PRIMARY KEY (id);


--
-- Name: submissionstatus submissionstatus_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.submissionstatus
    ADD CONSTRAINT submissionstatus_pkey PRIMARY KEY (id);


--
-- Name: survey survey_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.survey
    ADD CONSTRAINT survey_pkey PRIMARY KEY (id);


--
-- Name: test_table test_table_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.test_table
    ADD CONSTRAINT test_table_pkey PRIMARY KEY (id);


--
-- Name: trainer trainer_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.trainer
    ADD CONSTRAINT trainer_pkey PRIMARY KEY (id);


--
-- Name: session_batch_module uk8tr8uxe58jjw346h64es3hc6c; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.session_batch_module
    ADD CONSTRAINT uk8tr8uxe58jjw346h64es3hc6c UNIQUE (session_id, batch_module_id);


--
-- Name: role uk_8sewwnpamngi6b1dwaa88askk; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT uk_8sewwnpamngi6b1dwaa88askk UNIQUE (name);


--
-- Name: batch_module_trainer ukf3n5bvvuu9579xkdt3hbrd3kf; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_trainer
    ADD CONSTRAINT ukf3n5bvvuu9579xkdt3hbrd3kf UNIQUE (batchmodule, batchtrainer);


--
-- Name: enrollment ukkeo83bfdh5ute5f40wwo7wqmt; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.enrollment
    ADD CONSTRAINT ukkeo83bfdh5ute5f40wwo7wqmt UNIQUE (student, batch);


--
-- Name: batch_module_enrollment_assignment ukontryrndbvo9citwdmjrl9wer; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_enrollment_assignment
    ADD CONSTRAINT ukontryrndbvo9citwdmjrl9wer UNIQUE (batch_module_id, enrollment_id, assignment_id);


--
-- Name: batch_module_progress ukphk8i1kl34ta47ek6ymluw4aa; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_progress
    ADD CONSTRAINT ukphk8i1kl34ta47ek6ymluw4aa UNIQUE (enrollment_id, batch_module_id);


--
-- Name: enrollment unique_student_per_batch; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.enrollment
    ADD CONSTRAINT unique_student_per_batch UNIQUE (student, batch);


--
-- Name: user user_login_key; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_login_key UNIQUE (login);


--
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- Name: user_role user_role_pkey; Type: CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id);


--
-- Name: batch fk10emupofbe3vo2y72jauq6yyr; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch
    ADD CONSTRAINT fk10emupofbe3vo2y72jauq6yyr FOREIGN KEY (country_id) REFERENCES public.country(id);


--
-- Name: batch_module_trainer fk18xsswx6fwgoqennr4p74r5r1; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_trainer
    ADD CONSTRAINT fk18xsswx6fwgoqennr4p74r5r1 FOREIGN KEY (batchtrainer) REFERENCES public.batchtrainer(id);


--
-- Name: batch_module_progress fk1j1c6we4cbj5gpwao43dv30rr; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_progress
    ADD CONSTRAINT fk1j1c6we4cbj5gpwao43dv30rr FOREIGN KEY (updated_by) REFERENCES public.person(id);


--
-- Name: responseanswers fk29ejlgvdubh7647q7wdsucvk5; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.responseanswers
    ADD CONSTRAINT fk29ejlgvdubh7647q7wdsucvk5 FOREIGN KEY (question) REFERENCES public.question(id);


--
-- Name: session_attendance fk2ai6cue2qnb24sa7dsj1oes0a; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.session_attendance
    ADD CONSTRAINT fk2ai6cue2qnb24sa7dsj1oes0a FOREIGN KEY (enrollmentid) REFERENCES public.enrollment(id) ON DELETE CASCADE;


--
-- Name: batch_module_trainer fk2peboa490l7myy9qk01dgmvci; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_trainer
    ADD CONSTRAINT fk2peboa490l7myy9qk01dgmvci FOREIGN KEY (batchmodule) REFERENCES public.batchmodule(id);


--
-- Name: batch fk45c5f17cfdqm5roqx9l50o6lx; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch
    ADD CONSTRAINT fk45c5f17cfdqm5roqx9l50o6lx FOREIGN KEY (batch_status_id) REFERENCES public.batchstatus(id);


--
-- Name: batch_module_enrollment_assignment fk4ug9i409v2h7k46cnracn9x7f; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_enrollment_assignment
    ADD CONSTRAINT fk4ug9i409v2h7k46cnracn9x7f FOREIGN KEY (created_by) REFERENCES public.person(id);


--
-- Name: attendance fk4uqc0rrqddofbv04rpkykdbej; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.attendance
    ADD CONSTRAINT fk4uqc0rrqddofbv04rpkykdbej FOREIGN KEY (module) REFERENCES public.module(id);


--
-- Name: batch_module_progress fk5p9lx0t6hcklv00kyurr0kqqt; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_progress
    ADD CONSTRAINT fk5p9lx0t6hcklv00kyurr0kqqt FOREIGN KEY (enrollment_id) REFERENCES public.enrollment(id);


--
-- Name: module fk6ws5robk7tmw9h2wid04v2w9s; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.module
    ADD CONSTRAINT fk6ws5robk7tmw9h2wid04v2w9s FOREIGN KEY (course) REFERENCES public.course(id);


--
-- Name: submission_reviews fk7bvs7hl5xx7j8egi9wp96kt3a; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.submission_reviews
    ADD CONSTRAINT fk7bvs7hl5xx7j8egi9wp96kt3a FOREIGN KEY (assignmentsubmission) REFERENCES public.assignmentsubmission(id);


--
-- Name: language fk7dsw3asy4m44xlisf64pm0bfv; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.language
    ADD CONSTRAINT fk7dsw3asy4m44xlisf64pm0bfv FOREIGN KEY (personid) REFERENCES public.person(id);


--
-- Name: person fk80fgkxnj3itdo4jih9xi66r59; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT fk80fgkxnj3itdo4jih9xi66r59 FOREIGN KEY (country_id) REFERENCES public.country(id);


--
-- Name: assignmentsubmission fk8h8qj524a492o7jsyy06o7dwa; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.assignmentsubmission
    ADD CONSTRAINT fk8h8qj524a492o7jsyy06o7dwa FOREIGN KEY (enrollment) REFERENCES public.enrollment(id) ON DELETE CASCADE;


--
-- Name: coursesurvey fk8w2sfod52fmjfak7hd55ebreg; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.coursesurvey
    ADD CONSTRAINT fk8w2sfod52fmjfak7hd55ebreg FOREIGN KEY (courseid) REFERENCES public.course(id);


--
-- Name: batch fk9q8cbfuvcrxg047nqu1p5keqa; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch
    ADD CONSTRAINT fk9q8cbfuvcrxg047nqu1p5keqa FOREIGN KEY (country) REFERENCES public.country(id);


--
-- Name: batch fk9xlnc4lyo5msotbbyialoyhgk; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch
    ADD CONSTRAINT fk9xlnc4lyo5msotbbyialoyhgk FOREIGN KEY (batchstatus) REFERENCES public.batchstatus(id);


--
-- Name: user_role fka68196081fvovjhkek5m97n3y; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fka68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- Name: enrollment fkammbmpw9hnxv8h6alol2jlejn; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.enrollment
    ADD CONSTRAINT fkammbmpw9hnxv8h6alol2jlejn FOREIGN KEY (student) REFERENCES public.person(id);


--
-- Name: response fkb5omrs46idoyanvfmc2l24dqe; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.response
    ADD CONSTRAINT fkb5omrs46idoyanvfmc2l24dqe FOREIGN KEY (participant) REFERENCES public.participant(id);


--
-- Name: mentor fkbdjaxyw09nfhj12byrfyaxv2f; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.mentor
    ADD CONSTRAINT fkbdjaxyw09nfhj12byrfyaxv2f FOREIGN KEY (mentorid) REFERENCES public.person(id);


--
-- Name: sessions fkbj7k7e62pm0120atmw2on0p0a; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.sessions
    ADD CONSTRAINT fkbj7k7e62pm0120atmw2on0p0a FOREIGN KEY (batch) REFERENCES public.batch(id);


--
-- Name: batchmodule fkcd4s20fsl2wjm7raa394j87tp; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchmodule
    ADD CONSTRAINT fkcd4s20fsl2wjm7raa394j87tp FOREIGN KEY (moduleid) REFERENCES public.module(id);


--
-- Name: assignmentsubmission fkcfhpseduvdw8oh33x9le5b5lg; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.assignmentsubmission
    ADD CONSTRAINT fkcfhpseduvdw8oh33x9le5b5lg FOREIGN KEY (submissionstatus) REFERENCES public.submissionstatus(id);


--
-- Name: batch_module_enrollment_assignment fkcgsc0s8nt36hw5lb7a8r4qxs1; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_enrollment_assignment
    ADD CONSTRAINT fkcgsc0s8nt36hw5lb7a8r4qxs1 FOREIGN KEY (batch_module_id) REFERENCES public.batchmodule(id);


--
-- Name: batch fkcldw8jcf5sujwc47tssrxs8m0; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch
    ADD CONSTRAINT fkcldw8jcf5sujwc47tssrxs8m0 FOREIGN KEY (batchstatus) REFERENCES public.batchstatus(id);


--
-- Name: dailyupdatemodule fkdkbnag77o32r0ichp6fkvjh32; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.dailyupdatemodule
    ADD CONSTRAINT fkdkbnag77o32r0ichp6fkvjh32 FOREIGN KEY (dailyupdateid) REFERENCES public.dailyupdate(id);


--
-- Name: batchsurvey fkdv1xwxpspjaeb0g0jxac0q3ar; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchsurvey
    ADD CONSTRAINT fkdv1xwxpspjaeb0g0jxac0q3ar FOREIGN KEY (batchid) REFERENCES public.batch(id);


--
-- Name: batch_module_enrollment_assignment fkea7eyhf0f8ttxidmhjglaw6dv; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_enrollment_assignment
    ADD CONSTRAINT fkea7eyhf0f8ttxidmhjglaw6dv FOREIGN KEY (enrollment_id) REFERENCES public.enrollment(id);


--
-- Name: enrollment fkf28eb2ac8ed8lxqlemf7f73go; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.enrollment
    ADD CONSTRAINT fkf28eb2ac8ed8lxqlemf7f73go FOREIGN KEY (batch) REFERENCES public.batch(id);


--
-- Name: batchtrainer fkfl0s26u4i8t6hffrunp9ovlbe; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchtrainer
    ADD CONSTRAINT fkfl0s26u4i8t6hffrunp9ovlbe FOREIGN KEY (batchid) REFERENCES public.batch(id);


--
-- Name: batchmentor fkfvyt6ts2vmjwfk6f5a1gtg5wo; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchmentor
    ADD CONSTRAINT fkfvyt6ts2vmjwfk6f5a1gtg5wo FOREIGN KEY (batchid) REFERENCES public.batch(id);


--
-- Name: answeroption fkgeqf45g86yjo2ufu43w0vpr0g; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.answeroption
    ADD CONSTRAINT fkgeqf45g86yjo2ufu43w0vpr0g FOREIGN KEY (question) REFERENCES public.question(id) ON DELETE CASCADE;


--
-- Name: responseanswers fkgfb15lifxccbvop34f37c2c5x; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.responseanswers
    ADD CONSTRAINT fkgfb15lifxccbvop34f37c2c5x FOREIGN KEY (answeroption) REFERENCES public.answeroption(id);


--
-- Name: batch_module_progress fkgh48sk8d26rlb2ihfsj0et7g3; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_progress
    ADD CONSTRAINT fkgh48sk8d26rlb2ihfsj0et7g3 FOREIGN KEY (batch_module_id) REFERENCES public.batchmodule(id);


--
-- Name: submission_reviews fkgqa0ovcl14mqlbxx30nkir3kw; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.submission_reviews
    ADD CONSTRAINT fkgqa0ovcl14mqlbxx30nkir3kw FOREIGN KEY (reviewedby) REFERENCES public.batch_module_trainer(id);


--
-- Name: trainer fkh31avwp2er54n1jhupof70kjq; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.trainer
    ADD CONSTRAINT fkh31avwp2er54n1jhupof70kjq FOREIGN KEY (trainerid) REFERENCES public.person(id);


--
-- Name: response fkh6yp8oijqiy2u0x2ldra4g4wj; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.response
    ADD CONSTRAINT fkh6yp8oijqiy2u0x2ldra4g4wj FOREIGN KEY (language) REFERENCES public.language(id);


--
-- Name: dailyupdatemoduleattendance fkh9e0k9i29yfr8hp1vhje945e8; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.dailyupdatemoduleattendance
    ADD CONSTRAINT fkh9e0k9i29yfr8hp1vhje945e8 FOREIGN KEY (dailyupdatemoduleid) REFERENCES public.dailyupdatemodule(id);


--
-- Name: assignmentsubmission fkitbfrvnibdicbrqq6n3x020mj; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.assignmentsubmission
    ADD CONSTRAINT fkitbfrvnibdicbrqq6n3x020mj FOREIGN KEY (submissionstatus) REFERENCES public.submissionstatus(id);


--
-- Name: question fkl3ffpkjrufwdo2hkcdrr6osyd; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT fkl3ffpkjrufwdo2hkcdrr6osyd FOREIGN KEY (questiontype) REFERENCES public.questiontype(id);


--
-- Name: answeroptiontemplateitem fkl55rywedt6nbhihxf2uiachmi; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.answeroptiontemplateitem
    ADD CONSTRAINT fkl55rywedt6nbhihxf2uiachmi FOREIGN KEY (answeroptiontemplateid) REFERENCES public.answeroptiontemplate(id);


--
-- Name: batchmentor fklhomsd15r9cd9opods4tnhv3e; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchmentor
    ADD CONSTRAINT fklhomsd15r9cd9opods4tnhv3e FOREIGN KEY (mentorid) REFERENCES public.mentor(id);


--
-- Name: question fklorlp6hxgm9t8w82vivt2ugsd; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT fklorlp6hxgm9t8w82vivt2ugsd FOREIGN KEY (parentquestion) REFERENCES public.question(id);


--
-- Name: batch fklyo26rvg0hs090cwqxgxrw0xn; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch
    ADD CONSTRAINT fklyo26rvg0hs090cwqxgxrw0xn FOREIGN KEY (course_id) REFERENCES public.course(id);


--
-- Name: assignmentsubmission fkmt1k1cefhogfq4lbgskrcim2a; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.assignmentsubmission
    ADD CONSTRAINT fkmt1k1cefhogfq4lbgskrcim2a FOREIGN KEY (submissionstatus) REFERENCES public.submissionstatus(id);


--
-- Name: batchmodule fkmvta5h0rm1ugg4qrcgksjujk9; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchmodule
    ADD CONSTRAINT fkmvta5h0rm1ugg4qrcgksjujk9 FOREIGN KEY (batchid) REFERENCES public.batch(id);


--
-- Name: competencycriterion fkmw6ef1hh138234dqu9u4l8pb5; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.competencycriterion
    ADD CONSTRAINT fkmw6ef1hh138234dqu9u4l8pb5 FOREIGN KEY (competencycategoryid) REFERENCES public.competencycategory(id);


--
-- Name: batchtrainer fkmxcvq9qvxgqgj9agj8b0ckidq; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batchtrainer
    ADD CONSTRAINT fkmxcvq9qvxgqgj9agj8b0ckidq FOREIGN KEY (trainerid) REFERENCES public.trainer(id);


--
-- Name: attendance fkn1w0r7sql76det9u8xq7gmk8; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.attendance
    ADD CONSTRAINT fkn1w0r7sql76det9u8xq7gmk8 FOREIGN KEY (enrollment) REFERENCES public.enrollment(id) ON DELETE CASCADE;


--
-- Name: assignment fkngmetyh1lnw61dmrvq9a94rev; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.assignment
    ADD CONSTRAINT fkngmetyh1lnw61dmrvq9a94rev FOREIGN KEY (module) REFERENCES public.module(id);


--
-- Name: participant fknmdcgydluu8n34wg1e27t9088; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.participant
    ADD CONSTRAINT fknmdcgydluu8n34wg1e27t9088 FOREIGN KEY (person) REFERENCES public.person(id);


--
-- Name: response fknq8p7w73pd0pkqeghv7q4mitw; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.response
    ADD CONSTRAINT fknq8p7w73pd0pkqeghv7q4mitw FOREIGN KEY (survey) REFERENCES public.survey(id);


--
-- Name: session_batch_module fkoibot8lx257gcmafw0khn8yq1; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.session_batch_module
    ADD CONSTRAINT fkoibot8lx257gcmafw0khn8yq1 FOREIGN KEY (batch_module_id) REFERENCES public.batchmodule(id);


--
-- Name: question fkp3g6c2u8it6s682jd87l4ggj4; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT fkp3g6c2u8it6s682jd87l4ggj4 FOREIGN KEY (surveyid) REFERENCES public.survey(id);


--
-- Name: batch fkpfeyix5a6c390bvwib9qeot30; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch
    ADD CONSTRAINT fkpfeyix5a6c390bvwib9qeot30 FOREIGN KEY (course) REFERENCES public.course(id);


--
-- Name: sessions fkqo066mh0u26rbqu4f4uf6qnb6; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.sessions
    ADD CONSTRAINT fkqo066mh0u26rbqu4f4uf6qnb6 FOREIGN KEY (batchmodule) REFERENCES public.batchmodule(id);


--
-- Name: responseanswers fkrkq60shxd0hav73pvq4yod3tm; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.responseanswers
    ADD CONSTRAINT fkrkq60shxd0hav73pvq4yod3tm FOREIGN KEY (response) REFERENCES public.response(id);


--
-- Name: dailyupdatemodule fkrx3mfokwenydme9h2330ka6e4; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.dailyupdatemodule
    ADD CONSTRAINT fkrx3mfokwenydme9h2330ka6e4 FOREIGN KEY (moduleid) REFERENCES public.batchmodule(id);


--
-- Name: assignmentsubmission fks9jgxq4ruyqueous7tvd2kg7b; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.assignmentsubmission
    ADD CONSTRAINT fks9jgxq4ruyqueous7tvd2kg7b FOREIGN KEY (assignment) REFERENCES public.assignment(id);


--
-- Name: session_batch_module fkstk1l9ngftbac0p9igif4uhlf; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.session_batch_module
    ADD CONSTRAINT fkstk1l9ngftbac0p9igif4uhlf FOREIGN KEY (session_id) REFERENCES public.sessions(id);


--
-- Name: session_attendance fksufewts9es6habaptnl06mf7b; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.session_attendance
    ADD CONSTRAINT fksufewts9es6habaptnl06mf7b FOREIGN KEY (sessionid) REFERENCES public.sessions(id);


--
-- Name: dailyupdate fkt67joko711276mggvsft9sfl4; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.dailyupdate
    ADD CONSTRAINT fkt67joko711276mggvsft9sfl4 FOREIGN KEY (batchid) REFERENCES public.batch(id);


--
-- Name: assignmentsubmission fktq147dprf7b2cteoju83itwqc; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.assignmentsubmission
    ADD CONSTRAINT fktq147dprf7b2cteoju83itwqc FOREIGN KEY (assignment) REFERENCES public.assignment(id);


--
-- Name: batch_module_enrollment_assignment fktqya61geu8f485hc7gm19lh4q; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.batch_module_enrollment_assignment
    ADD CONSTRAINT fktqya61geu8f485hc7gm19lh4q FOREIGN KEY (assignment_id) REFERENCES public.assignment(id);


--
-- Name: dailyupdatemoduleattendance fktrbu4p4vav7y0jvmtajyg226n; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public.dailyupdatemoduleattendance
    ADD CONSTRAINT fktrbu4p4vav7y0jvmtajyg226n FOREIGN KEY (enrollmentid) REFERENCES public.enrollment(id) ON DELETE CASCADE;


--
-- Name: user user_personId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: lmsnew
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT "user_personId_fkey" FOREIGN KEY ("personId") REFERENCES public.person(id);


--
-- Name: DEFAULT PRIVILEGES FOR SEQUENCES; Type: DEFAULT ACL; Schema: public; Owner: lmsnew
--

ALTER DEFAULT PRIVILEGES FOR ROLE lmsnew IN SCHEMA public GRANT ALL ON SEQUENCES TO lmsnew;


--
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: public; Owner: lmsnew
--

ALTER DEFAULT PRIVILEGES FOR ROLE lmsnew IN SCHEMA public GRANT ALL ON TABLES TO lmsnew;


--
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: public; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public GRANT ALL ON TABLES TO lmsnew;


--
-- PostgreSQL database dump complete
--

\unrestrict btmB2GVUIipoIFcccPiYfh8Pfrcu3q5TWx2ZDlNMUNefGkIS9ji9KH6eOqQIaIl

