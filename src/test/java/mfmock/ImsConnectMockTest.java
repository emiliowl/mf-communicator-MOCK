package mfmock;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for {@link ImsConnectMock} class
 */
public class ImsConnectMockTest {
	
	@Test
	public void shouldLocateResponseFileByFirst8BytesOfReceivedString() {
		String result = ImsConnectMock.getConnection().call("TRANC01 HERE_STARTS_THE_TRANC_PARAMETERS");
		assertEquals(result, "TRANC01 CALLED WITH SUCCESS ");
		
		String result2 = ImsConnectMock.getConnection().call("TRANC02 HERE_STARTS_THE_TRANC_PARAMETERS");
		assertEquals(result2, "TRANC02 CALLED WITH SUCCESS ");
	}
	
}