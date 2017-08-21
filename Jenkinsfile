pipeline {
    agent any

    stages {
        stage('Setup') {
			node() {
				env.JAVA_HOME = "${tool name: 'jdk-8', type: 'jdk'}"
				env.PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
				sh 'java -version'
			}			
		}
		stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}