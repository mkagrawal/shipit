package primstudios.com.shipit;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.ImageView;


public class ShipItemActivity extends Activity {

    static final int RESULT_LOAD_IMAGE = 2;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private String selectedImagePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_item);

    }

    public void selectFrag(View view) {

        Fragment fr;

        if(view == findViewById(R.id.step1)) {
            fr = new ImageCaptureFragment();

        }else if(view == findViewById(R.id.step2)){
            fr = new ItemDescriptionFragment();
        }
        else{
            fr = new AddressFragment();

        }
        Log.d("Id", "Hello");
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

    }

    public void goNext1(View v){
        Fragment fr = new ItemDescriptionFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();
    }

    public void goNext2(View v){
        Fragment fr = new AddressFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();
    }

    public void snapApicture(View v){
        dispatchTakePictureIntent();
    }

    public void loadImagefromGallery(View v){
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
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView mImageView = (ImageView) findViewById(R.id.imgView);
            mImageView.setImageBitmap(imageBitmap);
        }

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK) {
            if (requestCode == RESULT_LOAD_IMAGE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                System.out.println("Image Path : " + selectedImagePath);
                ImageView mImageView = (ImageView) findViewById(R.id.imgView);
                mImageView.setImageURI(selectedImageUri);
            }
        }
    }


    public String getPath(Uri uri) {

        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

}
