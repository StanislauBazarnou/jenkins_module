pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh './mvnw clean install'
            }
        }
//         stage('Docker build') {
//             steps {
//                 echo 'Building Docker Image..'
//                 sh 'docker build -t my-spring-app:1.0.0 .'
//             }
//         }
//         stage('Run Docker container') {
//            steps {
//                 echo 'Running Docker Container..'
//                 sh 'docker run -d -p 8081:8081 my-spring-app:1.0.0'
//             }
//         }
        stage('Upload to FTP') {
            steps {
                script {
                    ftpPublisher transfers: [
                        [
                            pattern: '',
                            removePrefix: 'target',
                            target: '',
                            asciiMode: false,
                            cleanRemote: false
                        ],
                        remoteDirectory: 'yourRemoteDirectory'
                    ],
                    configName: 'my_ftp',
                    verbose: true
                }
            }
        }
    }
}