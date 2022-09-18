# Description of the contents of this project

## No Docker Usage

## Docker Usage

to build the docker image and run the container:

```sh
docker build . -t lab1-git-race -f .\src\main\docker\app.dockerfile

docker run -d -p 8080:8080 --name lab1-git-race-container lab1-git-race
```

To stop the container use:

```sh
docker stop <identifier:hash>
```

## Docker-compose

```sh
docker-compose up -d
```