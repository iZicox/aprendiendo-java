# AGENTS.md

## Repository Overview
Java learning repository with multiple independent projects in `workspace/`. Mix of Eclipse projects and Maven projects.

## Build & Run
- **Eclipse projects** (most of `workspace/`): Import into Eclipse IDE; compiled output in `bin/`
- **Maven projects** (have `pom.xml`): `mvn compile`, `mvn test`
- **Java versions**: Maven projects target Java 17; Eclipse project `programacion.funcional.archivos` uses Java 21

## Structure
- `workspace/` - Eclipse-style Java projects (`.classpath`, `.project`, `src/`, `bin/`)
- Root-level folders (`tarea*`, `examen*`, `ejercicio*`) - standalone exercise/jdbc projects
- `base de datos/` - Database exercises with roadmap

## Line Endings
`.gitattributes` enforces LF for `*.java`, `*.xml`, `*.properties`, `*.md`, `.classpath`, `.project`

## Ignored by Git
`workspace/.metadata/`, `workspace/*/.settings/`, `workspace/*/bin/`, `workspace/*/target/`

## Notes
- No AGENTS.md existed before; this repository has no testing framework configured in checked projects
- Each workspace project is independent; no parent pom or monorepo build
