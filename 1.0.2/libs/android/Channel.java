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
		/// rcv_len: set rcv_buf max size to receiver, when it return, it be set by really receive length.
	static public native int ack(String fr, String to, int params, byte[] buf, int len, int timeout_ms);
	
	
	//////////////////////////////////////////////////////////////////////////
	// node channel asynchronous communication interface.
	static public native int post(String fr, String to, byte[] buf, int len, int timeout_ms);
	static public native int get(int[] type, int[] params, byte[] fr, int[] fr_len, byte[] to, int[] to_len, byte[] buf, int[] buf_len, int timeout_ms);
		/// fr_len, to_len, buf_len: set buffer max size to receiver, when function return, it be set by really buffer length.
	    /// Type_Chl_Post = 1,
	    /// Type_Chl_Send = 2,
	    /// Type_Chl_Online = 3,
	    /// Type_Chl_Offline = 4,
	    /// Type_Chl_Join = 5,
	    /// Type_Chl_ReJoin = 6,
	    /// Type_Chl_Abort = 7
    
    
	//////////////////////////////////////////////////////////////////////////
	// the version of sdk.
	static public native String version();

   
	//////////////////////////////////////////////////////////////////////////
	// load library.
	static {
		System.loadLibrary("PLinkChannel4j");
	} 
}
