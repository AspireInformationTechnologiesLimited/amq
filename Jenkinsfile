pipeline {
    agent any
    tools {
        maven 'maven350'
        jdk 'sunjdk8'
		gradle 'gradle41'
    }
    stages {
        stage('Build') {
            steps {
                sh './gradlew clean test assemble'
            }
        }
    }
    post {
        always {
            junit 'build/test-results/test/*.xml'
        }
    }

}