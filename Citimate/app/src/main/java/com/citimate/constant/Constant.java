package com.citimate.constant;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.ParseException;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressLint({"NewApi", "SimpleDateFormat"})
public class Constant {

    public static String Username = "";
    public static String Email = "";
    public static String Password = "";
    public static String Phonenumber = "";
    public static String user_id = "";

    public static String LOVES_SOCCER = "";
    public static String LOVES_HOCKEY = "";
    public static String LOVES_BASKETBALL = "";
    public static String LOVES_TENNIS = "";
    public static String LOVES_BASEBALL = "";
    public static String LOVES_AMERICAN_FOOTBALL = "";
    public static String SPORTS_LOVE_JSONARRAY = "";

    public static String Status = "";
    public static String USER_IMAGE = "";
    public static String USER_LANGUAGE = "";
    public static String UPDATE_EDIT_PROFILE = "";
    public static String UPDATE_FAVOURITE_SCREEN = "";

    public static String UPDATE_USER_POST = "";

    public static Context appContext = null;
    public static String _docpicurl = null;

    public static final String DIALOG_TITLE = "Error";
    //	public static final String DIALOG_TITLE_CHECKINERROR = "Information";
//	public static final String DIALOG_TITLE_SUCCESS = "Success";
    public static final String MSG_INTERNETERROR = "Internet connection is not available.";
    //	public static final String MSG_DATANOTFOUND="No Data Found From Server.";
    public static final String MSG_SERVER_COMMUNICATION_FALIURE = "Server communication failed.";
//	public static final String MSG_CHECKININTERNETERROR="You need an internet connection to check-in.";
//	public static final String MSG_CHECK_INTERNET_SETTING="Please check internet settings.";

    public static ArrayList<Integer> notiID = new ArrayList<Integer>();
    public static ArrayList<Object> shortlist = new ArrayList<Object>();
    public static ArrayList<String> shortlistIDS = new ArrayList<String>();
    public static ProgressDialog progressDialog = null;

    //
    public static Activity uploadActivity = null;
    public static Activity _homeContext = null;
    public static Activity _currentActivity = null;
    public static Activity _loginContext = null;
    public static Activity _wFirstContext = null;


    public static ArrayList<Object> _pingsUsersList = new ArrayList<Object>();

    public static TextView _notificationCount;

    public static Context _currentActivityContext;
    public static String errorTitle = "Message";


    public static void currentAcitvityContext(Context context) {
        _currentActivityContext = context;
    }

    public static void getWFirstContext(Activity context) {
        _wFirstContext = context;
    }

    public static void getLoginContext(Activity context) {
        _loginContext = context;
    }

    /*public static void getLostItemContext(Activity context){
        _lostItemActivity = context;
    }*/
    public static void getHomeContext(Activity context) {
        _homeContext = context;
    }

    public static void getCurrentActivityContext(Activity context) {
        _currentActivity = context;
    }

    /*public static void showAlertDialog(final String title, String message,
            final Context context, final boolean redirectToPreviousScreen) {

        AlertDialog.Builder alertbox = new AlertDialog.Builder(context);
        alertbox.setMessage(message);
        alertbox.setTitle(title);
        alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                if(redirectToPreviousScreen){
                    ((Activity) context).finish();
                }else{
                    arg0.cancel();
                }
            }
        });
        try{
            alertbox.show();
        }catch (Exception b) {

        }
    }*/
    public static void showProgressDialog(final Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCancelable(false);
        System.out.println("showProgressDialog=========");
    }

    //////////// cancel progress Dialog
    public static void hideprogressDialog(final Context context) {
        progressDialog.hide();
//        progressDialog = new ProgressDialog(context);
//        progressDialog.cancel();
    }

//	showProgressDialog(final Context context){
//		if(progressDialog!=null)
//		{
//		progressDialog.cancel();
//		}
//		else
//		{
//		progressDialog = new ProgressDialog(context,android.R.style.Theme_Panel);
//		progressDialog.setMessage(context.getResources().getString(R.string.Please_wait));
//		progressDialog.show();
//		progressDialog.setCancelable(false);
//		}
//		}
    //////////// cancel progress Dialog


    public static void showAlertDialog(final String title, String message, final Context context, final boolean redirectToPreviousScreen) {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);

        dialogBuilder.setMessage(message);
        dialogBuilder.setTitle(title);

        dialogBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                arg0.cancel();
//                if (redirectToPreviousScreen) {
//                    ((Activity) context).finish();
//                } else {
//                    arg0.cancel();
//                }
            }
        });
        try {
            dialogBuilder.show();
        } catch (Exception b) {

        }
    }
    /*public static void showAlertMessage(String message, final Activity activity, final boolean flag){
            AlertDialog.Builder alertbox = new AlertDialog.Builder(activity);
			alertbox.setMessage(message);
			AlertDialog dialog = alertbox.show();
			TextView messageText = (TextView)dialog.findViewById(android.R.id.message);
			messageText.setGravity(Gravity.CENTER);
			try{
			dialog.show();
			}catch (Exception b) {

			}
			alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
			if(flag){
			activity.finish();
			}else{
			arg0.cancel();
			}
			}
			});
			alertbox.show();
			}*/

    public static void showAlertMessage(String message, final Activity activity, final boolean flag) {
        AlertDialog.Builder alertbox = new AlertDialog.Builder(activity);
        alertbox.setMessage(message);
        alertbox.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                if (flag) {
                    activity.finish();
                } else {
                    arg0.cancel();
                }
            }
        });
        alertbox.show();
    }

    public static void showToast(Context activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static void cancelDialog() {
        if (progressDialog != null)
            progressDialog.cancel();
        progressDialog = null;
    }

    public static Context getContext() {

        return getAppContext();
    }

    public static String getTempFile() {
        return Environment.getExternalStorageDirectory().getPath()
                + "/cropped_image" + String.valueOf(System.currentTimeMillis());
    }

    public static int getSizeValue(int size, int percentageValue) {
        int newSize = 0;
        if (size > 300) {
            newSize = (size * percentageValue) / 100;
        } else {
            newSize = size;
        }
        return newSize;
    }

    public static int getWidthPercentage(int size) {
        int percentage = 0;
        if (size > 300) {
            percentage = (300 * 100) / size;
        } else {
            percentage = 0;
        }
        return percentage;
    }

    public static File createTemporaryFile(String part, String ext) throws Exception {
        File tempDir = Environment.getExternalStorageDirectory();
        tempDir = new File(tempDir.getAbsolutePath() + "/mm/");
        if (!tempDir.exists()) {
            tempDir.mkdir();
        }
        return File.createTempFile(part, ext, tempDir);
    }

    public static String bytesToHex(byte[] bytes) {
        final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }


    public static String convertBitmapToBase64(Bitmap image) {
        String base64Image = null;
        Bitmap resizedBitmap = getResizedBitmap(image, 200);
        try {
            //	Bitmap immagex=resizedBitmap;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            resizedBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] b = baos.toByteArray();
            int i = b.length;
            if (i > 2097152) {
                Constant.showToast(uploadActivity, "Image size is too large.");
            } else {
                base64Image = Base64.encodeToString(b, Base64.DEFAULT);
            }

        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return base64Image;
    }


    public static Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 0) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }


    public static void convertUrlToBase64(final String src) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(src);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    Bitmap bm = BitmapFactory.decodeStream(input);
                    Constant._docpicurl = convertBitmapToBase64(bm);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static String toBase64fromString(String text) {
        return Base64.encodeToString(text.getBytes(), Base64.DEFAULT);
    }


	/*	public static String getDateFormat(Date date){
        String newDate="";
		String  newFormat= "dd-MM-yyyy";
		SimpleDateFormat sdf2 = new SimpleDateFormat(newFormat);
		newDate=String.valueOf(sdf2.format(date));
		return newDate;
	}*/

    public static String getCurrentDeviceTime() {
        // using Calendar class
		/*Calendar ci = Calendar.getInstance();

		String CiDateTime = "" + ci.get(Calendar.YEAR) + "-" +
		    (ci.get(Calendar.MONTH) + 1) + "-" +
		    ci.get(Calendar.DAY_OF_MONTH) + " " +
		    ci.get(Calendar.HOUR) + ":" +
		    ci.get(Calendar.MINUTE) +  ":" +
		    ci.get(Calendar.SECOND);*/

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        //String currentDateandTime = sdf.format(new Date());

        // using SimpleDateFormat class
        SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String newtime = sdfDateTime.format(new Date(System.currentTimeMillis()));
        System.out.println(newtime);
        return newtime;
    }

    /**
     * createFileInSDCard
     *
     * @param path
     * @param fileName
     * @return
     */
    public static File createFileInSDCard(String path, String fileName) {
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        File dir = new File(extStorageDirectory + path);
        try {
            if (!dir.exists() && dir.mkdirs()) {
                System.out.println("Directory created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = null;
        try {
            if (dir.exists()) {
                file = new File(dir, fileName);
                file.createNewFile();
            } else {
                runOnUiThread(new Runnable() {
                    public void run() {

                    }
                });
            }
        } catch (IOException e1) {
            e1.printStackTrace();
            runOnUiThread(new Runnable() {
                public void run() {

                }
            });
        }
        return file;
    }

    private static void runOnUiThread(Runnable runnable) {

    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static String dateFormat(String Date, String read, String write) {
        DateFormat readFormat = new SimpleDateFormat(read);

        DateFormat writeFormat = new SimpleDateFormat(write);
        java.util.Date date = null;
        try {
            try {
                date = readFormat.parse(Date);
            } catch (java.text.ParseException e) {

                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String formattedDate = "";
        if (date != null) {
            formattedDate = writeFormat.format(date);
        }

        System.out.println(formattedDate);

        return formattedDate;
    }

    /**
     * @return
     */
    public static String getOSVersion() {
        String myVersion = Build.VERSION.RELEASE;
        System.out.println("VERSION" + myVersion);
        return myVersion;
    }

    /**
     * @return
     */
    public static String getModel() {
        String model = Build.MODEL;
        model = model.replace(" ", "_");
        System.out.println("MODEL" + model);
        return model;
    }

    /**
     * getDeviceID
     *
     * @param appContext
     * @return
     */
    public static String getDeviceID(Context appContext) {
        TelephonyManager phoneManager = (TelephonyManager)/* getApplicationContext() */
                appContext.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceID = phoneManager.getDeviceId();

        return deviceID;
    }


    public static void showGroupChatInvitationAlert(final String title, final String message,
                                                    final String roomname, final Connection conn, final String inviter) {


        //	connect(user,password);

        new Thread(new Runnable() {
            public void run() {

//				SplashActivity.joinMultiUserChat(Constant.userName, Constant.password, roomname.split("@")[0]);
            }
        }).start();
    }


    public static String currentDate() {
		/*Calendar calendar = Calendar.getInstance();
		long time = calendar.getTimeInMillis();*/
        //return calendar.getTime();
		/*Calendar cal = Calendar.getInstance();
		cal.getTime().toString();

		return cal.getTime().toString();*/

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"),
                Locale.getDefault());
        Date currentLocalTime = calendar.getTime();
        DateFormat date = new SimpleDateFormat("Z");
        String localTime = date.format(currentLocalTime);
        return localTime.substring(0, 3) + ":" + localTime.substring(3, 5);
    }

    public static String dateFormat(String Date) {
        DateFormat readFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        DateFormat writeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = null;
        try {
            try {
                date = readFormat.parse(Date.split("\\+")[0]);
            } catch (java.text.ParseException e) {

                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String formattedDate = "";
        if (date != null) {
            formattedDate = writeFormat.format(date);
        }

        System.out.println(formattedDate);

        return formattedDate;
    }

    public static String setDate() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar calendar = Calendar.getInstance();
        long time = calendar.getTimeInMillis();
        //return calendar.getTime();
        Calendar cal = Calendar.getInstance();
        cal.getTime().toString();

        Date now = new Date();

        String actual = formatter.format(now);
        //return cal.getTime().toString();
        return actual;


    }

	/*public static String chatDate() {
		SimpleDateFormat readformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");

		SimpleDateFormat writeformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



		String actual = writeformatter.format(now);
		//return cal.getTime().toString();
		return actual;


	}*/

    public static int dateFormatCompare(String date1, String date2) {
        //int difference = -1;
        //SimpleDateFormat readDateFormat = new SimpleDateFormat("EEE MMM d ");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int difference = -1;
        Date Date1 = null;
        Date Date2 = null;
        try {
            try {
                Date1 = formatter.parse(date1);
                Date2 = formatter.parse(date2);
                long time1 = Date1.getTime();
                long time2 = Date2.getTime();

                if (time1 > time2) {
                    difference = -1;
                } else if (time1 == time2) {
                    difference = 0;
                } else if (time1 < time2) {
                    difference = 1;
                }

            } catch (java.text.ParseException e) {

                e.printStackTrace();
            }
        } catch (ParseException e) {

            e.printStackTrace();
            //   difference = -1 ;
        }

        //difference = Date1.compareTo(Date2);
        return difference;
    }

    public static Bitmap fixOrientationBitmap(Bitmap bitmap) {
        if (bitmap.getWidth() > bitmap.getHeight()) {
            Matrix matrix = new Matrix();
            matrix.postRotate(90);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return bitmap;
        }
        return bitmap;
    }


    public static Bitmap getBitmapFromURL(String src) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setNotificationCount() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    ((Activity) Constant._currentActivityContext).runOnUiThread(new Runnable() {
                        public void run() {
                            Constant._notificationCount.setText(String.valueOf(Constant._pingsUsersList.size()));
                            Constant._notificationCount.setVisibility(View.VISIBLE);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static String unicodeEscaped(char ch) {
        if (ch < 0x10) {
            return "\\u000" + Integer.toHexString(ch);
        } else if (ch < 0x100) {
            return "\\u00" + Integer.toHexString(ch);
        } else if (ch < 0x1000) {
            return "\\u0" + Integer.toHexString(ch);
        }
        return "\\u" + Integer.toHexString(ch);
    }

    /**
     * Converts the string to the unicode format '\u0020'.
     * <p/>
     * This format is the Java source code format.
     * <p/>
     * If <code>null</code> is passed in, <code>null</code> will be returned.
     * <p/>
     * <pre>
     *   CharUtils.unicodeEscaped(null) = null
     *   CharUtils.unicodeEscaped(' ')  = "\u0020"
     *   CharUtils.unicodeEscaped('A')  = "\u0041"
     * </pre>
     *
     * @param ch the character to convert, may be null
     * @return the escaped unicode string, null if null input
     */
    public static String unicodeEscaped(Character ch) {
        if (ch == null) {
            return null;
        }
        return unicodeEscaped(ch.charValue());
    }


    public static Bitmap scaleImage(Bitmap bitmap, int requirdwidth, int requirdHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        // Determine how much to scale: the dimension requiring less scaling is
        // closer to the its side. This way the image always stays inside your
        // bounding box AND either x/y axis touches it.
        float xScale = ((float) requirdwidth) / width;
        float yScale = ((float) requirdHeight) / height;
        float scale = 0;
        if (xScale <= yScale) {
            scale = (xScale <= yScale) ? xScale : yScale;
        } else if (xScale >= yScale) {
            scale = (xScale >= yScale) ? xScale : yScale;
        }
        // Create a matrix for the scaling and add the scaling data
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        // Create a new bitmap and convert it to a format understood by the ImageView
        Bitmap scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        BitmapDrawable result = new BitmapDrawable(scaledBitmap);
        width = scaledBitmap.getWidth();
        height = scaledBitmap.getHeight();
        return scaledBitmap;
    }

    public static boolean isNetworkAvailable(Context _context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static int uploadFile(String sourceFileUri, String URL) {

        int serverResponseCode = 0;

        //http://68.178.129.47/SafeChat/UploadFile?UserId={UserId}&FileType={FileType}&FromJID={FromJID}&ToJID={ToJID}
		/*String upLoadServerUri = "http://204.93.197.251/testuploadfile/uploadfile.php";*/
        String upLoadServerUri = URL;
        //String upLoadServerUri = "http://10.0.2.2/gcm_server_php3/upload_media_test.php?regId="+regId;
        String fileName = sourceFileUri;
        System.out.println("filename" + fileName);
        HttpURLConnection conn = null;
        DataOutputStream dos = null;
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 1024 * 1024;
        File sourceFile = new File(sourceFileUri);
        if (!sourceFile.isFile()) {
            Log.e("uploadFile", "Source File Does not exist");
            return 0;
        }
        try { // open a URL connection to the Servlet
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            java.net.URL url = new URL(upLoadServerUri);
            conn = (HttpURLConnection) url.openConnection(); // Open a HTTP  connection to  the URL
            conn.setDoInput(true); // Allow Inputs
            conn.setDoOutput(true); // Allow Outputs
            conn.setUseCaches(false); // Don't use a Cached Copy
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("ENCTYPE", "multipart/form-data");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

            conn.setRequestProperty("uploadedfile", fileName);
            dos = new DataOutputStream(conn.getOutputStream());
            System.out.println("transfer");
            dos.writeBytes(twoHyphens + boundary + lineEnd);
            dos.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\"" + fileName + "\"" + lineEnd);
            dos.writeBytes(lineEnd);

            bytesAvailable = fileInputStream.available(); // create a buffer of  maximum size

            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            // read file and write it into form...
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);

            while (bytesRead > 0) {
                dos.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                System.out.println("transferingggg...");
            }

            // send multipart form data necesssary after file data...
            dos.writeBytes(lineEnd);
            dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);


            // Responses from the server (code and message)
            serverResponseCode = conn.getResponseCode();

            String serverResponseMessage = conn.getResponseMessage();

            Log.i("uploadFile", "HTTP Response is : " + serverResponseMessage + ": " + serverResponseCode);
            if (serverResponseCode == 200) {
                System.out.println("Uploaded...");

            }

            try {
                DataInputStream inStream = new DataInputStream(conn.getInputStream());
                String str;

                while ((str = inStream.readLine()) != null) {
                    Log.e("Debug", "Server Response " + str);
                }
                inStream.close();

            } catch (IOException ioex) {
                Log.e("Debug", "error: " + ioex.getMessage(), ioex);
            }

            //close the streams //
            fileInputStream.close();
            dos.flush();
            dos.close();

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            Log.e("Upload file to server", "error: " + ex.getMessage(), ex);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Upload", "Exception : " + e.getMessage(), e);
        }

        return serverResponseCode;
    }

    public static void getlatLong(Context _context) {

//		GPSTracker gps=null;
//		gps = new GPSTracker(_context);
//		if (gps.canGetLocation()) {
//			latitute_user = gps.getLatitude();
//			longitute_user = gps.getLongitude();
//		} else {
//			gps.showSettingsAlert();
//		}
//		latLng=new LatLng(latitute_user, longitute_user);
//		System.out.println("latitude_user is "+latitute_user);
//		System.out.println("longitude_user is "+longitute_user);
        //latitute_user=Double.parseDouble("");
        //longitute_user=Double.parseDouble("");
    }


    //Hide  Keyboard
    public static void hideKeyBoard(Activity context) {
        View focusedView = context.getCurrentFocus();
        //			Toast.makeText(context,"not hide", 1).show();
        if (focusedView != null) {
            //       Toast.makeText(context,"hide", 1).show();
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(context.getWindow().getCurrentFocus().getWindowToken(), 0);
        }
    }


    //end changes
    public static void hideKeyBord(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public static boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //this method alfhanumric

    public static boolean passwordValidator(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z]).{8,16})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    //this method spacial charcters
    public static boolean passwordSpacialCharValidator(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&*()_+=|<>?{}\\[\\]~-]).{8,16})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }


    public static String USER_ID;
    public static String DEVICE_TYPE = "android";
    public static String REFER_CODE = "admin123";
    public static final String NETWORK_NOT_PRESENT = "Your network connection is too slow or may not be working";

    // returns object for myriad pro regular font
    public static Typeface setTypeface1(Context activity) {
        Typeface face = Typeface.createFromAsset(activity.getAssets(), "Roboto-Regular.ttf");
        return face;
    }

    // setting font for view title with helvetica neue
    public static void setViewTitleFont(Context activity, TextView textTitleBar) {
        Typeface face = Typeface.createFromAsset(activity.getAssets(), "Roboto-Regular.ttf");
        textTitleBar.setTypeface(face);
    }

    // traversing heirarchy of views and setting fonts to all internal views
    public static void overrideFonts(final Context context, final View v) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    overrideFonts(context, child);
                }
            } else if (v instanceof TextView) {
                ((TextView) v).setTypeface(Constant.setTypeface1(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @SuppressLint("SimpleDateFormat")
    public static String setgetDate(String _date) {
        if (_date != null && !_date.equals("") && !_date.equals(null) && !_date.equals("null") && !_date.equals("0000-00-00 00:00:00")) {
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = form.parse(_date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SimpleDateFormat postFormater = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
            String newDateStr = postFormater.format(date);
            return newDateStr;
        } else {
            return "";
        }
    }

    @SuppressLint("SimpleDateFormat")
    public static String setgetDateAMPM(String _date) {
        if (_date != null && !_date.equals("") && !_date.equals(null) && !_date.equals("null") && !_date.equals("0000-00-00 00:00:00")) {
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = form.parse(_date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SimpleDateFormat postFormater = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
            String newDateStr = postFormater.format(date);
            return newDateStr;
        } else {
            return "";
        }
    }

    @SuppressLint("SimpleDateFormat")
    public static String setgetDateAMPMAndMonthInAlphaBets(String _date) {
        if (_date != null && !_date.equals("") && !_date.equals(null) && !_date.equals("null") && !_date.equals("0000-00-00 00:00:00")) {
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = form.parse(_date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SimpleDateFormat postFormater = new SimpleDateFormat("dd MMM yyyy hh:mm a");
            String newDateStr = postFormater.format(date);
            return newDateStr;
        } else {
            return "";
        }
    }

    // checks whether string has null or blank value and returns false for null or blank
    public static boolean isStringExists(String str) {
        if (str == null) {
            return false;
        }
        if (!(str instanceof String)) {
            return false;
        }
        if (str.equalsIgnoreCase("null")) {
            return false;
        }
        if (str.equalsIgnoreCase("<null>")) {
            return false;
        }
        if (str.equalsIgnoreCase("(null)")) {
            return false;
        }
        str = str.trim();
        if (str.equals("")) {
            return false;
        }
        return true;
    }

    @SuppressLint("SimpleDateFormat")
    public static String setgetDateOnly(String _date) {
        if (_date != null && !_date.equals("") && !_date.equals(null) && !_date.equals("null") && !_date.equals("0000-00-00 00:00:00")) {
            SimpleDateFormat form;
            if (_date.trim().contains(" ")) {
                form = new SimpleDateFormat("yyyy-MM-dd");
            } else {
                form = new SimpleDateFormat("yyyy-MM-dd");
            }
            //30/04/2015
            Date date = null;
            try {
                date = form.parse(_date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SimpleDateFormat postFormater = new SimpleDateFormat("dd/MM/yyyy");
            String newDateStr = postFormater.format(date);
            if (newDateStr == null) {
                newDateStr = "";
            }
            return newDateStr;
        } else {
            return "";
        }
    }

    public static boolean checkEmail(String email) {
        String expression = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*"
                + "+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        Pattern emailPattern = Pattern.compile(expression);
        return emailPattern.matcher(email).matches();
    }

    public static boolean isValidPhoneNumber(String mobile) {
        String regEx = "^[0-9]{10}$";
        return mobile.matches(regEx);
    }

}