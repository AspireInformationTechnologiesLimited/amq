pipeline {
   //def mvnHome
   agent any
   
   stages {
	   stage('Preparation') { // for display purposes
		  // Get some code from a GitHub repository
		  git 'https://github.com/AspireInformationTechnologiesLimited/amq.git'
		  // Get the Maven tool.
		  // ** NOTE: This 'M3' Maven tool must be configured
		  // **       in the global configuration.           
		  env.JAVA_HOME = "${tool name: 'sunJdk8', type: 'jdk'}"
		  env.PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
		  //mvnHome = tool 'maven350'
	   }
	   stage('Build') {
		  // Run the maven build
		  sh 'java -version'
		  //sh 'mvn -version'
		  echo 'Building ...'
		  
		  /*if (isUnix()) {
			 sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
		  } else {
			 bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
		  }*/
	   }
	   stage('Results') {
		  echo 'Results ...'
		  //junit '**/target/surefire-reports/TEST-*.xml'
		  //archive 'target/*.jar' 
	   }
	}
}