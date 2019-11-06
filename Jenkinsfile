pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'Demo'
        sh 'mvn -B clean package'
      }
    }

    stage('war') {
      steps {
        archiveArtifacts '**/*.war'
      }
    }

  }
}