# Stage 1: Build the application
FROM openjdk:17-jdk AS builder

# Install Maven
# Install dependencies and Maven
RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
    && curl -fsSL https://archive.apache.org/dist/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.tar.gz | tar -xzC /usr/share/maven --strip-components=1 \
    && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

# Set the working directory
WORKDIR /app

# Copy the pom.xml and src directory to the container
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:17-jdk

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=builder /app/target/mouad-maqboul.jar /app/demo.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the JAR file
CMD ["java", "-jar", "demo.jar"]
