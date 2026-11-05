pipeline {
    agent any

    environment {
        MAVEN_OPTS = '-Djava.io.tmpdir=/var/lib/jenkins/tmp'
        TMPDIR = '/var/lib/jenkins/tmp'
    }

    tools {
        maven 'Maven'
        jdk 'JDK21'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code from GitHub'

                git branch: 'main',
                    url: 'https://github.com/nandinikiaq/sonarqube-lab.git'
            }
        }

        stage('Verify Tools') {
            steps {
                echo 'Checking Java and Maven versions'

                sh 'java -version'
                sh 'mvn -version'
                sh 'df -h /var/lib/jenkins/tmp'
            }
        }

        stage('Build and Test') {
            steps {
                echo 'Building Java application and running tests'

                sh 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Starting SonarQube code analysis'

                withSonarQubeEnv('SonarQube-Server') {
                    sh '''
                        mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar \
                        -Dsonar.projectKey=sonarqube-lab \
                        -Dsonar.projectName=sonarqube-lab
                    '''
                }
            }
        }

        stage('Quality Gate') {
            steps {
                echo 'Waiting for SonarQube Quality Gate result'

                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: Build, tests and SonarQube analysis completed successfully!'
        }

        failure {
            echo 'FAILURE: Pipeline failed. Check Console Output.'
        }

        always {
            echo 'Pipeline execution completed.'
        }
    }
}