FROM oracle/graalvm-ce:19.2.1 as graalvm
COPY . /home/app/beers
WORKDIR /home/app/beers
RUN gu install native-image
RUN native-image --no-server -cp build/libs/beers-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/beers .
ENTRYPOINT ["./beers"]
