package primstudios.com.shipit.Model;

public class WordElement{
	public String word;
	public int score;
		public WordElement(String text,int id)
		{
			word = text; 
			score = id;
		}
		public String getword() {
			return word;
		}
		public int getscore() {
			return score;
		}
		public void setword(String word) {
			this.word = word;
		}
		public void setscore(int score) {
			this.score = score;
		}
		
		
}
