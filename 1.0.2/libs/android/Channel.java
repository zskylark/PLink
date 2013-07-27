/********************************************************************
	created:	2013/03/24
	created:	24:3:2013   15:06
	filename: 	PLink\Channel4j\NodeChannel4j.java
	file path:	PLink\Channel4j
	file base:	NodeChannel4j
	file ext:	java
	author:		
	
	purpose:	
*********************************************************************/

package PLink.Channel4j;


public class Channel {
	//////////////////////////////////////////////////////////////////////////
	// node channel init.
	static public native boolean initialize();
	static public native boolean release();
	
	
	//////////////////////////////////////////////////////////////////////////
	// node channel management interface.
	static public native int open(String chan, int heartbeat_ms);
	    /// open ephemeral channel.
	    /// return 0x00010001 : channel has opened.
	    /// return 0x00010002 : channel name is too long, max size: 8 bytes.
	
	static public native int openEx(String chan);
	    /// open persistent channel.
	
	static public native void close(String chan);
	
	static public native int connect(String chan, String switch_addr, int timeout_ms);
	    /// return 0x00020001 : channel had connected. please reconnect.
	
	static public native int reconnect(String chan, int timeout_ms);
	static public native int disconnect(String chan);
	
	static public native void abort(String chan);
	
	
	//////////////////////////////////////////////////////////////////////////
	// node channel heartbeat management interface.
	static public native int heartbeat(String chan, int timeout_ms);
	    /// if channel is persistent, heartbeat only link detection.
	
	
	//////////////////////////////////////////////////////////////////////////
	// node channel synchronous communication interface.
	static public native int send(String fr, String to, byte[] snd_buf, int snd_len, byte[] rcv_buf, int[] rcv_len, int timeout_ms);
	
	
	//////////////////////////////////////////////////////////////////////////
	// node channel asynchronous communication interface.
	static public native int post(String fr, String to, byte[] buf, int len, int timeout_ms);
    
    
	//////////////////////////////////////////////////////////////////////////
	// the version of sdk.
	static public native String version();

   
	//////////////////////////////////////////////////////////////////////////
	// load library.
	static {
		System.loadLibrary("PLinkChannel4j");
	} 
}
