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


public class ItemDescriptionFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {

            return inflater.inflate(
                    R.layout.fragment_item_description, container, false);
        }

    @Override
    public void onStart(){
        super.onStart();
        addTextChangeListeners();

    }

    private void addTextChangeListeners(){
        addListener((TextView)getView().findViewById(R.id.itemNameEditText));
        addListener((TextView)getView().findViewById(R.id.itemWeightEditText));
        addListener((TextView)getView().findViewById(R.id.itemDetailsEditText));
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
                    case R.id.itemNameEditText:
                        GlobalVariables.setItemName(s.toString());
                        Log.d("PickUPName", GlobalVariables.getDestinationName());
                        break;
                    case R.id.itemWeightEditText:
                        GlobalVariables.setItemWeight(s.toString());
                        break;
                    case R.id.itemDetailsEditText:
                        GlobalVariables.setItemDetails(s.toString());
                        break;
                }

            }
        });

    }




}
