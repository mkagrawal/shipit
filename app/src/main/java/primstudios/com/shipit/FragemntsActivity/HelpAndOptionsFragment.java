package primstudios.com.shipit.FragemntsActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import primstudios.com.shipit.R;

public class HelpAndOptionsFragment extends Fragment {
	
	ImageView imageView;
	public HelpAndOptionsFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_help_option, container, false);
        
        imageView = (ImageView)rootView.findViewById(R.id.myimageView);

         
        return rootView;
    }
}
