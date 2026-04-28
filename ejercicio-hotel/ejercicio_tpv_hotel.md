# Ejercicio: Sistema de Gestión de Hotel

## Contexto

El objetivo de esta práctica es implementar un sistema de gestión hotelera utilizando JDBC. La aplicación permitirá gestionar el inventario de habitaciones, registrar clientes, realizar reservas y gestionar el check-in/check-out de huéspedes, asegurando la integridad referencial mediante el uso de claves foráneas y transacciones.

## Base de Datos

```sql
CREATE TABLE HABITACION (
    ID NUMBER(9) GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    NUMERO VARCHAR2(10 CHAR) NOT NULL,
    PLANTA NUMBER(2) NOT NULL,
    TIPO VARCHAR2(20 CHAR) NOT NULL CHECK (TIPO IN ('INDIVIDUAL', 'DOBLE', 'SUITE')),
    PRECIO_NOCHE NUMBER(6,2) NOT NULL,
    ESTADO VARCHAR2(1) NOT NULL CHECK (ESTADO IN ('D', 'O'))
);

CREATE TABLE CLIENTE (
    ID NUMBER(9) GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    DNI VARCHAR2(9 CHAR) NOT NULL UNIQUE,
    NOMBRE VARCHAR2(100 CHAR) NOT NULL,
    TELEFONO VARCHAR2(15 CHAR),
    EMAIL VARCHAR2(100 CHAR)
);

CREATE TABLE RESERVA (
    ID NUMBER(9) GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    FECHA_ENTRADA DATE NOT NULL,
    FECHA_SALIDA DATE NOT NULL,
    HABITACION_ID NUMBER(9),
    CLIENTE_ID NUMBER(9),
    FOREIGN KEY(HABITACION_ID) REFERENCES HABITACION(ID),
    FOREIGN KEY(CLIENTE_ID) REFERENCES CLIENTE(ID) ON DELETE CASCADE
);

CREATE TABLE CHECKIN (
    ID NUMBER(9) GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    FECHA_ENTRADA TIMESTAMP NOT NULL,
    FECHA_SALIDA TIMESTAMP NOT NULL,
    REALIZADO VARCHAR2(1) NOT NULL CHECK (REALIZADO IN ('S', 'N')),
    RESERVA_ID NUMBER(9) UNIQUE,
    FOREIGN KEY(RESERVA_ID) REFERENCES RESERVA(ID) ON DELETE CASCADE
);
```

## Estructura del Menú

1. **Mantenimiento de habitaciones (CRUD)**
   - Alta de nuevas habitaciones
   - Modificar datos de habitaciones
   - Eliminar habitaciones (solo si están disponibles)
   - Listar todas las habitaciones

2. **Gestión de clientes**
   - Alta de nuevos clientes
   - Modificar datos de clientes
   - Eliminar clientes (solo si no tienen reservas activas)
   - Listar todos los clientes

3. **Gestión de reservas**
   - 3.1. Nueva reserva
   - 3.2. Consultar reserva
   - 3.3. Cancelar reserva (Solo si no está realizada)
   - 3.4. Volver al menú anterior

4. **Gestión de check-in/check-out**
   - 4.1. Realizar check-in (desde una reserva)
   - 4.2. Realizar check-out (finalizar estancia)
   - 4.3. Consultar estancia activa
   - 4.4. Volver al menú anterior

5. **Estadísticas**
   - 5.1. Habitaciones ocupadas/libres
   - 5.2. Histórico de estancias
   - 5.3. Volver al menú anterior

0. **Salir**

## Requisitos y Lógica de Negocio

### A. Gestión de Reservas (Memoria y Persistencia)

Para las reservas, se debe trabajar con un objeto Reserva que contenga los datos de habitación, cliente y fechas.

- **Nueva reserva**: Se solicita ID de cliente, ID de habitación y fechas. Se valida que la habitación esté disponible en el rango de fechas.
- **Transacción**: Al crear una reserva, el guardado debe ejecutarse bajo una transacción con commit/rollback.

### B. Gestión de Check-in

- Se muestra un listado de reservas pendientes de check-in (REALIZADO = 'N')
- Al realizar check-in, se crea un registro en CHECKIN y se actualiza el estado de la habitación a 'O' (ocupada)
- Ambas operaciones deben ejecutarse en una única transacción

### C. Gestión de Check-out

- Se busca la estancia activa del cliente
- Al realizar check-out, se marca REALIZADO = 'S' y se actualiza la habitación a 'D' (disponible)
- Operación en transacción

### D. Restricciones de Borrado

- **Habitaciones**: No se debe permitir borrar una habitación si está ocupada o tiene reservas activas
  - *Pista*: Intenta borrar y captura la excepción de integridad de Oracle
- **Clientes**: No se debe permitir borrar un cliente si tiene reservas no finalizadas
- **Reservas**: Gracias al ON DELETE CASCADE, al eliminar una reserva se borrarán automáticamente sus check-in relacionados

## Ayudas Técnicas

### Manejo de Fechas

```java
// Para guardar DATE
pstmt.setDate(n, java.sql.Date.valueOf(localDate));

// Para recuperar DATE
LocalDate fecha = rs.getDate("FECHA_ENTRADA").toLocalDate();

// Para guardar TIMESTAMP
pstmt.setTimestamp(n, java.sql.Timestamp.valueOf(localDateTime));

// Para recuperar TIMESTAMP
LocalDateTime fecha = rs.getTimestamp("FECHA_ENTRADA").toLocalDateTime();
```

### Gestión de Transacciones

```java
try {
    con.setAutoCommit(false);
    // 1. Guardar Reserva y obtener ID
    // 2. Guardar CheckIn
    // 3. Actualizar estado de habitación
    con.commit();
} catch (SQLException e) {
    con.rollback();
    System.out.println("Error en la operación. Operación anulada.");
} finally {
    con.setAutoCommit(true);
}
```

## Criterios de Evaluación

| Criterio | Descripción |
|----------|-------------|
| **Modularidad** | Una clase DAO independiente por cada tabla que implemente su correspondiente interfaz |
| **Integridad** | El programa no debe permitir datos inconsistentes si falla una operación en la transacción |
| **Robustez** | Control de errores al intentar borrar habitaciones ocupadas o clientes con reservas activas |
| **Limpieza** | Uso correcto de PreparedStatement, cierre de recursos y manejo adecuado de excepciones |
| **Transacciones** | Todas las operaciones compuestas se ejecutan bajo una única transacción |

## Estructura de Clases Recomendada

```
src/
├── modelo/
│   ├── Habitacion.java
│   ├── Cliente.java
│   ├── Reserva.java
│   └── CheckIn.java
├── dao/
│   ├── HabitacionDAO.java (interfaz)
│   ├── HabitacionDAOImpl.java
│   ├── ClienteDAO.java (interfaz)
│   ├── ClienteDAOImpl.java
│   ├── ReservaDAO.java (interfaz)
│   ├── ReservaDAOImpl.java
│   ├── CheckInDAO.java (interfaz)
│   └── CheckInDAOImpl.java
├── conexion/
│   └── Conexion.java
└── main/
    └── Main.java
```