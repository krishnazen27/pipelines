multibranchPipelineJob('Multibranch_PROD_Releases') { 
    description("This job will only be used for regular release deployments to lower ORGS (DEV, QA, TEST, NFT)") 
    branchsources {
        git {
            remote('https://github.com/krishnazen27/Calculator.git')
            credentials('Github-Creds')
            includes('*')
        }
    }
    

}