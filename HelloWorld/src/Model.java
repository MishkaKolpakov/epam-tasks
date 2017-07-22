public class Model {
	private String firstWord;
	private String secondWord;
	private String sentence;
	
	public String getFirstWord() {
		return firstWord;
	}
	public void setFirstWord(String firstWord) {
		this.firstWord = firstWord;
	}
	public String getSecondWord() {
		return secondWord;
	}
	public void setSecondWord(String secondWord) {
		this.secondWord = secondWord;
	}
	
	/**
	*In this method the process of concatenation of first and second words
	*@param firstWord, secondWord
	*@return sentence
	*/
	public String concatenation(String firstWord, String secondWord) {
		return firstWord + " " + secondWord;
	}
		
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
}
