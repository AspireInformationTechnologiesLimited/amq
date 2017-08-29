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
                sh './gradlew clean check'
            }
        }
    }
    post {
        always {
            junit 'build/reports/tests/test/index.html'
        }
    }

}