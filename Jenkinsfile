pipeline {
  agent any
  tools {
    jdk 'Java-17'
    maven 'Maven-3.8'
    allure 'Allure'
  }
  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build & Test') {
      steps { sh 'mvn clean test' }
    }
    stage('Allure Report') {
      steps {
        sh 'allure generate target/allure-results --clean -o target/allure-report'
      }
    }
  }
  post {
    always {
      allure includeProperties: false, results: [[path: 'target/allure-results']]
    }
  }
}