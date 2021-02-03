FROM openjdk:11
MAINTAINER webmaster@buergi.cloud
COPY target/provider-1.0.0.jar /opt/app.jar
ENV TZ=Europe/Zurich
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENV SPRING_APPLICATION_JSON=''
ENTRYPOINT ["java"]
CMD ["-jar", "/opt/app.jar"]