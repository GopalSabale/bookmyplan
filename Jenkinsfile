pipeline {

    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    tools {
        maven 'mvn_3.9.12'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                echo 'Starting Code Compilation...'
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running JUnit Test Cases...'
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Creating WAR Artifact...'
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully 🎉'
        }
        failure {
            echo 'Pipeline failed ❌'
        }
    }
}
