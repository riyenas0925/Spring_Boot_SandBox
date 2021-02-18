pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''chmod +x ./gradlew
./gradlew clean build --exclude-task test'''
        stash(name: 'build-artifacts', includes: '**/build/libs/*.war')
      }
    }

    stage('Test') {
      steps {
        sh '''./gradlew test
'''
        stash(name: 'test-artifacts', includes: '**/build/test-results/test/TEST-*.xml')
      }
    }

    stage('Coverage') {
      steps {
        sh './gradlew jacocoTestReport'
        jacoco(
          execPattern: '**/build/jacoco/*.exec',
          classPattern: '**/build/classes/java,**/build/classes/groovy',
          inclusionPattern: '**/*.class',
          exclusionPattern: '**/test/**,**/integrationTest**,**/*Test.class,**/Q*.class,**/config/**/*.class',
          sourcePattern: '**/src/main/java',
          sourceInclusionPattern: '**/*.java',
          changeBuildStatus: true
        )
      }
    }

    stage('Report & Publish') {
      steps {
        unstash 'test-artifacts'
        unstash 'build-artifacts'
        junit '**/build/test-results/test/TEST-*.xml'
        archiveArtifacts 'build/libs/*.war'
      }
    }

  }
}