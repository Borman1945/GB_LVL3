package messenger.client.client_server.command;

import java.io.Serializable;

public class ErrorCommand implements Serializable {

    private final String errorMessage;

    public ErrorCommand(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
