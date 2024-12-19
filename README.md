# Description 
Simple Java PoC v1.1.0 

# Compile docker image
```
docker build -t poc-simple-java:0.0.1-SNAPSHOT .
```

# Run image in local mode
```
docker run -it --rm --name poc-simple-java -p 8080:8080 poc-simple-java:0.0.1-SNAPSHOT
```

# Check microservice in local mode
```
curl http://localhost:8080/greeting?name=Miguel
```

# Publish on docker hub
- You must have a DockerHub account (ID Account and password)
- You must create a repository in your account
- Login in your account from docker

```
docker login
```

- Publish your image

```
docker tag poc-simple-java:0.0.1-SNAPSHOT ofertoio/poc-simple-java:0.0.1-SNAPSHOT
docker push ofertoio/poc-simple-java:0.0.1-SNAPSHOT
```

# Test pod in kubernetes
```
kubectl --namespace default port-forward svc/poc-simple-java-service 8088:8080
```

navigate to: http://localhost:8088/greeting
