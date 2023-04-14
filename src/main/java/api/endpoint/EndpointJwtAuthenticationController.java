package api.endpoint;

public class EndpointJwtAuthenticationController {
    public static class Post {
        public static String createAuthenticationToken(){
            return "/api/login";
        }

    }
}
