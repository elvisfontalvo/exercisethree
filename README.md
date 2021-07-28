# exercisethree
Taller 3

Para crear la base de datos ejecutar el script incluido en el archio "workers.sql"

A continuacion puede consumir los diferentes servicios de la siguinete forma:

Consultar todos los trabajadores:
GET - http://localhost:9090/worker/getAll

Consultar un trabajador:
GET - http://localhost:9090/worker/getById/1

Agregar un nuevo trabajador:
POST - http://localhost:9090/worker/insert
    {
        "name": "Sara",
        "lastname": "Corrales",
        "phone": "3131234567",
        "mail": "uncorreo@gmail.com"
    }
    
Borrar un trabajador:
DELETE - http://localhost:9090/worker/delete/1

Editar un nuevo trabajador:
POST - http://localhost:9090/worker/update/1
    {
        "name": "Sara",
        "lastname": "Medina",
        "phone": "3131234567",
        "mail": "otrocorreo@gmail.com"
    }
