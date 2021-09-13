pipeline {
    agent any

    stages {
        stage("Checkout") {
            steps {
                git branch: "master", url: "https://github.com/masalinas/poc-simple-java.git"
            }
        }

        stage("Compile") {
            steps {
                sh "./mvnw clean install -DskipTests"
            }
        }
        
        stage("Checkstyle") {
            steps {
                sh "./mvnw checkstyle:checkstyle"
            }
        }
        
        stage("Run Tests") {
            parallel {
                stage("Runing unit tests") {
                    steps {
                        sh "./mvnw test -Punit"
                    }
                    
                    post {
                        always {
                            junit "**/TEST-*.xml"
                        }
                    }
                }
                
                stage("Runing integration tests") {
                    steps {
                        sh "./mvnw test -Pintegration"
                    }                
                }
            }
        }
    }
}