podTemplate(
  containers: [
    containerTemplate(name: 'maven', image: 'maven:3.8-jdk-11', command: 'sleep', args: '99d'),
    containerTemplate(name: 'docker', image: 'docker',  command: 'sleep', args: '99d')
  ],
  volumes: [
    hostPathVolume(hostPath: '/var/run/docker.sock', mountPath: '/var/run/docker.sock')
  ]) {
    node(POD_LABEL) {
        stage("CI pipeline") {
	        container('maven') {
	            stage("Checkout") {
                    git branch: "master", url: "https://github.com/masalinas/poc-simple-java.git"
                }

	            stage('Compile') {
                    sh "mvn clean install -DskipTests"
                }

                stage("Checkstyle") {
                    sh "mvn checkstyle:checkstyle"
                }

                stage("Run unit tests") {
                    sh "mvn test -Punit"

                    //junit "**/TEST-*.xml"
                }

                stage("Run integration tests") {
                    sh "mvn test -Pintegration"
                }
	        }

	        container('docker') {
                stage("Compile and push image") {
                   // build image
                   sh "docker build -t $DOCKER_USER/poc-simple-java:$BUILD_NUMBER ."

                   // tag build image
                   sh "docker login --username=$DOCKER_USER --password=$DOCKER_PASS"

                   // push image to docher hub
                   sh "docker image push $DOCKER_USER/poc-simple-java:$BUILD_NUMBER"
                }
            }
        }
        
        stage("CD pipeline") {
            withCredentials([file(credentialsId:'kube-config', variable:'KUBE_CONFIG')]) {
                sh 'cat deployment-template.yaml | sed "s|{{DOCKER_IMAGE}}|$DOCKER_USER/poc-simple-java:$BUILD_NUMBER|" > deployment.yaml'

                sh 'curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"'
                sh 'chmod u+x ./kubectl'

                sh './kubectl --kubeconfig ${KUBE_CONFIG} apply -f deployment.yaml'
            }
        }        
    }
}
