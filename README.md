# Description
Simple Java PoC

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
docker tag poc-simple-java:0.0.1-SNAPSHOT masalinasgancedo/poc-simple-java:0.0.1-SNAPSHOT
docker push masalinasgancedo/poc-simple-java:0.0.1-SNAPSHOT
```