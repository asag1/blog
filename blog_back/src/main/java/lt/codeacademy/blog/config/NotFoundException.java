package lt.codeacademy.blog.config;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
