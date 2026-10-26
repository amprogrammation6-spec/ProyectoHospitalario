-- ============================================================================
-- Hospital San Gabriel — script de la base de datos
--
-- Analogía: MySQL es la BODEGA permanente. Este archivo CONSTRUYE
-- el edificio de esa bodega: un almacén (la base de datos) y cuatro
-- cajones (las tablas). Java no crea las tablas; las usa.
--
-- Cómo ejecutarlo: ábrelo en MySQL Workbench y dale al rayo (⚡).
-- ============================================================================

-- Crea el almacén si todavía no existe.
-- utf8mb4 = permite tildes y ñ (Gómez, Muñoz, etc.).
CREATE DATABASE IF NOT EXISTS hospital_san_gabriel
    CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- "Entra" a ese almacén: lo que sigue se crea DENTRO de él.
USE hospital_san_gabriel;

-- --------------------------------------------------------------------------
-- Cajón PACIENTES
-- Analogía: cada FILA es una ficha. Cada COLUMNA es una casilla del formulario.
-- PRIMARY KEY = el número único de la ficha (no puede repetirse).
-- UNIQUE en documento = no dos pacientes con la misma cédula.
-- VARCHAR(100) = texto de hasta 100 letras. INT = número entero.
-- --------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS pacientes (
    id        INT          NOT NULL PRIMARY KEY,
    nombre    VARCHAR(100) NOT NULL,
    edad      INT          NOT NULL,
    documento VARCHAR(20)  NOT NULL UNIQUE
);

-- --------------------------------------------------------------------------
-- Cajón DOCTORES
-- Igual que pacientes, más la casilla especialidad.
-- DEFAULT 'General' = si no dicen nada, asumimos medicina general.
-- --------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS doctores (
    id           INT          NOT NULL PRIMARY KEY,
    nombre       VARCHAR(100) NOT NULL,
    edad         INT          NOT NULL,
    documento    VARCHAR(20)  NOT NULL UNIQUE,
    especialidad VARCHAR(50)  NOT NULL DEFAULT 'General'
);

-- --------------------------------------------------------------------------
-- Cajón ENFERMERAS
-- Misma ficha básica: id, nombre, edad, documento.
-- --------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS enfermeras (
    id        INT          NOT NULL PRIMARY KEY,
    nombre    VARCHAR(100) NOT NULL,
    edad      INT          NOT NULL,
    documento VARCHAR(20)  NOT NULL UNIQUE
);

-- --------------------------------------------------------------------------
-- Cajón CITAS (la agenda)
-- Analogía: no copiamos el nombre del paciente. Guardamos su NÚMERO (id).
-- Es como anotar "historia 5 con médico 3" en vez de reescribir toda la ficha.
--
-- FOREIGN KEY = "este número DEBE existir en el otro cajón".
-- No puedes agendar una cita con un paciente que no está registrado.
-- estado: PROGRAMADA (sigue vigente) o CANCELADA (tachada, no borrada).
-- --------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS citas (
    id          INT         NOT NULL PRIMARY KEY,
    paciente_id INT         NOT NULL,
    doctor_id   INT         NOT NULL,
    fecha       VARCHAR(10) NOT NULL,
    hora        VARCHAR(5)  NOT NULL,
    estado      VARCHAR(20) NOT NULL DEFAULT 'PROGRAMADA',
    FOREIGN KEY (paciente_id) REFERENCES pacientes(id),
    FOREIGN KEY (doctor_id) REFERENCES doctores(id)
)