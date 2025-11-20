pipeline {
    agent any

    environment {
        PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"

        // Define Docker Hub credentials ID
        DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
        // Define Docker Hub repository name
        DOCKERHUB_REPO = 'jarkkok1/OTP2-InclassCal:latest'
        // Define Docker image tag
        DOCKER_IMAGE_TAG = 'latest'
        SONAR_HOST_URL = 'http://localhost:9000'
        SONAR_AUTH_TOKEN = credentials('SonarQubeServer')
        SONARQUBE_SCANNER = 'SonarScanner'
    }

    tools{
        maven 'MAVEN3'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch:'master', url:'https://github.com/JarkkoKarki/OTP2-InclassCal.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                        withCredentials([string(credentialsId: 'SonarQubeServer', variable: 'SONAR_TOKEN')]) {
                            bat """
                                ${tool 'SonarScanner'}\\bin\\sonar-scanner ^
                                -Dsonar.projectKey=OTP2-InclassCal ^
                                -Dsonar.sources=src/main/java ^
                                -Dsonar.tests= ^
                                -Dsonar.projectName=OTP2-InclassCal ^
                                -Dsonar.host.url=${SONAR_HOST_URL} ^
                                -Dsonar.token=%SONAR_TOKEN% ^
                                -Dsonar.java.binaries=target/classes
                            """
                    }
                }
            }
        }
    }
}