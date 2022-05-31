package my.jmbi.services.visitorsextension.health;

// @JsonIgnoreProperties(value={})
public class HealthCheck {

    // @JsonIgnore
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HealthCheck(String message) {
        this.message = message;
    }
}
