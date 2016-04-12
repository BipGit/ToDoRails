package User

class User {
    String email
    String password
    String name

    static constraints = {
        email(nullable: false, blank: false, unique: true, email:true)
        password(blank: false, nullable: false, password:true)
        name()
    }

    String toString(){
        name
    }
}
