pipeline {
    agent any

    environment {
        // Replace with your SonarQube server URL, for example: http://localhost:9000
        SONAR_URL = 'http://localhost:9000'
        // Replace with your Jenkins credential ID that stores the SonarQube token
        SONAR_TOKEN = credentials('sonar-token')
        // Replace with your SonarQube project name
        SONAR_PROJECT_NAME = 'sonarqube-lab'
        SONAR_PROJECT_KEY = 'sonarqube-lab'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/nandinikiaq/sonarqube-lab.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '''
                        mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.10.0.2594:sonar \
                          -Dsonar.host.url="${SONAR_URL}" \
                          -Dsonar.login="${SONAR_TOKEN}" \
                          -Dsonar.projectKey="${SONAR_PROJECT_KEY}" \
                          -Dsonar.projectName="${SONAR_PROJECT_NAME}" \
                          -Dsonar.java.binaries=target/classes
                    '''
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}
