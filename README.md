# Biblioteca App

App de una biblioteca hecha con Kotlin y Jetpack Compose. La hice para practicar **Navigation Compose**: conectar varias pantallas y pasar información entre ellas. Por ahora todos los datos son estáticos, o sea que no hay base de datos ni internet.

## Qué practiqué

- `NavHost` y `NavController`
- Rutas con parámetros, por ejemplo `detalle_libro/{libroId}`
- Envío de varios parámetros a la vez (nombre del libro, fecha y código de la reserva)
- Recepción de argumentos en la pantalla de destino
- Manejo de la pila de pantallas con `popUpTo` y `popBackStack`
- Organización del proyecto por carpetas (`data`, `navegation`, `ui`)

## Pantallas

**Flujo 1: reservar un libro**

Inicio → Lista de libros → Detalle del libro → Reserva exitosa

**Flujo 2: mis reservas**

Mis reservas → Detalle de reserva → Renovar reserva → Renovación exitosa

Desde el detalle de la reserva también se puede cancelar, y eso lleva a la pantalla de Reserva cancelada.

| Pantalla | Ruta | Parámetros |
|---|---|---|
| Inicio | `inicio` | ninguno |
| Lista de libros | `lista_libros` | ninguno |
| Detalle del libro | `detalle_libro/{libroId}` | `libroId` (Int) |
| Reserva exitosa | `confirmacion/{libroId}` | `libroId` (Int) |
| Mis reservas | `mis_reservas` | ninguno |
| Detalle de reserva | `detalle_reserva/{nombreLibro}/{fechaReserva}/{codigoReserva}` | 3 textos |
| Renovar reserva | `renovar_reserva/{nombreLibro}/{fechaReserva}/{codigoReserva}` | 3 textos |
| Renovación exitosa | `renovacion_exitosa/{nombreLibro}/{fechaNueva}` | 2 textos |
| Reserva cancelada | `reserva_cancelada` | ninguno |

Las fechas tienen `/` (por ejemplo 15/06/2026), y eso rompería la ruta. Por eso se codifican con `Uri.encode` antes de navegar.

## Estructura del proyecto

```
com.example.biblioteca
├── data
│   ├── Libro.kt
│   ├── Reserva.kt
│   └── DatosEstaticos.kt
├── navegation
│   ├── Routes.kt
│   └── AppNavegation.kt
├── ui
│   ├── composable    piezas pequeñas y reutilizables
│   ├── section       bloques grandes que forman parte de una pantalla
│   ├── screen        pantallas completas
│   └── theme         colores y tipografía
└── MainActivity.kt
```

Cada carpeta de `ui` usa solo a la de su derecha:

```
screen  →  section  →  composable
```

- **composable**: `FilaInfo`, `EstadoChip`, `LibroItem`, `ReservaItem`, `PortadaLibro`, `CampoFecha`, `IconoResultado`
- **section**: `InfoLibroSection`, `DatosReservaSection`, `AccionesReservaSection`, `ResumenLibroSection`, `FechasRenovacionSection`, `ResumenRenovacionSection`
- **screen**: una por cada pantalla de la tabla de arriba

## Cómo funciona la navegación

`Routes.kt` guarda los nombres de las rutas y `AppNavegation.kt` dice qué pantalla va en cada una. Las pantallas no conocen el `NavController`: solo reciben funciones como `onVerLibros` o `onRenovar` y las ejecutan cuando el usuario toca un botón. Quien decide a dónde ir es `AppNavegation`. Así las pantallas se pueden ver en el `@Preview` sin necesitar la navegación.

## Flujo de trabajo en Git

- `main`: solo tiene 2 commits, el inicial y el final.
- `develop`: aquí se juntan todas las features.
- `feature/*`: una rama por cada funcionalidad. Salen de `develop` y vuelven a `develop` con un Pull Request.

Cada feature sigue el mismo ciclo: `pull` de `develop`, crear la rama, hacer el commit, `push`, Pull Request hacia `develop` y merge. Al final se hace un Pull Request de `develop` hacia `main` con **Squash and merge**, para que `main` quede con un solo commit final.

## Cómo correrlo

1. Clonar el repositorio.
2. Abrirlo con Android Studio y esperar a que termine el *Sync* de Gradle.
3. Elegir un emulador o un celular y presionar **Run**.

## Cosas que quedaron pendientes

- Los datos son estáticos, así que cancelar o renovar una reserva no cambia la lista de Mis reservas.
- Las etiquetas "Parámetro recibido" y "Argumentos recibidos" están a propósito, porque salen en el diseño de la práctica.

## Tecnologías

Kotlin, Jetpack Compose, Material 3, Navigation Compose, Android Studio, Git y GitHub.

## Autor

Juan ([@JuanR1207](https://github.com/JuanR1207)), estudiante de SENA.