package wifilocator.signature;

public class Signature {
	private String ssId;
	private String bssId;
	private int level;
	private int frequency;
	private long timeStamp;
	
	/**
	 * Constructor function of Signature
	 * @author Eric Wang
	 * @param ssId
	 * @param bssId
	 * @param level
	 * @param frequency
	 */
	public Signature(String ssId,String bssId,int level, int frequency)
	{
		this.ssId=ssId;
		this.bssId=bssId;
		this.level=level;
		this.frequency=frequency;
	}
	
	/**
	 * Constructor function without parameters
	 * @author Eric Wang
	 */
	public Signature()
	{
		ssId="N/A";
		bssId="N/A";
		level=0;
		frequency=0;
	}
	
	/**
	 * Convert Signature to string
	 * @author Eric Wang
	 * @return signature of String form
	 */
	public String toString()
	{
		StringBuilder str=new StringBuilder();
		str.append(ssId).append(",").append(bssId).append(",").append(level).append(",").append(frequency).append("\r\n");
		return str.toString();
	}
	
	/**
	 * @author Eric Wang
	 * @return ssId
	 */
	public String getSSID()
	{
		return ssId;
	}
	
	/**
	 * @author Eric Wang
	 * @return bssId
	 */
	public String getBSSID()
	{
		return bssId;
	}
	
	/**
	 * @author Eric Wang
	 * @return level
	 */
	public int getLevel()
	{
		return level;
	}
	
	/**
	 * @author Eric Wang
	 * @return frequency
	 */
	public int getFrequency()
	{
		return frequency;
	}
}