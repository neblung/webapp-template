#!/usr/bin/env bash

CONTAINER=$(basename `pwd`)

set -e
./gradlew build
containerid=$(docker run -d --name=$CONTAINER -p 8080:8080 jboss/wildfly:10.1.0.Final)
echo started container $containerid
docker cp $(find build -name '*.war') $containerid:/opt/jboss/wildfly/standalone/deployments

echo $CONTAINER up and running
echo "direct your browser to http://localhost:8080/$CONTAINER"
echo "view logs with: \$> docker logs -f $CONTAINER"
read -p "press <ENTER> to kill container" eatCR
docker rm -f $CONTAINER

