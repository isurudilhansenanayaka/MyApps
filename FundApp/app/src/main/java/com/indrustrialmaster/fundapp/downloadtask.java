package com.indrustrialmaster.fundapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class downloadtask extends AsyncTask<ImageView,String,Bitmap> {
    ImageView tv;

    @Override
    protected Bitmap doInBackground(ImageView... tvs) {
        tv=tvs[0];
        Bitmap bmp=null;

        try {

            try {
                URL url = new URL("https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjl4aH_wL_dAhWYV30KHdW2CdEQjRx6BAgBEAU&url=http%3A%2F%2Fwww.meteoearth.com%2Fmobile%2Fen.html&psig=AOvVaw3UXnQM7m3qpvGW2cKKwLqb&ust=1537186729515436" +
                        "assets/front/img/logo.png");
                InputStream in = url.openConnection().
                        getInputStream();
                bmp = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bmp;



        }catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap b) {
        super.onPostExecute(b);
        tv.setImageBitmap(b);
    }
}
