package Task

import Project.Project

class Task {
    String subject
    Date finishDate
    Boolean isCompleted = false
    Integer priority //= Task.count()+1

    static belongsTo = [project: Project]

    static constraints = {
        subject(blank: false, nullable: false)
        finishDate(min: new Date(), nullable: false)
        project(nullable: true)
    }

    String toString() {
        subject
    }

}
