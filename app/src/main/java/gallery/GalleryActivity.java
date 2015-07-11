package gallery;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import net.stylenetwork.app0711.R;

public class GalleryActivity extends Activity {
    Button bt;
    int[] color={Color.RED , Color.GREEN};
    int count;
    MyImageView photo;
    Thread thread;
    Handler handler;
    boolean running=false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery);
        bt = (Button)findViewById(R.id.bt);
        photo = (MyImageView)findViewById(R.id.photo);

        handler = new Handler(){
            public void handleMessage(Message msg) {
                /* 사진을 원하는 시간 간격으로 교체하여 보여준다!!*/
                if(count%2 != 0){
                    photo.index++;
                    photo.invalidate();/* onDraw() 메서드 호출!!*/
                }
            }
        };

        thread = new Thread(){
            public void run(){
                running=true;
                while(true){
                    /*핸들러에게 ui 제어 부탁!!*/
                    if(photo.index>=photo.bitmap.length-1) {
                        photo.index=0;
                    }
                    handler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

    }

    public void startGallery(){
        if(count%2 == 0){ //짝수
            bt.setBackgroundColor(color[0]);/*가동*/
        }else{
            bt.setBackgroundColor(color[1]);/*멈춤*/
        }
        count++;

        if(!running){/*이미 존재하면 생성해서는 않된다!!*/
            thread.start(); /*버튼을 눌럿을때 쓰레드 시작!!*/
        }

    }

    public void btnClick(View view){
        startGallery();
    }

}





