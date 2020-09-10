import java.util.Arrays;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Rhys Banerjee
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for(int i=0;i<size;i++){
			myWords[i] = source[start+i];
		}
		myToString = null;
		myHash = 0;

		// TODO: initialize all instance variable
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return length of myWords
	 */
	public int length(){
		//returns length of myWords
		return myWords.length;
	}


	/**
	 * Complete appropriate comment here
	 * @param o = object placeholder for a WordGram parameter.
	 * @return whether each element in both lists are equal.
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		// TODO: Complete this method
		WordGram wg = (WordGram) o;
		return Arrays.equals(myWords, wg.myWords);
	}

	@Override
	public int hashCode(){
		// If hasn't been assigned, make a new hashcode.
		if(myHash == 0){
			myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return elements of list of the same size with new word added at the very end.
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		for(int i =1;i<myWords.length;i++){
			wg.myWords[i-1]=this.myWords[i];
		}
		wg.myWords[wg.length() - 1] = last;
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method, assign to myToString as needed
		if(myToString == null){
			myToString = String.join(" ",myWords);
		}
		return myToString;
	}
}
