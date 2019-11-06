pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'Demo'
      }
    }

    stage('error') {
      steps {
        archiveArtifacts '**/*.war'
      }
    }

  }
}