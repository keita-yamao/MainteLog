FROM ubuntu:latest

RUN apt-get update && \
apt-get install -y curl git &&\
apt-get install -y openjdk-21-jdk mysql-client && \
apt-get clean && \
rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-arm64
ENV PATH=$JAVA_HOME/bin:$PATH

WORKDIR /workspace

EXPOSE 8080 3306

CMD ["/bin/bash"]
