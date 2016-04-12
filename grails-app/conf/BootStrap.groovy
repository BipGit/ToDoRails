class BootStrap {

    def init = { servletContext ->
        new User.User(email:"Grut@gmail.com", password:"123456", name:"Viktor").save(flush: true)
//        def user = new User()
    }
    def destroy = {
    }
}
