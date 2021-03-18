// Scripted piplined syntax
node (lable) {

stage('checkout') {
    sh "ls -la"

}
stage('Build') {
    sh "pwd"

}
stage('test'){
    sh "mkdir krishna"

}

}