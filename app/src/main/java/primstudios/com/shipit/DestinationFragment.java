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

public class DestinationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destination, container, false);
    }

    @Override
    public void onStart(){

        super.onStart();
        addTextChangeListeners();

    }

    private void addTextChangeListeners(){
        addListener((TextView)getView().findViewById(R.id.dname));
        addListener((TextView)getView().findViewById(R.id.dflatNo));
        addListener((TextView)getView().findViewById(R.id.dApartmentName));
        addListener((TextView)getView().findViewById(R.id.dCity));
        addListener((TextView)getView().findViewById(R.id.dState));
        addListener((TextView)getView().findViewById(R.id.dZipCode));
        addListener((TextView)getView().findViewById(R.id.dphoneno));


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
                    case R.id.dname:
                        GlobalVariables.setDestinationName(s.toString());
                        Log.d("PickUPName", GlobalVariables.getDestinationName());
                        break;
                    case R.id.dflatNo:
                        GlobalVariables.setDestinationFlatnumber(s.toString());
                        break;
                    case R.id.dApartmentName:
                        GlobalVariables.setDestinationApartment(s.toString());
                        break;
                    case R.id.dCity:
                        GlobalVariables.setDestinationCity(s.toString());
                        break;
                    case R.id.dState:
                        GlobalVariables.setDestinationSate(s.toString());
                        break;
                    case R.id.dZipCode:
                        GlobalVariables.setDestinationPostalCode(s.toString());
                        break;
                    case R.id.dphoneno:
                        GlobalVariables.setDestinationContactNumber(s.toString());
                        break;
                }
            }
        });
    }
}