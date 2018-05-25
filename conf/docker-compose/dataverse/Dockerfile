FROM centos:7.2.1511
MAINTAINER dinosaur (vsochat@stanford.edu)

RUN yum install -y wget libmemcached-devel nss

ENV DATAVERSE_VERSION 4.8.6
ENV DATAVERSE_WAR /dataverse/target/dataverse.war

# JQ, dataverse
RUN wget http://stedolan.github.io/jq/download/linux64/jq && \
    chmod +x jq && mv jq /usr/bin/jq

# Download and extract dataverse, rename to just "dataverse"
RUN wget https://github.com/IQSS/dataverse/archive/v${DATAVERSE_VERSION}.tar.gz && \
    tar -xzvf v4.8.6.tar.gz && mv dataverse-${DATAVERSE_VERSION} dataverse && \
    mkdir -p /dataverse/target && cd /dataverse/target && \
    wget https://github.com/IQSS/dataverse/releases/download/v${DATAVERSE_VERSION}/dataverse-${DATAVERSE_VERSION}.war && \
    mv dataverse-${DATAVERSE_VERSION}.war ${DATAVERSE_WAR}

# Update yum repos
RUN cp /dataverse/conf/vagrant/etc/yum.repos.d/shibboleth.repo /etc/yum.repos.d && \
    cp /dataverse/conf/vagrant/etc/yum.repos.d/epel-apache-maven.repo /etc/yum.repos.d

# Install java, etc.
RUN yum install -y java-1.8.0-openjdk-devel \               
                   apache-maven \
                   httpd \
                   mod_ssl \
                   unzip

# RUN alernatives --set java /usr/lib/jvm/jre-1.8.0-openjdk.x86_64/bin/java && \
#    alternatives --set javac /usr/lib/jvm/java-1.8.0-openjdk.x86_64/bin/javac && \
#    java -version && javac -version

# Install dataverse configuration
RUN cp /dataverse/conf/httpd/conf.d/dataverse.conf /etc/httpd/conf.d/dataverse.conf && \
    mkdir -p /var/www/dataverse/error-documents && \
    cp /dataverse/conf/vagrant/var/www/dataverse/error-documents/503.html /var/www/dataverse/error-documents && \
    cp /dataverse/conf/docker-compose/dataverse/default.config /dataverse/scripts/installer

# Install Dataverse
WORKDIR /dataverse/scripts/installer
RUN ./install -y -f

EXPOSE 8080
EXPOSE 80
EXPOSE 443

ADD /entrypoint.sh /
ENTRYPOINT ["/bin/bash", "/entrypoint.sh"]
