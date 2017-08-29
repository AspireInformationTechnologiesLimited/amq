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
		
		stages {
			stage('Test') {
				steps {
					sh './gradlew clean check'
				}
			}
			
			post {
				always {
					junit 'build/reports/**/*.xml'
				}
			}

		}		

        stage ('Build') {
            steps {
                sh './gradlew clean shadowJar' 
            }
			
        }
    }
}