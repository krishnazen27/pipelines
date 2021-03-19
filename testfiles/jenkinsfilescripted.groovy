// Scripted piplined syntax
node {

stage('checkout') {
    sh "ls -la"

}
stage('Build') {
    sh "pwd"

}
stage('test'){
    sh "df -ha"

}
}