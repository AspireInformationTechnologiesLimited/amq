pipeline {
    agent any
	tools { 
        maven 'maven350' 
        jdk 'sunJdk8' 
    }
    stages {
        stage('Setup') {
			steps {				
				sh 'java -version'
				sh 'mvn -version'
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