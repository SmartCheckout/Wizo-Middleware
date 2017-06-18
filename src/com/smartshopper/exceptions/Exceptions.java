package com.smartshopper.exceptions;

public class Exceptions{
	
	public static class DataValidationException extends Exception{
		private static final long serialVersionUID = 1L;
		
		public DataValidationException(String message){
			super(message);
		}
	}
	public static class UserNotFoundException extends Exception{
		private static final long serialVersionUID = 1L;
		
		public UserNotFoundException(String message){
			super(message);
		}

	}
	public static class ProductNotFoundException extends Exception{
		private static final long serialVersionUID = 1L;
		
		public ProductNotFoundException(String message){
			super(message);
		}
	}
	
	public static class NoStoreFoundException extends Exception{
		private static final long serialVersionUID = 1L;
		
		public NoStoreFoundException(String message){
			super(message);
		}
	}
	
	public static class MoreStoresFoundException extends Exception{
		private static final long serialVersionUID = 1L;
		
		public MoreStoresFoundException(String message){
			super(message);
		}
	}
}
