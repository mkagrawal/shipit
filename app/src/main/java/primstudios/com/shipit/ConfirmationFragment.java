package primstudios.com.shipit;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ConfirmationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        ImageView im = (ImageView) getView().findViewById(R.id.finalcapturedImage);
        im.setImageBitmap(GlobalVariables.getImage());
    }
}