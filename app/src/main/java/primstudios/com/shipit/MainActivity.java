package primstudios.com.shipit;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import primstudios.com.shipit.Adapter.NavDrawerListAdapter;
import primstudios.com.shipit.FragemntsActivity.AboutFragment;
import primstudios.com.shipit.FragemntsActivity.HelpAndOptionsFragment;
import primstudios.com.shipit.FragemntsActivity.PricingFragment;
import primstudios.com.shipit.FragemntsActivity.TrackRequestFragment;
import primstudios.com.shipit.Model.NavDrawerItem;

public class MainActivity extends ActionBarActivity {
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private TextView userNameView;
    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
    private LinearLayout linearLayout;
    Context context;
    private static final int RESULT_LOAD_IMAGE = 2;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Fragment homeFragment;
    private Dialog shippingOptionDialogs;
    private Dialog dialog;


    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        context = this;

        setListView();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                //getActionBar().setTitle("Testing");
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                //getActionBar().setTitle("ACTIONBAR");
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };

        // Find the user's name view
        if (savedInstanceState == null) {
            // on first time display view for first nav item
            homeFragment = new ImageCaptureFragment();

            displayView(0);
        }


    }

    void setListView() {
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        for (int i = 0; i < navMenuTitles.length; i++) {
            NavDrawerItem items = new NavDrawerItem(navMenuTitles[i],navMenuIcons.getResourceId(i, -1));
            navDrawerItems.add(items);
        }
        // Recycle the typed array
        navMenuIcons.recycle();
        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
        adapter = new NavDrawerListAdapter(getApplicationContext(), navDrawerItems);
        mDrawerList.setAdapter(adapter);
    }


    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }

    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = homeFragment;
                break;
            case 1:
                fragment = new TrackRequestFragment();
                break;
            case 2:
                fragment = new PricingFragment();
                break;
            case 3:
                fragment = new HelpAndOptionsFragment();
                break;
            case 4:
                fragment = new AboutFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(linearLayout);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    // Image Capture Part

    public void snapAPicture(View v){
        dispatchTakePictureIntent();
    }

    public void loadImageFromGallery(View v){
        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                GlobalVariables.setImage(imageBitmap);
            }

            if (requestCode == RESULT_LOAD_IMAGE) {

                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                Bitmap imageBitMap = (BitmapFactory.decodeFile(imgDecodableString));
                GlobalVariables.setImage(imageBitMap);
            }
        }
        Fragment fr = new ImageCaptureProceedFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fr);
        fragmentTransaction.commit();
        homeFragment = fr;
    }

    public void backFromImageCaptureProceed(View v){
        Fragment fr = new ImageCaptureFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fr);
        fragmentTransaction.commit();
        homeFragment = fr;
    }

    public void nextFromImagecaptureProceed(View v){
        Fragment fr = new PickUpFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fr);
        fragmentTransaction.commit();
        homeFragment = fr;
    }

    public void backFromPickUp(View v){

        Fragment fr = new ImageCaptureProceedFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fr);
        fragmentTransaction.commit();
        homeFragment = fr;
    }

    public void nextFromPickUp(View v){
        Fragment fr = new DestinationFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fr);
        fragmentTransaction.commit();
        homeFragment = fr;
    }

    public void backFromDestination(View v){

        Fragment fr = new PickUpFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fr);
        fragmentTransaction.commit();
        homeFragment = fr;
    }

    public void nextFromDestination(View v){
        Fragment fr = new ItemDescriptionFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fr);
        fragmentTransaction.commit();
        homeFragment = fr;
    }

    public void changeShippingDetails(View v){
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCanceledOnTouchOutside(false);
        dialog.onBackPressed();
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.fragment_shipping_options);
        TextView oktv =(TextView)dialog.findViewById(R.id.okButton);
        dialog.show();
        oktv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView shippingDetailsTextView = (TextView)findViewById(R.id.shipingOptionDetails);
                switch(GlobalVariables.getSelectedShippingOption()){
                    case 1:
                        shippingDetailsTextView.setText(R.string.standard_option_heading);
                        break;
                    case 2:
                        shippingDetailsTextView.setText(R.string.quick_option_heading);
                        break;
                }
                dialog.cancel();
                dialog.dismiss();
            }
        });

        RadioButton rbStandard =(RadioButton)dialog.findViewById(R.id.shippingOptionStandard);
        RadioButton rbQuick =(RadioButton)dialog.findViewById(R.id.shippingOptionQuick);
        final TextView shippingDetailText = (TextView)dialog.findViewById(R.id.shippingOptionDetails);
        dialog.show();
        rbStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shippingDetailText.setText(R.string.standard_option_detail);
                GlobalVariables.setSelectedShippingOption(1);
            }
        });

        rbQuick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shippingDetailText.setText(R.string.quick_option_detail);
                GlobalVariables.setSelectedShippingOption(2);
            }
        });
        dialog.show();
    }

    public void onConfirm(View v){
        Fragment fr = new ThanksFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fr);
        fragmentTransaction.commit();
        homeFragment = fr;
    }

    public void goNewRequestFromThanks(View v){
        Fragment fr = new ImageCaptureFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fr);
        fragmentTransaction.commit();
        homeFragment = fr;
    }

    public void goTrackFromThanks(View v){
        Fragment fr = new TrackRequestFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fr);
        fragmentTransaction.commit();
        homeFragment = new ImageCaptureFragment();
    }

    public void exitFromThanks(View v){
        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
        super.onDestroy();
    }

    public void nextFromDetails(View v) {
        Fragment fr = new ConfirmationFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fr);
        fragmentTransaction.commit();
        homeFragment = fr;
    }

    public void backFromDetails(View v) {
        Fragment fr = new DestinationFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fr);
        fragmentTransaction.commit();
        homeFragment = fr;
    }





}