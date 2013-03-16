package mfmock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 * 
 */
public class ImsConnectMock {
	
	/**
	 * Private constructor to assert API clients should call the factory method
	 * "getConnection()" to communicate.
	 */
	private ImsConnectMock() {
		super();
	}
	
	/**
	 * Private constructor to assert API clients should call the factory method
	 * "getConnection()" to communicate.
	 */
	private ImsConnectMock(ClassLoader classLoader) {
		super();
	}

	/**
	 * FactoryMethod that returns an instance of the class
	 * 
	 * @return
	 */
	public static ImsConnectMock getConnection() {
		return new ImsConnectMock();
	}

	public String call(String inputTrancode) {
		if (inputTrancode.length() < 8) {
			throw new IllegalArgumentException(
					"Input String is too short (lower than 8 characteres).");
		}

		BufferedReader imsCallResultStream = new BufferedReader(
				new InputStreamReader(
						getClass().getClassLoader().getResourceAsStream(inputTrancode.substring(0, 8).trim() + ".tranc")));
		String imsCallResult = "";
		String line;
		try {
			while ((line = imsCallResultStream.readLine()) != null) {
				imsCallResult += line;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imsCallResult;
	}

}