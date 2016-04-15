import Task.Task
import Project.Project

class BootStrap {

    def init = { servletContext ->
        def user1 = new User.User(email:"Grut@gmail.com", password:"123456", name:"Viktor").save(flush: true)

        def project1 = new Project(projectName: "firstProject", priority: Project.count()+1, user: user1)

        def taskOne = new Task(subject:"firstTaskSubjName", finishDate: new Date(), priority: 1).save(flush: true)
        project1.addToTasks(taskOne).save(flush: true)
        def taskTwo = new Task(subject:"firstTaskSubjName2", finishDate: new Date(), priority: project1.tasks.size()+1).save(flush: true)
        project1.addToTasks(taskTwo).save(flush: true)
        def task1 = new Task(subject:"firstTaskSubjName1111111111111", finishDate: new Date(), priority: project1.tasks.size()+1).save(flush: true)
        project1.addToTasks(task1).save(flush: true)
        def task11 = new Task(subject:"firstTaskSubjName222222222222", finishDate: new Date(), priority: project1.tasks.size()+1).save(flush: true)
        project1.addToTasks(task11).save(flush: true)
        def task12 = new Task(subject:"firstTaskSubjName666666666666", finishDate: new Date(), priority: project1.tasks.size()+1).save(flush: true)
        project1.addToTasks(task12).save(flush: true)


        def project2 = new Project(projectName: "secondProject", priority: Project.count()+1, user: user1)
        def taskThree = new Task(subject:"firstTaskSubjName", finishDate: new Date(), priority: 1).save(flush: true)
        project2.addToTasks(taskThree).save(flush: true)
        def taskFour = new Task(subject:"firstTaskSubjName2", finishDate: new Date(), priority: project2.tasks.size()+1).save(flush: true)
        project2.addToTasks(taskFour).save(flush: true)

    }
    def destroy = {
    }
}
