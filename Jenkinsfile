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
//         stage('Upload to FTP') {
//             steps {
//                 sh 'curl --ftp-create-dirs -T target/Jenkinsfile-0.0.1-SNAPSHOT.jar -u myuser:mypass123 ftp://127.0.0.1/'
//             }
//         }
//         stage('Upload to FTP') {
//             steps {
//                 sh 'curl -v --ftp-create-dirs -T target/Jenkinsfile-0.0.1-SNAPSHOT.jar -u myuser:mypass123 ftp://my_ftp:21/'
//             }
//         }
        stage('Upload to server via SSH') {
            steps {
                sshPublisher(
                    continueOnError: false, failOnError: true,
                    publishers: [
                        sshPublisherDesc(
                            configName: "my_ssh",
                            transfers: [
                                sshTransfer(
                                    sourceFiles: "target/Jenkinsfile-0.0.1-SNAPSHOT.jar",
                                    removePrefix: "target",
                                    remoteDirectory: "/",
                                    execCommand: "echo 'Jar file successfully transferred'")
                            ]
                        )
                    ]
                )
            }
        }
        stage('Run app on server') {
            steps {
                sshPublisher(
                    continueOnError: false, failOnError: true,
                    publishers: [
                        sshPublisherDesc(
                            configName: "my_ssh",
                            transfers: [
                            sshTransfer(
                                remoteDirectory: "/",
                                execCommand: "java -jar Jenkinsfile-0.0.1-SNAPSHOT.jar")
                            ]
                        )
                    ]
                )
            }
        }
    }
}