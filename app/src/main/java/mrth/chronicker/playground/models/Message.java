package mrth.chronicker.playground.models;

public class Message {
    private Integer id;
    private String message;

    public Message(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
