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
                sh './gradlew clean'
            }
        }		

		stage('Test') {
			steps {
				sh './gradlew check'
			}	
			
			post {
				always {
					junit 'build/reports/**/*.xml'
				}
			}	
		}
		

        stage ('Build') {
            steps {
                sh './gradlew shadowJar' 
            }
			
        }
    }
}