package User

class UserController {

    def login() {}

    def auth = {
        def currentUser = User.findByEmailAndPassword(params.inputEmail, params.inputPassword)
        if (currentUser){
            session.user = currentUser
            flash.message = "Hello, $currentUser.name"
            redirect(controller: "content")
        }
        else {
            flash.message = "Login or password are incorrect. Try again"
            redirect(action: "login")
        }
    }

    def logout(){
        flash.message = "Bye, ${session.user.name}"
        session.user = null
        redirect(action: "login")
    }
}
