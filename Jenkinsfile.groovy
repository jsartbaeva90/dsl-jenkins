pipeline{
    agent any
    stages{
        stage("Run Command"){
            steps{
                sh '''
                set +xe
                echo Hello
                ech  Error
                sudo yum install httpd wget unzip -y
                ping -c 4 google.com
                '''
            }
        }
        stage("Download Terraform"){
            steps{
                ws("tmp/"){
                    sh "pwd"
                    sh "wget https://releases.hashicorp.com/terraform/0.12.7/terraform_0.12.7_linux_amd64.zip"
                    sh "unzip terraform_0.12.7_linux_amd64.zip"
                    sh "sudo mv terraform /bin"
                    sh "terraform version"
                }
            }
        }
    }
}
