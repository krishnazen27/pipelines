freeStyleJob('Seed-Single-Job') { 
    description('This job seeds a single job onto the current Jenkins env whilst leaving others untouched') 
    logRotator(7,30) 
    parameters { 
        stringParam('PIPELINE_BRANCH', 'main', 'Name of branch in Pipelines repo') 
        stringParam('PATH_TO_JOB', '', 'Pleaseeee do NOT use wildcards here') 
    } 
    scm { 
        git { 
            branch('${PIPELINE_BRANCH}') 
            remote { 
                url('https://github.com/krishnazen27/pipelines.git')
                credentials('Github-Creds') 
            } 
        } 
    }
    
    steps { 
        dsl { 
            external('${PATH_TO_JOB}') 
            removeAction('IGNORE') 
            } 
        }
}