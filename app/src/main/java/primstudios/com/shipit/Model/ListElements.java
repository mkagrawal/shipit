package primstudios.com.shipit.Model;

import java.util.Comparator;

public class ListElements implements Comparable<ListElements> {
	public int rank;
	public String username;
	public int score;
	public int wordCount;
	public String country;
	public String facebookId;
	
	
	public ListElements(int rank, String username, int score, int wordCount,
			String country, String facebookId) {
		super();
		this.rank = rank;
		this.username = username;
		this.score = score;
		this.wordCount = wordCount;
		this.country = country;
		this.facebookId = facebookId;
	}

	
	
	public String getFacebookId() {
		return facebookId;
	}



	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}



	public int getRank() {
		return rank;
	}

	public String getUsername() {
		return username;
	}

	public int getScore() {
		return score;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public int getWordCount() {
		return wordCount;
	}


	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}


	@Override
	public int compareTo(ListElements arg0) {
		// TODO Auto-generated method stub
		int compareQuantity = ((ListElements) arg0).getScore(); 
		 
		//ascending order
		return this.score - compareQuantity;
	}
	
	
	public static Comparator<ListElements> ScoreComparator
    				= new Comparator<ListElements>()
    	{
			@Override
			public int compare(ListElements le1, ListElements le2)
			{
				return le2.compareTo(le1);
			}
		};
}
