package pl.wiktor.model;

import org.joda.time.DateTime;

public class LogModel {

    private String hashId;
    private ErrorType type;
    private DateTime callDate;
    private String origin;
    private String logFileDetails;
    private String message;
    private String stackTrace;

    public LogModel(String hashId, ErrorType type, DateTime callDate, String origin, String logFileDetails, String message, String stackTrace) {
        this.hashId = hashId;
        this.type = type;
        this.callDate = callDate;
        this.origin = origin;
        this.logFileDetails = logFileDetails;
        this.message = message;
        this.stackTrace = stackTrace;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public ErrorType getType() {
        return type;
    }

    public void setType(ErrorType type) {
        this.type = type;
    }

    public DateTime getCallDate() {
        return callDate;
    }

    public void setCallDate(DateTime callDate) {
        this.callDate = callDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLogFileDetails() {
        return logFileDetails;
    }

    public void setLogFileDetails(String logFileDetails) {
        this.logFileDetails = logFileDetails;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @Override
    public String toString() {
        return "LogModel{" +
                "hashId='" + hashId + '\'' +
                ", type=" + type +
                ", callDate=" + callDate +
                ", origin='" + origin + '\'' +
                ", logFileDetails='" + logFileDetails + '\'' +
                ", message='" + message + '\'' +
                ", stackTrace='" + stackTrace + '\'' +
                '}';
    }
}
