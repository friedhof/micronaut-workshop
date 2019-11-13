# build the project
FROM oracle/graalvm-ce:19.2.1 AS native-image
COPY . /app
WORKDIR /app
RUN chmod +x gradlew
RUN ./gradlew jar

# create the native executable
RUN gu install native-image
RUN native-image -H:Name=list -H:+ReportExceptionStackTraces --static --no-server -jar build/libs/list.jar

# create the final docker image
FROM scratch
COPY --from=native-image /app/list /list
ENTRYPOINT ["/list"]
