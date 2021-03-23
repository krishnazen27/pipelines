pipelineJob('test3_Releases') { 
    description("This job will only be used for regular release deployments to lower ORGS (DEV, QA, TEST, NFT)") 
    parameters { 
        string { 
            name('BRANCH_NAME') 
            defaultValue('master') 
            description('The branch to be used from thebuild repo (case sensitive). Alternatively, use the commit ID. If left empty, dev branch will be picked') 
            trim(true) 
        } 
        choiceParam('DEPLOYMENT_ENV', ['dev', 'qa', 'test', 'uat', 'nft'], 'Please select the environment(ORG) to trigger deployment. Default will be dev org') 
        booleanParam { 
            name('TEST_ONLY_VALIDATION') 
            defaultValue(true) 
            description('Enables to run Validations in seleced LOWER Env ')     
        } 
    } 
    definition { 
        cpsScm {
            scm {
                git {
                    branch ('${BRANCH_NAME}')
                    remote {
                        credentials('')
                        url('https://github.com/krishnazen27/Calculator.git')
                    }
                }
            }

            scriptPath('script/jobsteps.groovy')

        } 
    }
}