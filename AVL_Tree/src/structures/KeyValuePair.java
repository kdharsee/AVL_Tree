package structures;

/**
 * This class encapsulates a (key, value) pair, where the key is an integer
 * and the value is a string.
 * 
 * @author RU NB CS112
 *
 */
public class KeyValuePair {
	
	/**
	 * Key
	 */
	public int key;
	
	/**
	 * Value
	 */
	public String value;
	
	/**
	 * Initializes to given (key,value) pair
	 * 
	 * @param key Key
	 * @param value Value
	 */
	public KeyValuePair(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o == null || !(o instanceof KeyValuePair)) {
			return false;
		}
		KeyValuePair other = (KeyValuePair)o;
		return key == other.key;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "(" + key + "," + value + ")";
	}
}

