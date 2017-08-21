pipeline {
    agent any

    stages {
        stage('Setup') {
			steps {
				sh 'java -version'
				sh 'gradle -version'
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