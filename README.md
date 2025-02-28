# APlicación de Gestión de Inventario de una Zapatería. 

## Estructura del proyecto.

```

app/
├── data/                # Gestión de la base de datos y modelos
│   ├── db/
│   │   ├── DatabaseHelper.kt  # Maneja SQLite (CRUD: Insert, Update, Delete, Query)
│   ├── model/
│   │   ├── Item.kt  # Modelo de datos de un producto (nombre, precio, categoría, etc.)
│
├── ui/                  # Manejo de la interfaz y pantallas
│   ├── main/
│   │   ├── MainActivity.kt  # Pantalla principal con la lista de productos
│   │   ├── MainFragment.kt  # Fragmento que muestra los productos en un RecyclerView
│   │   ├── ItemAdapter.kt  # Adaptador para mostrar los productos en el RecyclerView
│   ├── detail/
│   │   ├── DetailActivity.kt  # Muestra los detalles de un producto y permite editar o eliminar
│   ├── form/
│   │   ├── FormActivity.kt  # Formulario para agregar/editar productos
│
├── res/                 # Recursos de la app (layouts, colores, strings)
│   ├── layout/
│   │   ├── activity_main.xml  # Diseño de la pantalla principal
│   │   ├── fragment_main.xml  # Diseño del fragmento con la lista de productos
│   │   ├── activity_detail.xml  # Diseño de la pantalla de detalles
│   │   ├── activity_form.xml  # Diseño del formulario para agregar/editar productos
│   ├── values/
│   │   ├── colors.xml, strings.xml, themes.xml  # Configuración visual de la app
│
├── navigation/
│   ├── nav_graph.xml  # Maneja la navegación entre las pantallas usando Navigation Component
│
├── AndroidManifest.xml  # Configura las actividades y permisos de la app


```


## Apk de la aplicación.



## Capturas de pantalla de la aplicación.

<img src="" alt="">
<img src="" alt="">
<img src="" alt="">
<img src="" alt="">
<img src="" alt="">
<img src="" alt="">
<img src="" alt="">