package content

import Project.Project
import Task.Task

class ContentController {

    static defaultAction = "projectList"

    def beforeInterceptor = [action: this.&auth]

    def auth(){
        if (!session.user){
            redirect(controller: "user", action: "login")
            return false
        }
    }

    def projectList() {
        [projects: Project.findAll()]
    }
}
