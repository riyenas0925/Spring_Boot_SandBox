pipeline {
  agent any
  stages {
    stage('Poll') {
      steps {
        sh 'chmod +x ./gradlew'
      }
    }

    stage('Build') {
      steps {
        sh './gradlew build --exclude-task test'
      }
    }

    stage('Test') {
      steps {
        sh './gradlew test'
      }
    }

  }
}