package primstudios.com.shipit.Model;

import java.util.Comparator;

public class LetterElement implements Comparable<LetterElement> 
{
	int charPos;
	double freqWet;
	public int getCharPos() {
		return charPos;
	}
	public double getFreqWet() {
		return freqWet;
	}
	public void setCharPos(int charPos) {
		this.charPos = charPos;
	}
	public void setFreqWet(double freqWet) {
		this.freqWet = freqWet;
	}
	public LetterElement(int charPos, double freqWet) {
		super();
		this.charPos = charPos;
		this.freqWet = freqWet;
	}
	
	@Override
	public int compareTo(LetterElement arg0) {
		// TODO Auto-generated method stub
		double compareQuantity = this.freqWet - ((LetterElement) arg0).getFreqWet(); 
		 
		//ascending order
		return (int)(this.freqWet - compareQuantity);
	}
	
	
	public static Comparator<LetterElement> ScoreComparator
    				= new Comparator<LetterElement>()
    	{
			@Override
			public int compare(LetterElement le1, LetterElement le2)
			{
				return le2.compareTo(le1);
			}
		};
	
}
