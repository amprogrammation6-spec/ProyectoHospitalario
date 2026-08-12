# Narrativa del Proyecto Integrador
## Sistema Hospitalario Empresarial — Hospital San Gabriel
### Lenguajes de Programación II

---

> *"No construimos un hospital en un día. Tampoco construimos un sistema en una sola clase."*

---

## Tabla de contenidos

1. [La historia: bienvenido al equipo](#1-la-historia-bienvenido-al-equipo)
2. [¿Qué vamos a desarrollar?](#2-qué-vamos-a-desarrollar)
3. [¿Cómo funciona el curso?](#3-cómo-funciona-el-curso)
4. [La arquitectura del proyecto](#4-la-arquitectura-del-proyecto)
5. [El camino completo: los 10 sprints](#5-el-camino-completo-los-10-sprints)
6. [Cómo evoluciona el proyecto (visión general)](#6-cómo-evoluciona-el-proyecto-visión-general)
7. [Qué se espera de ti en cada sprint](#7-qué-se-espera-de-ti-en-cada-sprint)
8. [Reglas del proyecto](#8-reglas-del-proyecto)
9. [El sistema final: cómo se verá al terminar](#9-el-sistema-final-cómo-se-verá-al-terminar)
10. [Documentos del curso](#10-documentos-del-curso)
11. [Preguntas frecuentes](#11-preguntas-frecuentes)

---

## 1. La historia: bienvenido al equipo

Imagina esta escena:

El **Hospital San Gabriel** acaba de inaugurar sus puertas en la ciudad. Tiene médicos, enfermeras, recepcionistas y pacientes llegando cada día. Pero hay un problema: **no tiene software**. Todo se anota en papel. Las citas se pierden. Los datos de los pacientes no se guardan. El director del hospital está preocupado.

Un día, a la empresa de desarrollo donde trabajas llega una llamada:

> *"Necesitamos un sistema para gestionar nuestro hospital. ¿Pueden ayudarnos?"*

Tu equipo acepta el proyecto. Y tú, como desarrollador junior recién incorporado, formas parte del equipo encargado de construirlo.

**Pero hay una condición importante:** el director no quiere esperar seis meses para ver resultados. Quiere ver avances cada pocas semanas. Quiere un sistema que **vaya creciendo**, que empiece simple y se vuelva más completo con el tiempo.

Eso es exactamente lo que haremos en este curso.

---

## 2. ¿Qué vamos a desarrollar?

Al final del semestre habremos construido un **Sistema de Gestión Hospitalaria** de escritorio, escrito en **Java puro**, que permitirá:

| Funcionalidad | Descripción |
|---------------|-------------|
| Registrar pacientes | Guardar datos de las personas que llegan al hospital |
| Registrar médicos | Incluir doctores con diferentes especialidades |
| Registrar enfermeras | Gestionar el personal de enfermería |
| Crear citas | Agendar consultas entre pacientes y doctores |
| Cancelar citas | Eliminar citas que ya no se necesitan |
| Consultar agenda | Ver qué citas hay programadas |
| Registrar atención médica | Documentar cuando un doctor atiende a un paciente |
| Generar factura | Calcular el costo de una atención |
| Guardar toda la información | Los datos persisten aunque se cierre el programa |

Todo esto **sin base de datos**. Los datos se guardarán en **archivos de texto** o mediante **serialización de objetos**.

---

## 3. ¿Cómo funciona el curso?

Este curso no es un tutorial donde copias código y ya. Es una **simulación de trabajo real** en una empresa de software.

### La metáfora del Sprint

En las empresas de tecnología, el trabajo se organiza en **sprints** (iteraciones cortas). Cada sprint tiene:

1. **Un objetivo claro** — qué vamos a lograr en este periodo.
2. **Un entregable** — código funcional que se puede probar.
3. **Conceptos nuevos** — algo de Programación Orientada a Objetos que aprenderás.

En nuestro curso, **cada clase del semestre equivale a un sprint**. Cada vez que entras a clase, el proyecto crece un poco más.

### Lo que NO haremos

- No construiremos todo el sistema el primer día.
- No copiaremos un proyecto terminado.
- No usaremos herramientas que oculten cómo funciona Java (sin Spring, sin frameworks).
- No usaremos bases de datos (para que entiendas primero la lógica y el manejo de archivos).

### Lo que SÍ haremos

- Escribir código **línea por línea**, entendiendo cada parte.
- Ir agregando funcionalidades **poco a poco**, como en un proyecto real.
- Comentar **todo el código** para que sirva de material de estudio.
- Aprender POO avanzada con un proyecto que tenga sentido y contexto.

### Tu rol como estudiante

Eres un **desarrollador junior** en el equipo del Hospital San Gabriel. Cada sprint recibes una nueva asignación del "líder técnico" (el profesor). Tu trabajo es implementarla, probarla y entenderla.

---

## 4. La arquitectura del proyecto

Desde el primer día, el proyecto tiene una **estructura organizada en paquetes** (carpetas). Esto no es decoración: es cómo se organizan los proyectos profesionales en Java.

```
proyectoHospital/
│
├── src/                          ← Todo el código fuente vive aquí
│   │
│   ├── modelo/                   ← LAS ENTIDADES (¿qué cosas existen?)
│   │   ├── Paciente.java
│   │   ├── Doctor.java
│   │   ├── Persona.java          (Sprint 3)
│   │   ├── MedicoGeneral.java    (Sprint 4)
│   │   └── ...
│   │
│   ├── servicio/                 ← LA LÓGICA DE NEGOCIO (¿qué reglas tiene el hospital?)
│   │   ├── PacienteService.java  (Sprint 7)
│   │   ├── CitaService.java      (Sprint 10)
│   │   └── ...
│   │
│   ├── repositorio/              ← EL ALMACENAMIENTO (¿dónde se guardan los datos?)
│   │   ├── PacienteRepository.java (Sprint 8)
│   │   └── ...
│   │
│   ├── util/                     ← HERRAMIENTAS AUXILIARES
│   │   ├── PacienteNoEncontradoException.java (Sprint 9)
│   │   └── ...
│   │
│   ├── vista/                    ← LO QUE VE EL USUARIO (menús, pantallas)
│   │   ├── MenuDoctores.java     (Sprint 5)
│   │   ├── MenuPrincipal.java    (Sprint 10)
│   │   └── ...
│   │
│   └── principal/                ← EL PUNTO DE INICIO
│       └── HospitalApp.java      ← Aquí está el método main
│
├── bin/                          ← Archivos compilados (generados automáticamente)
├── datos/                        ← Archivos de persistencia (Sprint 8 en adelante)
├── README.md                     ← Información general del proyecto
├── narrativa.md                  ← Este documento
└── sprint1.md, sprint2.md...     ← Tutoriales paso a paso de cada sprint
```

### ¿Para qué sirve cada paquete?

Piensa en el hospital como un edificio con departamentos:

| Paquete | Analogía | Responsabilidad |
|---------|----------|-----------------|
| **modelo** | Las fichas de cada persona o cosa | Define **qué datos** tiene un paciente, un doctor, una cita. Son las "entidades" del negocio. |
| **servicio** | Los coordinadores del hospital | Contiene las **reglas**: cómo buscar un paciente, cómo crear una cita, cómo calcular una factura. |
| **repositorio** | El archivo y la bodega | Se encarga de **guardar y leer** datos en archivos del disco. |
| **util** | Las herramientas del mantenimiento | Excepciones personalizadas, validadores y utilidades que usa todo el proyecto. |
| **vista** | La recepción y los mostradores | Todo lo que el **usuario ve e interactúa**: menús, mensajes, formularios por consola. |
| **principal** | La puerta de entrada del edificio | El método `main` que **inicia** el programa. |

### ¿Por qué separar en paquetes?

Porque en un proyecto real **nadie pone todo en un solo archivo**. Separar responsabilidades permite:

- Encontrar el código más rápido.
- Que varios desarrolladores trabajen sin pisarse.
- Cambiar una parte (por ejemplo, cómo se guardan los datos) sin romper otra (por ejemplo, los menús).
- Aprender el principio de **modularidad**, uno de los pilares del curso.

> En los primeros sprints solo usarás `modelo` y `principal`. Los demás paquetes se irán llenando conforme avance el semestre. **Eso es intencional.**

---

## 5. El camino completo: los 10 sprints

A continuación, la historia completa del semestre. Cada sprint es un capítulo del desarrollo del Hospital San Gabriel.

---

### Sprint 1 — Introducción: las primeras fichas del hospital
**Tema:** Clase, objeto, atributo, método, constructor.

**La historia:**  
Llegas el primer día al proyecto. El director del hospital te dice: *"Antes de hacer algo complicado, necesito que registres quiénes trabajan aquí y quiénes son nuestros pacientes."* Tu primera tarea es crear las fichas básicas.

**Qué desarrollarás:**
- Clase `Paciente`
- Clase `Doctor`
- Clase `Enfermera`
- Clase `Recepcionista`
- Clase `HospitalApp` con el método `main`

**Cada persona tendrá:**
- `id`, `nombre`, `edad`, `documento`
- Método `mostrarInformacion()`

**Conceptos POO:**
| Concepto | Qué aprenderás |
|----------|----------------|
| Clase | La plantilla o molde |
| Objeto | Una instancia concreta creada con `new` |
| Atributo | Las variables que guardan datos |
| Método | Las acciones que puede ejecutar un objeto |
| Constructor | Cómo se inicializa un objeto al crearlo |

**Entregable:** Un programa que crea 4 personas y muestra su información en consola.

**Tutorial:** `sprint1.md`

---

### Sprint 2 — Encapsulamiento: proteger los datos
**Tema:** Atributos privados, getters, setters y validaciones.

**La historia:**  
Un compañero modificó accidentalmente la edad de un paciente a un número negativo. El director está molesto. *"Los datos deben estar protegidos. Nadie debería poder poner una edad de -5 años."* Te piden arreglar esto.

**Qué desarrollarás:**
- Cambiar atributos de `public` a `private` en todas las clases del modelo.
- Agregar **getters** (métodos para leer un atributo).
- Agregar **setters** (métodos para modificar un atributo con reglas).

**Validaciones que implementarás:**
- No permitir edades negativas.
- No permitir documentos vacíos.
- No permitir nombres vacíos.

**Conceptos POO:**
| Concepto | Qué aprenderás |
|----------|----------------|
| Encapsulamiento | Ocultar los datos y controlar el acceso |
| Getter | Método para obtener el valor de un atributo privado |
| Setter | Método para cambiar un atributo con validación |
| `private` | Nadie fuera de la clase puede acceder directamente |

**Entregable:** Las mismas clases del Sprint 1, pero con datos protegidos y validados.

---

### Sprint 3 — Abstracción: unificar lo que es común
**Tema:** Clases abstractas.

**La historia:**  
Tu líder técnico revisa el código y dice: *"Paciente, Doctor, Enfermera y Recepcionista tienen los mismos datos. Estás repitiendo código. En programación eso es una señal de alerta."* Te pide crear una clase base que unifique lo común.

**Qué desarrollarás:**
- Clase abstracta `Persona` con los atributos y métodos compartidos.
- `Paciente`, `Doctor`, `Enfermera` y `Recepcionista` **heredan** de `Persona`.
- Refactorizar el código existente para eliminar duplicación.

**Conceptos POO:**
| Concepto | Qué aprenderás |
|----------|----------------|
| Abstracción | Extraer lo común y ocultar la complejidad |
| Clase abstracta | Una clase que no se instancia directamente, sirve de base |
| `extends` | Cómo una clase hereda de otra |
| Reutilización de código | Escribir una vez, usar muchas veces |

**Entregable:** Un modelo más limpio donde `Persona` centraliza lo compartido.

---

### Sprint 4 — Herencia: los doctores tienen especialidades
**Tema:** Herencia en profundidad.

**La historia:**  
El hospital contrata doctores de distintas especialidades. Un cirujano no atiende igual que un pediatra. El director quiere que el sistema distinga entre tipos de doctores, pero sin perder que todos son doctores.

**Qué desarrollarás:**
- Clase `Especialista` (hereda de `Doctor`)
- Clase `MedicoGeneral` (hereda de `Doctor`)
- Clase `Cirujano` (hereda de `Doctor`)
- Clase `Pediatra` (hereda de `Doctor`)
- Clase `Cardiologo` (hereda de `Doctor`)
- Cada especialidad implementa su propio método `atenderPaciente()` con un mensaje diferente.

**Conceptos POO:**
| Concepto | Qué aprenderás |
|----------|----------------|
| Herencia | Una clase obtiene atributos y métodos de otra |
| Jerarquía de clases | Persona → Doctor → Cirujano |
| Sobrescritura (`@Override`) | Redefinir un método en la clase hija |
| Especialización | Cada subclase agrega comportamiento propio |

**Entregable:** Un árbol de herencia de doctores donde cada especialidad atiende de forma distinta.

---

### Sprint 5 — Polimorfismo: un menú para todos los doctores
**Tema:** Polimorfismo.

**La historia:**  
La recepcionista necesita un menú donde pueda ver a todos los doctores y simular que atienden a un paciente. No le importa si es cirujano o pediatra: solo quiere seleccionar uno y que atienda. *"No me importa el tipo, solo quiero que funcione."*

**Qué desarrollarás:**
- Una lista (`ArrayList`) de doctores de diferentes tipos.
- Un **menú por consola** en el paquete `vista`.
- Recorrer la lista y llamar a `atenderPaciente()` en cada doctor.
- Cada doctor responde diferente gracias al polimorfismo.

**Conceptos POO:**
| Concepto | Qué aprenderás |
|----------|----------------|
| Polimorfismo | Un mismo método se comporta distinto según el objeto |
| Referencia de tipo padre | `Doctor d = new Cirujano()` |
| Recorrido de colecciones | `for` sobre una lista de objetos |
| Separación vista/modelo | El menú vive en `vista`, las clases en `modelo` |

**Entregable:** Un menú interactivo que demuestra polimorfismo con doctores.

---

### Sprint 6 — Interfaces: contratos del hospital
**Tema:** Interfaces.

**La historia:**  
El área de facturación tiene reglas claras: *"Todo lo que se atiende debe poder facturarse. Y todo lo que se atiende debe tener un método de atención estándar."* Pero no todo se factura igual. Necesitas un mecanismo que obligue a las clases a cumplir ciertos contratos sin importar cómo lo hagan.

**Qué desarrollarás:**
- Interfaz `Atendible` con el método `atender()`.
- Interfaz `Facturable` con el método `calcularCosto()`.
- Algunas clases implementarán solo `Atendible`.
- Otras implementarán ambas interfaces.

**Conceptos POO:**
| Concepto | Qué aprenderás |
|----------|----------------|
| Interfaz | Un contrato: "quien me implemente DEBE tener estos métodos" |
| `implements` | Cómo una clase cumple un contrato |
| Múltiples interfaces | Una clase puede implementar varias interfaces |
| Desacoplamiento | Programar contra interfaces, no contra clases concretas |

**Entregable:** Clases del hospital que cumplen contratos de atención y facturación.

---

### Sprint 7 — Colecciones: gestionar muchos pacientes
**Tema:** `ArrayList` y operaciones CRUD básicas.

**La historia:**  
El hospital ya tiene decenas de pacientes. Ya no basta con crear uno o dos en el `main`. Necesitas poder **agregar, buscar, editar, eliminar y listar** pacientes. Es hora de usar colecciones y mover la lógica al paquete `servicio`.

**Qué desarrollarás:**
- `ArrayList<Paciente>` para almacenar pacientes en memoria.
- Clase `PacienteService` en el paquete `servicio`.
- Operaciones:
  - **C**rear (agregar paciente)
  - **R**ead (buscar y listar pacientes)
  - **U**pdate (editar paciente)
  - **D**elete (eliminar paciente)

**Conceptos POO / Java:**
| Concepto | Qué aprenderás |
|----------|----------------|
| Colecciones | `ArrayList` para listas dinámicas |
| Generics | `ArrayList<Paciente>` — lista tipada |
| Servicios | Separar lógica de negocio del modelo |
| CRUD | Las 4 operaciones básicas de cualquier sistema |

**Entregable:** Un servicio funcional para gestionar pacientes en memoria.

---

### Sprint 8 — Persistencia: los datos sobreviven al cierre
**Tema:** Manejo de archivos.

**La historia:**  
Apagas el programa un viernes y el lunes todos los pacientes desaparecieron. El director entra en pánico. *"¿Dónde quedaron los datos?"* Le explicas que solo estaban en memoria. Te ordenan: *"Los datos deben guardarse en archivos. Si se cierra el programa, los datos deben seguir ahí."*

**Qué desarrollarás:**
- Paquete `repositorio` con clases de acceso a archivos.
- Guardar pacientes en archivos de texto o por serialización.
- Guardar doctores en archivos.
- Leer los archivos al iniciar el programa.
- Actualizar la información en disco cuando cambie.

**Conceptos POO / Java:**
| Concepto | Qué aprenderás |
|----------|----------------|
| Persistencia | Los datos sobreviven al cierre del programa |
| Archivos de texto | Leer y escribir con `FileWriter`, `BufferedReader`, etc. |
| Serialización | Convertir objetos Java a bytes y viceversa |
| Repositorio | Patrón que separa el almacenamiento de la lógica |

**Entregable:** Los datos del hospital se guardan y recuperan desde archivos.

---

### Sprint 9 — Excepciones: manejar los errores con elegancia
**Tema:** Excepciones personalizadas.

**La historia:**  
Un recepcionista busca al paciente "999999" y el programa se cae con un error feo que nadie entiende. El director dice: *"Los errores deben explicarse en español claro. Si un paciente no existe, que el sistema lo diga claramente."*

**Qué desarrollarás:**
- Excepciones propias en el paquete `util`:
  - `PacienteNoEncontradoException`
  - `DoctorNoDisponibleException`
  - `EdadInvalidaException`
- Usar `try-catch` para capturar errores sin que el programa se cierre.
- Mensajes de error claros para el usuario.

**Conceptos POO / Java:**
| Concepto | Qué aprenderás |
|----------|----------------|
| Excepción | Una señal de que algo salió mal |
| Excepción personalizada | Crear tus propios tipos de error |
| `try-catch-finally` | Capturar y manejar errores |
| `throw` | Lanzar una excepción cuando una regla se viola |

**Entregable:** Un sistema que maneja errores de forma profesional y comprensible.

---

### Sprint 10 — Proyecto final: el sistema completo
**Tema:** Integración de todo lo aprendido.

**La historia:**  
Es la presentación final ante el director del Hospital San Gabriel. Debes demostrar un sistema funcional que integre todo lo construido durante el semestre. Es tu momento de brillar.

**Qué desarrollarás:**
- Menú principal completo en `vista`.
- Integración de modelo, servicio, repositorio, util y vista.
- Funcionalidades finales:
  - Registrar pacientes
  - Registrar médicos
  - Registrar enfermeras
  - Crear citas
  - Cancelar citas
  - Consultar agenda
  - Registrar atención médica
  - Generar factura
  - Guardar toda la información

**Conceptos POO:**
| Concepto | Qué aprenderás |
|----------|----------------|
| Integración | Unir todos los módulos en un sistema coherente |
| Modularidad | Cada paquete cumple su rol |
| Proyecto completo | De la idea al software funcional |

**Entregable:** El Sistema Hospitalario Empresarial completo y funcional.

---

## 6. Cómo evoluciona el proyecto (visión general)

Este diagrama muestra cómo crece el proyecto sprint a sprint:

```
Sprint 1   →  Clases básicas (Paciente, Doctor...)
              └── modelo/ + principal/

Sprint 2   →  + Encapsulamiento (private, getters, setters)

Sprint 3   →  + Clase abstracta Persona

Sprint 4   →  + Especialidades médicas (herencia)

Sprint 5   →  + Menú de doctores (polimorfismo)
              └── vista/

Sprint 6   →  + Interfaces Atendible y Facturable

Sprint 7   →  + Gestión de pacientes con ArrayList
              └── servicio/

Sprint 8   →  + Guardar datos en archivos
              └── repositorio/ + datos/

Sprint 9   →  + Excepciones personalizadas
              └── util/

Sprint 10  →  ★ SISTEMA COMPLETO ★
              └── Todo integrado
```

### Evolución de los paquetes

| Sprint | modelo | servicio | repositorio | util | vista | principal |
|--------|--------|----------|-------------|------|-------|-----------|
| 1 | ✅ | — | — | — | — | ✅ |
| 2 | ✅ | — | — | — | — | ✅ |
| 3 | ✅ | — | — | — | — | ✅ |
| 4 | ✅ | — | — | — | — | ✅ |
| 5 | ✅ | — | — | — | ✅ | ✅ |
| 6 | ✅ | — | — | — | ✅ | ✅ |
| 7 | ✅ | ✅ | — | — | ✅ | ✅ |
| 8 | ✅ | ✅ | ✅ | — | ✅ | ✅ |
| 9 | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ |
| 10 | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ |

---

## 7. Qué se espera de ti en cada sprint

### En clase
- Llegar con el entregable del sprint anterior funcionando.
- Seguir el tutorial del sprint (si está disponible) o las instrucciones del profesor.
- Escribir el código tú mismo. No copies sin entender.
- Hacer preguntas cuando algo no quede claro.

### En el código
- **Comentar todo.** Cada clase debe explicar qué enseña. Cada método debe tener comentarios.
- **Respetar la arquitectura.** Las clases van en el paquete correcto.
- **No adelantarse.** No implementes funcionalidades de sprints futuros.
- **Probar siempre.** Compila y ejecuta después de cada cambio.

### Al entregar cada sprint
Debes poder demostrar que:
1. El programa **compila** sin errores.
2. El programa **ejecuta** y hace lo que pide el sprint.
3. Puedes **explicar con tus palabras** los conceptos nuevos del sprint.
4. El código está **comentado** y organizado en los paquetes correctos.

---

## 8. Reglas del proyecto

Estas reglas aplican durante **todo el semestre**:

| Regla | Detalle |
|-------|---------|
| Solo Java puro | Sin Spring, sin Hibernate, sin frameworks |
| Sin base de datos | Toda la persistencia es con archivos |
| Solo POO | Programación Orientada a Objetos |
| Código comentado | Cada clase y método explicado |
| Crecimiento incremental | Un sprint a la vez, nunca todo de una vez |
| Arquitectura por paquetes | modelo, servicio, repositorio, util, vista, principal |
| Simulación empresarial | Trátalo como un proyecto de trabajo real |

---

## 9. El sistema final: cómo se verá al terminar

Al final del Sprint 10, un usuario podrá interactuar con un menú como este:

```
========================================================
   HOSPITAL SAN GABRIEL - Sistema de Gestion
========================================================
   1. Registrar paciente
   2. Registrar medico
   3. Registrar enfermera
   4. Crear cita
   5. Cancelar cita
   6. Consultar agenda
   7. Registrar atencion medica
   8. Generar factura
   9. Listar pacientes
   0. Salir
========================================================
   Opcion: _
```

Detrás de ese menú habrá:

```
┌─────────────┐     ┌─────────────┐     ┌──────────────┐
│    VISTA    │ ──► │   SERVICIO  │ ──► │ REPOSITORIO  │
│  (menús)    │     │  (reglas)   │     │  (archivos)  │
└─────────────┘     └──────┬──────┘     └──────────────┘
                           │
                           ▼
                    ┌─────────────┐
                    │   MODELO    │
                    │ (entidades) │
                    └─────────────┘
                           ▲
                           │
                    ┌─────────────┐
                    │    UTIL     │
                    │(excepciones)│
                    └─────────────┘
```

Cada capa tiene una responsabilidad. Eso es **arquitectura en capas**, y es cómo se construye software profesional.

---

## 10. Documentos del curso

A lo largo del semestre tendrás estos materiales de apoyo:

| Documento | Para qué sirve |
|-----------|----------------|
| `narrativa.md` | Este archivo. La visión completa del curso. |
| `README.md` | Información técnica del proyecto (cómo compilar, estructura). |
| `sprint1.md` | Tutorial paso a paso del Sprint 1. |
| `sprint2.md` | Tutorial paso a paso del Sprint 2. (se publicará cuando corresponda) |
| ... | Un tutorial por cada sprint. |
| Código fuente | Comentado línea por línea en cada clase. |

**Recomendación:** Lee `narrativa.md` al inicio del curso para entender el panorama completo. Luego, en cada sprint, sigue el tutorial correspondiente (`sprintN.md`).

---

## 11. Preguntas frecuentes

### ¿Puedo adelantarme y hacer sprints futuros?
No. Cada sprint construye sobre el anterior. Si te adelantas, probablemente no entenderás los conceptos y tendrás problemas después.

### ¿Puedo usar una base de datos si sé cómo?
No. El objetivo del curso es aprender POO, colecciones, archivos y excepciones en Java puro. La base de datos es un tema para otro curso.

### ¿Puedo usar librerías externas?
No. Solo Java estándar (JDK). Sin Maven, sin Gradle, sin Spring.

### ¿Qué pasa si me atraso en un sprint?
Habla con tu profesor. Lo importante es que entiendas cada concepto antes de pasar al siguiente. Este proyecto está diseñado para crecer paso a paso.

### ¿El código debe ser idéntico al del profesor?
No necesariamente. Lo importante es que cumpla los objetivos del sprint, compile, funcione y esté comentado. Puedes usar nombres de pacientes o doctores diferentes en tus ejemplos.

### ¿Por qué no hacemos una interfaz gráfica (ventanas)?
Para concentrarnos en POO sin la complejidad adicional de librerías gráficas. La consola es suficiente para aprender todos los conceptos del curso.

### ¿Qué es un "Sprint" exactamente?
Es un periodo corto de trabajo con un objetivo concreto. En empresas de software suelen durar 1-2 semanas. En nuestro curso, cada sprint corresponde aproximadamente a una unidad temática del semestre.

### ¿Voy a poder usar este proyecto en mi portafolio?
¡Sí! Al terminar tendrás un proyecto completo que demuestra que sabes aplicar POO, manejar archivos, diseñar con capas y construir software de forma incremental. Eso tiene mucho valor para un desarrollador junior.

---

## Cierre

Durante este semestre no solo aprenderás a programar en Java. Aprenderás a **pensar como desarrollador**: organizar código, separar responsabilidades, crecer un proyecto poco a poco y resolver problemas reales con software.

El Hospital San Gabriel confía en ti. Cada sprint es un paso más hacia un sistema del que puedas sentirte orgulloso.

**¡Bienvenido al equipo!**

---

*Lenguajes de Programación II — Proyecto Integrador*  
*Sistema Hospitalario Empresarial — Hospital San Gabriel*
