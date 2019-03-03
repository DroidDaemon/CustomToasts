package com.example.droiddaemon.customtoasts;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout linearLayout;
    Button defaultToast, imageToast, colortoast, shapeToast;
    private static final Typeface LOADED_TOAST_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL);
    private static Typeface currentTypeface = LOADED_TOAST_TYPEFACE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        linearLayout = (LinearLayout) findViewById(R.id.custom_layout);
        defaultToast = (Button) findViewById(R.id.simple);
        imageToast = (Button) findViewById(R.id.image_toast);

        defaultToast.setOnClickListener(this);
        imageToast.setOnClickListener(this);

    }


    public void showDefaultToast() {
        Toast.makeText(this, "This is a Android's Default Toast", Toast.LENGTH_LONG).show();
    }

    public void showToastWithImageToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast with Image");
        text.setTypeface(currentTypeface);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simple:
                showDefaultToast();
                break;
            case R.id.image_toast:
                showToastWithImageToast();
                break;
        }
    }
}
