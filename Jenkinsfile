pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh './mvnw clean install'
            }
        }
        stage('Docker build') {
            steps {
                echo 'Building Docker Image..'
                sh 'docker build -t my-spring-app:1.0.0 .'
            }
        }
        stage('Run Docker container') {
           steps {
                echo 'Running Docker Container..'
                sh 'docker run -d -p 8081:8081 my-spring-app:1.0.0'
            }
        }
    }
}