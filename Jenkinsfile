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
                ftpPublisher alwaysPublishFromMaster: true, continueOnError: true, failOnError: true, publishers: [
                    [configName: 'my_ftp', transfers: [
                        [asciiMode: false, cleanRemote: false, excludes: '', flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: 'target', sourceFiles: 'Jenkinsfile-0.0.1-SNAPSHOT.jar']
                    ]]
                ]
            }
        }
    }
}