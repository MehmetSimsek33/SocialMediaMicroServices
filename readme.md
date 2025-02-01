## Docker

MongoDB
  userName:admin
  password:root
  DB:UserProfileDB
```bash
  docker run -d -p 27017:27017 --name mongo-on-docker -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret -e MONGO_INITDB_DATABASE=testdb mongo
```

## Docker file ile image oluşturmak
 1-!!! Dikkat lokalinizde çalıştırılacak imajlar için  kullanın
````bash
docker build -t configserver:v01 .
````

  2-Docker hub üzerinde yayınlanacak ise 
````bash
docker build -t mehmetsimsek3345/configserver:v01.
````
  3-Eğer m chip bir mac kullancaksak
````bash
docker build  --platform linux/amd64 -t mehmetsimsek3345/configserver:v01 .

docker build  --platform linux/amd64 -t mehmetsimsek3345/userserver:v01 .

docker build  --platform linux/amd64 -t mehmetsimsek3345/autherver:v01 .
````