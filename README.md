# neoris_banco_test

Tecnologias Relevantes:
 Este micrtoservicio esta utilizando las siguientes tecnologias :
 1. Swagger  : para poder visualizar los endpoint debe acceder a la siguiente ruta : http://localhost:8080/api/swagger-ui.html .
  Utilizando esta tecnolgia los endpoind se documentan y no es necesario usar Postman .
 2.Flyway: Esta tegnologia le delega al micro la tarea de administrar o creacion de objetos en la base de datos,
 solo hace falta subir el micro para que automaticamente se cree el modelo de base de datos.
 3.Docker: Se implementa DockerFile para poder dockerizar la aplicacion
 4.docker-composer: se crea el YML para que se cree la base de datos y el contendor del micro automaticamente.
 5.Junit y Mockyto : se implementan un par de pruebas unitarias a los endpoins y service 
 
 
 #url para ver los servicios en la web 
 http://localhost:8080/api/swagger-ui.html
 
 Crear la base de datos mysql con docker  (el comando "--platform linux/x86_64" no es del todo necesario)
 
  docker run --name mysqldb --platform linux/x86_64   -e MYSQL_ROOT_PASSWORD=eldany1234 -e MYSQL_DATABASE=banco -p 3306:3306/tcp -d mysql:5.7


 Pasos para construir el docker
 
 1. Se debe crear el JAR o empaquetar 
 
mvn clean
mvn package
mvn package -DskipTests (comando para no correr los test)

2. los sigientes comando son para crear la imagen y contenedor del micro

docker build -t img_ms_bank:V1 .
docker run -d -p 8080:8080 --name ms-bank-v1 -e DB_HOST=host.docker.internal:3306 img_ms_bank:V1
#para crear la imagenes con el archivo de configuraciones
#docker run -d -p 8080:8080  --env-file .env --name ms-bank-v1  img_ms_bank:V1

3. ver logs 
docker logs -f #idContenedor o nombre del contenedor  (ms-bank-v1)
docker logs -f ms-bank-v1

4. docker composer

Un punto importante de la aplicacion es que tambien tiene un archivo de variables de entorno  y en caso de no usarse el application properties usa las que tiene por default

docker compose up -d
#eliminar
docker compose down
docker compose down  -v

5. repositorio donde esta el contendedor

https://hub.docker.com/repositories/daniel0223

