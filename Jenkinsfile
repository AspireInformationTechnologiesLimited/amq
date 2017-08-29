pipeline {
    agent any
    tools {
        maven 'maven350'
        jdk 'sunjdk8'
		gradle 'gradle41'
    }
    stages {
        stage('Test') {
            steps {
                sh './gradlew check'
            }
        }
    }
    post {
        always {
            junit 'build/reports/**/*.xml'
        }
    }

}