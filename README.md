# Aplicación Android - Consulta de Alumnos con API

## Descripción

Esta aplicación Android desarrollada en Java consume una API REST utilizando la librería Volley para mostrar información de alumnos en pantalla.

Los datos obtenidos incluyen:

* Nombres
* Correo electrónico
* Paralelo
* Período académico

La aplicación realiza una petición GET a una API externa y muestra los registros obtenidos dentro de la interfaz gráfica.

---

# Tecnologías utilizadas

* Java
* Android Studio
* Volley
* API REST
* GitHub

---

# Funcionamiento de la aplicación

La aplicación:

1. Realiza una solicitud HTTP GET a la API.
2. Obtiene los datos en formato JSON.
3. Procesa los registros recibidos.
4. Muestra la información de los alumnos en pantalla.

---

# Código principal

La lógica principal se encuentra en:

```java id="4s1p9a"
MainActivity.java
```

El proyecto utiliza la librería Volley para las solicitudes HTTP.

---

# Seguridad

Por motivos de seguridad:

* NO se incluyen API Keys privadas en el repositorio.
* Solamente se deja visible la Base URL utilizada para la conexión.

---

# Estructura del proyecto

```text id="2b7r9f"
app/
 ├── java/
 │    └── MainActivity.java
 ├── res/
 │    └── layout/
 │         └── activity_main.xml
```

---

# Evidencias solicitadas

El proyecto incluye:

* Código fuente Java de la actividad.
* Aplicación Android mostrando los alumnos.
* Captura de la tabla con los datos registrados.
* Proyecto Android completo subido a GitHub.

---


