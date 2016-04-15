package Project

import Task.Task
import User.User

class Project {
    String projectName
    Integer priority
    User user

    static mapping = {
        tasks sort: 'priority', order: 'asc'
    }

    static hasMany = [tasks: Task]
    static hasOne = [user: User]

    static constraints = {
        projectName(blank: false, nullable: false)
        priority(min: 1)
        tasks(unique: false)
    }

    String toString() {
        String projectStringInstance = "Project#$id("+ "$projectName tasks: ["
        tasks.each {
            projectStringInstance += "taskID#$it.id " +it.subject+"priority:" + it.priority +";"
        }
        projectStringInstance += "]"

        projectStringInstance
    }
}
