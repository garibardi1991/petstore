package api.endpoint;

public class EndpointUserController {
    public static class Post {
        public static String register() {
            return "/api/register";
        }

    }

    public static class Delete {
        public static String user() {
            return "/api/user";
        }

    }

    public static class Get {
        public static String user() {
            return "/api/user";
        }

    }

}
