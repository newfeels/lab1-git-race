# Description of the contents of this project

Complete me!

## No Docker Usage

[PIKANACHI](https://github.com/pikanachi/lab1-git-race/commit/534226f51adec6cb951025122bb25c1c9f05a389)

## Docker Usage
```
# Build image
docker build . -t lab1-git-race -f .\src\main\docker\app.dockerfile

# Run container
docker run -d -p 8080:8080 --name lab1-git-race-container lab1-git-race
# To stop the container use: docker stop <identifier:hash>
```

## Docker-compose
```
docker-compose up -d
```