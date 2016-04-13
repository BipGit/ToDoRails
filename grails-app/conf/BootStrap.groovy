import Task.Task
import Project.Project

class BootStrap {

    def init = { servletContext ->
        def user1 = new User.User(email:"Grut@gmail.com", password:"123456", name:"Viktor").save(flush: true)

        def project1 = new Project(projectName: "firstProject", priority: Project.count()+1, user: user1)

        def taskOne = new Task(subject:"firstTaskSubjName", finishDate: new Date(), priority: Task.count()+1).save(flush: true)
        def taskTwo = new Task(subject:"firstTaskSubjName2", finishDate: new Date(), priority: Task.count()+1).save(flush: true)

        project1.addToTasks(taskOne).save(flush: true)
        project1.addToTasks(taskTwo).save(flush: true)

        def project2 = new Project(projectName: "secondProject", priority: Project.count()+1, user: user1)
        def taskThree = new Task(subject:"firstTaskSubjName", finishDate: new Date(), priority: Task.count()+1).save(flush: true)
        def taskFour = new Task(subject:"firstTaskSubjName2", finishDate: new Date(), priority: Task.count()+1).save(flush: true)
        project2.addToTasks(taskThree).save(flush: true)
        project2.addToTasks(taskFour).save(flush: true)

    }
    def destroy = {
    }
}
