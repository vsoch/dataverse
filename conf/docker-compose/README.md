# Dockerized Dataverse

This is a brief documentation for installation of Dataverse via Docker, meaning 
the building of Docker images and deployment with [docker-compose](https://docs.docker.com/compose/).

## Install

 - [Docker Community Edition](https://docs.docker.com/install)
 - [Docker Compose](https://docs.docker.com/compose/install)

Specifically, for the writing of this documentation, the following versions were
used:

```bash
$ docker-compose --version
docker-compose version 1.21.2, build a133471

$ docker --version
Docker version 18.03.1-ce, build 9ee9f40
```


## Notes

**TODO: stopped here - installer needs to be broken up into components according to images**

```bash
# Postgres
GLASSFISH_USER=glassfish
GLASSFISH_USER_HOME=~glassfish
GLASSFISH_ROOT=$GLASSFISH_USER_HOME/glassfish4

# We may need to customize solr according to the following:
SOLR_USER=solr
SOLR_DIR="/usr/local/solr-4.6.0/example"
JAVA_OPTIONS="-Xmx1024m -DSTOP.PORT=8079 -DSTOP.KEY=mustard -jar start.jar"
LOG_FILE="/var/log/solr.log"
JAVA="/usr/bin/java"
```
