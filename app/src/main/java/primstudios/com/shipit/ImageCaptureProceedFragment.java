package primstudios.com.shipit;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageCaptureProceedFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_capture_proceed, container, false);
    }

    @Override
    public void onStart(){

        super.onStart();
        ImageView im = (ImageView) getView().findViewById(R.id.capturedImage);
        im.setImageBitmap(GlobalVariables.getImage());
    }

    @Override
    public void onResume(){
        super.onResume();
        ImageView im = (ImageView) getView().findViewById(R.id.capturedImage);
        im.setImageBitmap(GlobalVariables.getImage());

    }
}