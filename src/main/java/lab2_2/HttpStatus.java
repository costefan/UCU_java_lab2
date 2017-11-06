package lab2_2;

import lombok.Getter;

@Getter
public enum HttpStatus {
    INFORMATIONAL(1, "Informational", new InformationHandler()),
    SUCCESS(2, "Success", new SuccessHandler()),
    REDIRECTION(3, "Redirection", new RedirectionHandler()),
    CLIENT_ERROR(4, "Client Error", new ClientErrorHandler()),
    SERVER_ERROR(5, "Server Error", new ServerErrorHandler());

    private int httpCodeStartSymbol;
    private String httpStatus;
    private HttpHandler handler;

    HttpStatus(int httpCode, String httpCodeStartSymbol, HttpHandler handler) {
        this.httpCodeStartSymbol = httpCode;
        this.httpStatus = httpCodeStartSymbol;
        this.handler = handler;
    }

    public static HttpStatus findByStartSymbol(int startSymbol) {
        HttpStatus[] httpCodes = values();
        for (HttpStatus code: httpCodes) {
            if (code.httpCodeStartSymbol == startSymbol)
                return code;
        }
        throw new RuntimeException("Code with start symbol " + startSymbol + " was not found.");
    }

    public HttpHandler getHandler() {
        return this.handler;
    }

}
