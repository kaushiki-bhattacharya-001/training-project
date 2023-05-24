pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven 3.8.6"
        // Install Java jdk
        jdk "jdk11"
    }

    stages {
        stage('Build') {
            steps {
                // Get code from a GitHub repository
                git 'https://github.com/kaushiki-bhattacharya-001/maven-project.git'

                //echo "Pulling from ..." + git.BRANCH_NAME

                // Run Maven on a Unix agent.
                sh "mvn -f training/pom.xml -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    // junit '**/target/surefire-reports/TEST-*.xml'
                    // archiveArtifacts 'target/*.jar'
                    echo "SUCCESS!!!"
                }
            }
        }
    }
}
