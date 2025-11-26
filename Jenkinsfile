pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'kaushalrajpuwar/imt2023063:latest'
    }

    stages {

        stage('Checkout') {
            steps {
                git url: 'https://github.com/KaushalrajPuwar/todo-cli-jenkins.git', branch: 'main'
            }
        }

        stage('Build & Test') {
            steps {
                dir('todo-cli') {
                    sh 'mvn clean test'
                }
            }
        }

        stage('Package') {
            steps {
                dir('todo-cli') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {
                    sh '''
                        echo $PASS | docker login -u $USER --password-stdin
                        docker push $DOCKER_IMAGE
                    '''
                }
            }
        }
    }
}
