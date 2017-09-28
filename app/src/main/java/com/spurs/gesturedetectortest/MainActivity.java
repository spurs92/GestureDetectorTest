package com.spurs.gesturedetectortest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.tv);
        gestureDetector=new GestureDetector(this,gestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        gestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                tv.append("onSingleTapConfirmed\n");
                return true;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                //tv.append("onDoubleTap\n");
                Toast.makeText(MainActivity.this, "onDoubleTap", Toast.LENGTH_SHORT).show();
                //Log.i("tag","DoubleTap");
                return true;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                tv.append("onDoubleTapEvent\n");
                return true;
            }
        });
        return super.onTouchEvent(event);
    }

    GestureDetector.OnGestureListener gestureListener=new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            tv.setText("onDown\n");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            tv.append("onshowPress\n");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            tv.append("onSingleTapUp\n");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            tv.append("onScroll\n");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            tv.append("onLongPress\n");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            tv.append("onFling\n");
            return true;
        }
    };

}
