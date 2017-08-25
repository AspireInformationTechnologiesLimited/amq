pipeline {
    agent any
    tools {
        maven 'maven350'
        jdk 'sunjdk8'
		gradle 'gradle41'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh './gradlew.sh clean shadowJar' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}