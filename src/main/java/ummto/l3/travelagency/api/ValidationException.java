package ummto.l3.travelagency.api;

public class ValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private int codeHttp;
	private String desc;

	public ValidationException(String id, int httpCode, String message) {
		super();
		this.id = id;
		this.codeHttp = httpCode;
		this.desc = message;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public ValidationException() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getHttpCode() {
		return codeHttp;
	}

	public void setHttpCode(int httpCode) {
		this.codeHttp = httpCode;
	}

}
