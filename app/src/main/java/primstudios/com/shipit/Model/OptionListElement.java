package primstudios.com.shipit.Model;

public class OptionListElement {

	public String title;
	public String subtitle;
	public int icon;

	public OptionListElement(String title,String subtitle, int icon) {
		this.title = title;
		this.subtitle = subtitle;
		this.icon = icon;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	
}
