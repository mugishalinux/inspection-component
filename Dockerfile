FROM azul/zulu-openjdk-alpine:11
ENV PORT 9090
EXPOSE 9090
COPY target/*.jar /opt/inspection-component
WORKDIR /opt
CMD ["java", "-jar", "inspection-component"]