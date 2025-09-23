# Build stage
FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /build

COPY gradlew .
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

RUN chmod +x ./gradlew
RUN ./gradlew --no-daemon dependencies || true
COPY src ./src

RUN ./gradlew --no-daemon clean bootJar -x test --parallel -Dorg.gradle.jvmargs="-Xmx1g"

FROM eclipse-temurin:17-jre-alpine
RUN apk add --no-cache wget

WORKDIR /app
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -XX:InitialRAMPercentage=50.0 -XX:MinRAMPercentage=25.0 -XX:+UseG1GC -XX:MaxGCPauseMillis=200"

COPY --from=builder /build/build/libs/*.jar app.jar
RUN addgroup -S spring && adduser -S spring -G spring \
    && chown spring:spring /app/app.jar

USER spring:spring

HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
    CMD wget --no-verbose --tries=1 --spider http://localhost:8080/actuator/health || exit 1

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
