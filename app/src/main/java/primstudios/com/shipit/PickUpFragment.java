package primstudios.com.shipit;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PickUpFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pick_up, container, false);
    }

    @Override
    public void onStart(){

        super.onStart();
        addTextChangeListeners();
       // ImageView im = (ImageView) getView().findViewById(R.id.capturedImage);
       // im.setImageBitmap(GlobalVariables.getImage());
    }

    private void addTextChangeListeners(){
        addListener((TextView)getView().findViewById(R.id.sname));
        addListener((TextView)getView().findViewById(R.id.sflatNo));
        addListener((TextView)getView().findViewById(R.id.sApartmentName));
        addListener((TextView)getView().findViewById(R.id.sCity));
        addListener((TextView)getView().findViewById(R.id.sState));
        addListener((TextView)getView().findViewById(R.id.sZipCode));
        addListener((TextView)getView().findViewById(R.id.sphoneno));


    }

    private void addListener(final TextView tv ){

        tv.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // do whatever you need to do HERE.
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                switch (tv.getId()) {
                    case R.id.sname:
                        GlobalVariables.setPickUpName(s.toString());
                        Log.d("PickUPName", GlobalVariables.getPickUpName());
                        break;
                    case R.id.sflatNo:
                        GlobalVariables.setPickUpFlatnumber(s.toString());
                        break;
                    case R.id.sApartmentName:
                        GlobalVariables.setPickUpApartment(s.toString());
                        break;
                    case R.id.sCity:
                        GlobalVariables.setPickUpCity(s.toString());
                        break;
                    case R.id.sState:
                        GlobalVariables.setPickUpSate(s.toString());
                        break;
                    case R.id.sZipCode:
                        GlobalVariables.setPickUpPostalCode(s.toString());
                        break;
                    case R.id.sphoneno:
                        GlobalVariables.setPickUpContactNumber(s.toString());
                        break;

                }

            }
        });

    }

}