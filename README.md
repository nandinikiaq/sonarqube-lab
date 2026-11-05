# SonarQube Lab

This repository contains a small Java/Maven sample project and a Jenkins pipeline for SonarQube analysis.

## Sample project

The project is a minimal Maven application that can be built and scanned with SonarQube:

- `pom.xml` - Maven configuration and SonarQube plugin
- `sonar-project.properties` - local SonarQube project configuration
- `Jenkinsfile` - Jenkins pipeline for CI + SonarQube analysis
- `src/main/java/com/example/sonarqubelab/App.java` - sample source code
- `src/test/java/com/example/sonarqubelab/AppTest.java` - test case

## Where to substitute the SonarQube values

### 1) Jenkins pipeline
In `Jenkinsfile`, replace these values:

- `SONAR_URL = 'http://localhost:9000'`
- `SONAR_TOKEN = credentials('sonarqube-token')`
- `SONAR_PROJECT_NAME = 'sonarqube-lab'`
- `SONAR_PROJECT_KEY = 'sonarqube-lab'`

The important SonarQube parameters are passed in this command:

```sh
mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.10.0.2594:sonar \
  -Dsonar.host.url="${SONAR_URL}" \
  -Dsonar.login="${SONAR_TOKEN}" \
  -Dsonar.projectKey="${SONAR_PROJECT_KEY}" \
  -Dsonar.projectName="${SONAR_PROJECT_NAME}"
```

### 2) Local Sonar configuration
In `sonar-project.properties`, replace:

- `sonar.host.url=http://localhost:9000`
- `sonar.token=YOUR_SONAR_TOKEN`
- `sonar.projectKey=sonarqube-lab`
- `sonar.projectName=sonarqube-lab`

## Jenkins setup

1. Install the SonarQube Scanner plugin in Jenkins.
2. Create a Jenkins credential named `sonarqube-token`.
3. Add a SonarQube server in Jenkins with the URL you want to use.
4. Make sure the SonarQube project key and project name match the values in your pipeline.

## Quality gate flow

The Jenkinsfile includes:

- `Build and Test`
- `SonarQube Analysis`
- `Quality Gate`

The `waitForQualityGate` step stops the pipeline if the SonarQube quality gate fails.

## Run locally

```sh
mvn clean test
mvn sonar:sonar \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=YOUR_SONAR_TOKEN \
  -Dsonar.projectKey=sonarqube-lab \
  -Dsonar.projectName=sonarqube-lab
```

This project is ready for testing and scanning in Jenkins or locally with SonarQube.
