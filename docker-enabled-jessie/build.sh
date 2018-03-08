docker build . -t docker-enabled-jessie
docker tag docker-enabled-jessie:latest vargadan/docker-enabled-jessie:latest
docker push vargadan/docker-enabled-jessie:latest
