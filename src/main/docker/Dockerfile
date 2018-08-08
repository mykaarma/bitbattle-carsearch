FROM tomcat:9.0.0.M19
ENV JAVA_OPTS="$JAVA_OPTS -XX:+UseG1GC -XX:+UseStringDeduplication -Xms4096m -Xmx10240m -server -XX:+DisableExplicitGC" UMASK="022"
ADD bitbattle-carsearch*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
