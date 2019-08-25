pipeline{
    agent any
    stages{
        stage("Run Command"){
            steps{
                sh'''
                set +xe
                echo Hello
                ech Error
                sudo yum install httpd -y
                ping -c 4 google.com
                '''
            }
        }
        stage("Download Terraform"){
            steps{
                ws("/tmp"){
                    sh "pwd"
                }
            }
        }
    }
}