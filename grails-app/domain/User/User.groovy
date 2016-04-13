package User

import Project.Project

class User {
    String email
    String password
    String name

    static hasMany = [projects: Project]

    static constraints = {
        email(nullable: false, blank: false, unique: true, email:true)
        password(blank: false, nullable: false, password:true)
        name()
    }

    String toString(){
        name
    }
}
