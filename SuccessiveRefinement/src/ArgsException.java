
public class ArgsException extends Exception {
	private char errorArgumentId = '\0';
	private String errorParameter = null;
	private ErrorCode errorCode = OK;
	
	public ArgsException() {}
	
	public ArgsException(String message) {super(message);}
	
	public ArgsException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public ArgsException(ErrorCode errorCode, String errorParameter) {
		this.errorCode = errorCode;
		this.errorParameter = errorParameter;
	}

	public ArgsException(char errorArgumentId, String errorParameter, ErrorCode errorCode) {
		super();
		this.errorArgumentId = errorArgumentId;
		this.errorParameter = errorParameter;
		this.errorCode = errorCode;
	}

	public char getErrorArgumentId() {
		return errorArgumentId;
	}

	public void setErrorArgumentId(char errorArgumentId) {
		this.errorArgumentId = errorArgumentId;
	}

	public String getErrorParameter() {
		return errorParameter;
	}

	public void setErrorParameter(String errorParameter) {
		this.errorParameter = errorParameter;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public String errorMessage() {
		switch(errorCode) {
		case OK: 
			return "TILT: Should not get here";
		case UNEXPECTED_ARGUMENT:
			return String.format("Argument unexpected", errorArgumentId);
		case MISSING_STRING:
			return String.format("Argument expects an integer but was String", errorArgumentId, errorParameter);
		case INVALID_INTEGER:
			return String.format("Argument expects an integer but was '%s' ", errorArgumentId, errorParameter);
		case MISSING_INTEGER:
			return String.format("Could not find Integer parameter", errorArgumentId);
		case INVALID_DOUBLE:
			return String.format("Argument expects a double but was '%s'", errorArgumentId, errorParameter);
		case MISSING_DOUBLE:
			return String.format("Could not find double parameter", errorArgumentId);
		case INVALID_ARGUMENT_NAME:
			return String.format("Not a valid argument name", errorArgumentId);
		case INVALID_ARGUMENT_FORMAT:
			return String.format("Not a valid argument format", errorParameter);
		}
		return "";
	}
	
	public enum ErrorCode {
		OK, INVALID_ARGUMENT_FORMAT, UNEXPECTED_ARGUMENT, INVALID_ARGUMENT_NAME, 
		MISSING_STRING, MISSING_INTEGER, INVALID_INTEGER, MISSING_DOUBLE, INVALID_DOUBLE
	}

}
