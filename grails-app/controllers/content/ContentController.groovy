package content

import Project.Project
import Task.Task

class ContentController {

    static defaultAction = "projectList"

    def beforeInterceptor = [action: this.&auth]

    def auth() {
        if (!session.user) {
            redirect(controller: "user", action: "login")
            return false
        }
    }

    def projectList() {
        [projects: Project.findAll()]
    }

    def increaseTaskPriority() {
        String projectID = params.projectID
        String taskID = params.taskID

        def currentProject = Project.findById(projectID)
        def currentTask = Task.findByIdAndProject(taskID, currentProject)
        println "increasing"
        println currentProject
        println currentTask

        currentProject.projectName = "NewProjectName"

        if (currentTask) {
            def taskForChange = Task.findByPriorityAndProject(currentTask.priority - 1, currentProject)
            if (taskForChange){
                currentTask.priority = currentTask.priority - 1
                currentTask.save(flush: true)
                taskForChange.priority = taskForChange.priority + 1
                taskForChange.save(flush: true)
                currentProject.save(flush: true)
                println Project.findById(currentProject.id)
                println Project.findAll()
            }
        } else
            response.sendError(404, "")

        redirect(action: "projectList")

    }

    def decreaseTaskPriority() {
        String projectID = params.projectID
        String taskID = params.taskID

        def currentProject = Project.findById(projectID)
        def currentTask = Task.findByIdAndProject(taskID, currentProject)

        println "decreasing"
        println currentProject
        println currentTask

        currentProject.projectName = "NewProjectName"

        if (currentTask) {
            def taskForChange = Task.findByPriorityAndProject(currentTask.priority + 1, currentProject)
            if (taskForChange){
                currentTask.priority = currentTask.priority + 1
                currentTask.save(flush: true)
                taskForChange.priority = taskForChange.priority - 1
                taskForChange.save(flush: true)
                currentProject.save(flush: true)
                println Project.findById(currentProject.id)
                println Project.findAll()
            }
            redirect(action: "projectList")
        } else
            response.sendError(404, "")

    }
}
