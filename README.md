# Description
Simple Java PoC

# Compile image
```
docker build -t poc-simple-java:0.0.1-SNAPSHOT .
```

# run image
```
docker run -it --rm --name poc-simple-java -p 8080:8080 poc-simple-java:0.0.1-SNAPSHOT
```

# check microservice
```
curl http://localhost:8080/greeting?name=Miguel
```
