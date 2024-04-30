pipeline{
    agent any
    tools{
        maven "maven"

    }
    stages{
        stage("Build JAR File"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/davidmartinez-esc/ev1_TingesoBackend']])
                dir("demo"){
                    bat "mvn clean install"
                }
            }
        }
        stage("Test"){
            steps{
                dir("demo"){
                    bat "mvn test"
                }
            }
        }        
        stage("Build and Push Docker Image"){
            steps{
                dir("demo"){
                    script{
                         withDockerRegistry(credentialsId: 'docker-credentials'){
                            bat "docker build -t dddavidesc/imagen-final-backend ."
                            bat "docker push dddavidesc/imagen-final-backend"
                        }
                    }                    
                }
            }
        }
    }
}
