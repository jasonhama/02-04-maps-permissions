package edu.uw.mapdemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

    private static final String TAG = "** FILE DEMO **";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
    }


    //external button
    public void handleSaveFile(View v){
        Log.v(TAG, "Save button clicked");
        if(isExternalStorageWritable()){
            try{
                File dir;
                dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                //dir = Environment.getExternalStorageDirectory();
                File file = new File(dir, "myFile.txt");
                FileOutputStream outputStream = new FileOutputStream(file);
                String message = "Hello file!";
                outputStream.write(message.getBytes());
                outputStream.close();
                Log.v(TAG, "File written");

            } catch(IOException ioe) {
                ioe.printStackTrace();
            }
        }

    }

    public boolean isExternalStorageWritable(){
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }
        return false;
    }


    //internal button
    public void handleReadFile(View v){
        Log.v(TAG, "Read button clicked");
        if(isExternalStorageWritable()){
            try{
                File dir;
                dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                //dir = Environment.getExternalStorageDirectory();
                File file = new File(dir, "myFile.txt");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                FileInputStream outputStream = new FileInputStream(file);
                String message = "Hello file!";
                outputStream.read(message.getBytes());
                outputStream.close();
                Log.v(TAG, "File written");

            } catch(IOException ioe) {
                ioe.printStackTrace();
            }
        }

    }


    //share button
    public void handleShareFile(View v){
        Log.v(TAG, "Share button clicked");


    }


}
