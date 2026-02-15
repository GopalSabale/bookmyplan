pipeline {

    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    tools {

        maven 'mvn_3.9.12'
    }

    stages {
        stage('Code Compilation') {
            steps {
                echo 'Starting Code Compilation...'
                sh 'mvn clean compile'
                echo 'Code Compilation Completed Successfully!'
            }
        }
        stage('Code QA Execution') {
            steps {
                echo 'Running JUnit Test Cases...'
                sh 'mvn clean test'
                echo 'JUnit Test Cases Completed Successfully!'
            }
        }

       stage('Code Package') {
            steps {
                echo 'Creating JAR Artifact...'
                sh 'mvn clean package'
                sh '''
                    cp target/*.jar target/bookmyplan-1.1.10.jar
                '''
                echo 'JAR Artifact Created Sucessfully!'
            }
       }
       stage('Build & Tag Docker Image') {
           steps {
               echo 'Building Docker Image and Tagging...'
               sh "docker build -t gopalsabale/bookmyplan:latest -t bookmyplan:latest ."
               echo 'Docker Image Build Completed!'
           }
       }
       stage('Docker Image Scanning') {
           steps {
               echo 'Scanning Docker Image with Trivy...'
               echo 'Docker Image Scanning Completed!'
           }
       }
       stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhubCred', variable: 'dockerhubCred')]) {
                      sh 'docker login docker.io -u gopalsabale -p ${dockerhubCred}'
                      echo 'Pushing Docker Image to Docker Hub...'
                      sh 'docker push gopalsabale/bookmyplan:latest'
                      echo 'Docker Image Pushed to Docker Hub Successfully!'
                    }
                }
            }
       }
       stage('Push Docker Image to Amazon ECR') {
            steps {
               script {
                   withDockerRegistry([credentialsId: 'ecr:ap-south-1:ecr-credentials', url: "https://315354952103.dkr.ecr.ap-south-1.amazonaws.com"]) {
                     echo 'Tagging and Pushing Docker Image to ECR...'
                     sh '''
                     docker images
                     docker tag bookmyplan:latest 315354952103.dkr.ecr.us-east-1.amazonaws.com/bookmyplan:latest
                     docker push 315354952103.dkr.ecr.us-east-1.amazonaws.com/bookmyplan:latest
                     '''
                     echo 'Docker Image Pushed to Amazon ECR Successfully!'
                   }
               }
            }
       }
       stage('Clean Up Local Docker Images') {
            steps {
               echo 'Cleaning Up Local Docker Images...'
                 sh '''
                   docker rmi gopalsabale/bookmyplan:latest || echo "Image not found or already deleted"
                   docker rmi bookmyplan:latest || echo "Image not found or already deleted"
                   docker rmi 315354952103.dkr.ecr.us-east-1.amazonaws.com/bookmyplan:latest || echo "Image not found or already deleted"
                   docker rmi 65.0.76.100:8085/bookmyplan:latest
                   docker image prune -f
                   '''
               echo 'Local Docker Images Cleaned Up Successfully!'
            }
       }
    }
}
