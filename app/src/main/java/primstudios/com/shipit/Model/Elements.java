package primstudios.com.shipit.Model;

public class Elements{
	public String text1;
	public int color_id;
		public Elements(String text,int id)
		{
			text1 = text; 
			color_id = id;
		}
		public String getText1() {
			return text1;
		}
		public int getColor_id() {
			return color_id;
		}
		public void setText1(String text1) {
			this.text1 = text1;
		}
		public void setColor_id(int color_id) {
			this.color_id = color_id;
		}
		
		
}
