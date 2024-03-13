
# 🍕 Pizza Express - API

## Descripción del proyecto

API RESTful diseñada para el manejo interno de una pizzería.
Permite la creación de pizzas o bebidas, solicitud de pedidos, gestión de clientes y usuarios, y facilita la gestión de pedidos para su entrega posterior.

## Tecnologías

- Spring Boot
- Spring Data JPA
- Cloudinary
- Spring Security + JWT
- MySQL

## Roles y Privilegios

- Administrador: Creación y modificación de productos (bebidas o pizzas), gestión de roles y visualización de pedidos solicitados, entre otros.
- Empleado: Revisión de pedidos solicitados.

## Configuración de Seguridad

Se utiliza Spring Security junto con JWT para garantizar la seguridad de la API. Los roles y privilegios se aplican a través de la autenticación.

## Endpoints API

![Imagen documentación swagger](https://res.cloudinary.com/ddc9sdc0t/image/upload/v1710350328/proyecto_java/api-pizzas/dco4qu911lroq0doa7cn.jpg)
![Imagen documentación swagger](https://res.cloudinary.com/ddc9sdc0t/image/upload/v1710350335/proyecto_java/api-pizzas/klhuvepfpx6deth8uatl.jpg)
![Imagen documentación swagger](https://res.cloudinary.com/ddc9sdc0t/image/upload/v1710350339/proyecto_java/api-pizzas/jasl2ukzwyb99oymcrwn.jpg)
![Imagen documentación swagger](https://res.cloudinary.com/ddc9sdc0t/image/upload/v1710350342/proyecto_java/api-pizzas/lwl1gwdqrw5hksf7w5tu.jpg)

## Ejecución

- Clonar repositorio
- Crear base de datos con nombre db 
- Compilar las dependencias
```
    mvn clean install
```
- Ejecutar la aplicación Spring Boot
```
    mvn clean install
```
- Configurar datos de Cloudinary
```
cloudinary.cloud_name = 
cloudinary.api_key = 
cloudinary.api_secret = 
```
El proyecto inicia con un usuario por defecto con los siguientes datos:

```json
"nombre" : "user"
"clave" : 1234
"rol":"ADMINISTRADOR"
```

## Contacto

- Correo electrónico : mendoza.e.matias@gmail.com

- Linkedin : <a href="https://www.linkedin.com/in/matias-mendoza-955170240/">Mendoza Matias</a>
