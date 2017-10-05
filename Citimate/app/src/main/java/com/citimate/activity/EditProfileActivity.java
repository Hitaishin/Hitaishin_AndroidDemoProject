package com.citimate.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.citimate.R;
import com.citimate.constant.CommonUtility;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.zelory.compressor.Compressor;
import id.zelory.compressor.FileUtil;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back_button, iv_open_camera, imageView;
    private TextView tvEditProfile;
    private EditText etUserName, etEmail, etPhone, etAboutMe;
    private String picturePath = "", encodedImage = "";
    private Spinner spinner_gender;
    private ArrayAdapter adapter;
    private static int pos;
    int index;
    private File actualImage, compressedImage, file;
    private Uri fileURI1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        initialization();
        spinner();
    }

    //    Views id Initialize Method
    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }


//        EditText Id
        etUserName = (EditText) findViewById(R.id.etUserName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAboutMe = (EditText) findViewById(R.id.etAboutMe);
        tvEditProfile = (TextView) findViewById(R.id.tvEditProfile);

//        ImageView Id
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);
        iv_open_camera = (ImageView) findViewById(R.id.iv_open_camera);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setVisibility(View.GONE);

//        Spinner Id
        spinner_gender = (Spinner) findViewById(R.id.spinner_gender);

//        Click Listener
        tvEditProfile.setOnClickListener(this);
        iv_back_button.setOnClickListener(this);
        iv_open_camera.setOnClickListener(this);
    }

    public void spinner() {
        String[] gender = new String[]{"Select Gender", "Male", "Female"};
        final List<String> genderList = new ArrayList<>(Arrays.asList(gender));

        // Initializing an ArrayAdapter
        adapter = new ArrayAdapter(this, R.layout.spinner_item_et, genderList) {

            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        index = Arrays.asList(gender).indexOf(CommonUtility.getGlobalString(EditProfileActivity.this, "gender"));

        spinner_gender.setAdapter(adapter);
        spinner_gender.setSelection(index);
        spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                pos = i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //    Choose Image From Gallery or Camera
    private void selectImage() {
        isStoragePermissionGranted();
        final CharSequence[] options = {"Take Photo", "Choose from Library", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(EditProfileActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                    fileURI1 = Uri.fromFile(f);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, fileURI1);
                    startActivityForResult(intent, 1);
                } else if (options[item].equals("Choose from Library")) {

                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);//
                    startActivityForResult(intent, 2);

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    //    Marshmallow Permission
    private boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tvEditProfile:
                finish();
                break;

            case R.id.iv_back_button:
                finish();
                break;

            case R.id.iv_open_camera:
                selectImage();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    String imageFilePath = CommonUtility.getPath(this, fileURI1);
                    file = new File(imageFilePath);
                    Uri uri = Uri.fromFile(customCompressImage(file));
                    picturePath = CommonUtility.getPath(EditProfileActivity.this, uri);


                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

                    bitmap = BitmapFactory.decodeFile(picturePath,
                            bitmapOptions);

                    iv_open_camera.setImageBitmap(bitmap);
                    imageView.setVisibility(View.VISIBLE);

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
                    byte[] b = baos.toByteArray();
                    encodedImage = Base64.encodeToString(b, Base64.DEFAULT);

                    String path = android.os.Environment
                            .getExternalStorageDirectory()
                            + File.separator
                            + "Phoenix" + File.separator + "default";
                    f.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (requestCode == 2) {
                Bitmap bitmap = null;
                if (data != null) {
                    try {
                        actualImage = FileUtil.from(this, data.getData());
                        Uri uri = Uri.fromFile(customCompressImage(actualImage));
                        picturePath = CommonUtility.getPath(EditProfileActivity.this, uri);


                        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

                        bitmap = BitmapFactory.decodeFile(picturePath,
                                bitmapOptions);


                        Log.e("BITMAP", "" + bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                iv_open_camera.setImageBitmap(bitmap);
                imageView.setVisibility(View.VISIBLE);

                try {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 10, baos); //bm is the bitmap object
                    byte[] b = baos.toByteArray();
                    encodedImage = Base64.encodeToString(b, Base64.DEFAULT);

                } catch (Exception e) {

                    Toast.makeText(EditProfileActivity.this, "Please select another image", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    //    Image Compressor Method
    public File customCompressImage(File file) {
        if (file == null) {
            showError("Please choose an image!");
        } else {
            // Compress image in main thread using custom Compressor
            compressedImage = new Compressor.Builder(this)
                    .setMaxWidth(640)
                    .setMaxHeight(480)
                    .setQuality(100)
                    .setCompressFormat(Bitmap.CompressFormat.WEBP)
                    .setDestinationDirectoryPath(Environment.getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_PICTURES).getAbsolutePath())
                    .build()
                    .compressToFile(file);

            Log.d("Size", "Size image save in " + String.format("Size : %s", getReadableFileSize(compressedImage.length())));
        }
        return compressedImage;
    }

    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    public String getReadableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }
}
