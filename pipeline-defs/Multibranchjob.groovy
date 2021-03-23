multibranchPipelineJob('Mulibranch_POR-Release') {
        factory {
          workflowBranchProjectFactory {
            scriptPath('Jenkinsfile')
          }
        }
        branchSources {
          branchSource {
            source {
              gitSCMSource {
                remote('https://github.com/krishnazen27/Calculator.git')
                credentialsId('Github-Creds')
                id('Multi-deploy')
              }
            }
          buildStrategies {
            buildAllBranches {
              strategies {
                skipInitialBuildOnFirstBranchIndexing()
              }
            }
          }
        }
      }
      triggers {
        periodicFolderTrigger {
          interval('1440')
        }
      }
      configure { node ->
        node / sources / data / 'jenkins.branch.BranchSource' / source / traits {
          'jenkins.plugins.git.traits.BranchDiscoveryTrait'()
        }
      }
    }