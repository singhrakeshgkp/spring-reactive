pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'build phase'
            }
        }
    stage('test') {
            steps {
                echo 'test phase'
            }
        }

    stage('deploy') {
                steps {
                    sh 'deploy phase'
                }
            }
    }
}
