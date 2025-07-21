# Use official Maven image to build the app
FROM maven:3.9.6-eclipse-temurin-17 as build

# Set working directory inside container
WORKDIR /app

# Copy pom.xml and install dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Use smaller Java image to run the app
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/employee_management-0.0.1-SNAPSHOT.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
