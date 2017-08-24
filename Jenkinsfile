pipeline {
   agent any
   environment { 
        CC = 'clang'
    }
   
   stages {
	   stage('Preparation') { // for display purposes
		  steps {
		  
			  withEnv(["JAVA_HOME=${ tool 'sunJdk8' }", "PATH+MAVEN=${tool 'maven350'}/bin:${env.JAVA_HOME}/bin"]) {
				sh "mvn --batch-mode -V -U -e clean deploy -Dsurefire.useFile=false"
			  }
		  }
	   }
	   stage('Build') {
		  steps {
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
	   }
	   stage('Results') {
		  steps {
			  echo 'Results ...'
			  //junit '**/target/surefire-reports/TEST-*.xml'
			  //archive 'target/*.jar' 
		  }
	   }
	}
}