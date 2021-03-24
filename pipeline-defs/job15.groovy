multibranchPipelineJob("my_awesome_job") {
    displayName "my awesome job"
    description "multi-branch pipeline job thingy"
    branchSources {
        git {   
            remote('https://github.com/krishnazen27/Calculator.git')
            credentialsId('')
            includes('*')
            // set the default property strategy
            defaultBranchPropertyStrategy {
                noTriggerBranchProperty()
            }
        }
    }
}