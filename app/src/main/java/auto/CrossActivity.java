/*
* 개발자가 주도하여 그래픽 처리를 하되, 도형을 쓰레드를 이용하여 움직여본다!
* */
package auto;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import net.stylenetwork.app0711.R;

public class CrossActivity extends Activity {
    MyView myView;
    int stepX=10; /*  증가량 */
    Handler handler;
    boolean flag=false; /*true 일때는 증가, false 감소로 목적!!*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cross);
        myView= (MyView)findViewById(R.id.myView);

        handler = new Handler(){
            /* 이 메서드는 쓰레드가 sendMessage 류를 호출할때 무조건
            * 호출!! 동생쓰레드가 원하는것을 들어주자 !*/
            public void handleMessage(Message msg) {
                moveAuto();
            }
        };
    }

    /* 이벤트 메서드에 로직을 작성하지 말자!!!
    * 왜?? 추후 이 이벤트가 아닌 다른 이벤트로 변경될 경우
    * 이 메서드 안에 기재한 로직도 사라지게 된다...
    * */
    public void btnClick(View view){
        Thread thread = new Thread(){
            /* 개발자가 독립적으로 수행시키고 싶은 로직은 run 에 기재
            *  시스템이 runnable 상태에 있는 쓰레드를 대상으로, 실행시
            *  run 메서드가 호출되므로..
            * */
            public void run(){
                /*UI를 제어를 직접하면 않되고 , 핸들러에게 부탁하자!!*/
                while(true){
                    handler.sendEmptyMessage(0); /*형님에게 부탁하는 시점!!*/
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start(); /* Runnable 상태로 진입을 시켜야, 시스템에 의해 뺨때기
        맞으니깐...*/
    }
    /* 개발시 무언가를 자동으로 움직이게 하려면, 먼저 수동을 해놓아야 한다
    * 왜?? 수동작업을 완료한 후, 이 로직을 쓰레드에 의해 호출만 하면 이게 자동
    * 이기 때문에...!!
    * */
    public void moveAuto(){
        if(myView.posX >=700 || myView.posX <=0){
            flag=!flag;
        }

        if(flag){
            myView.posX = myView.posX + stepX;
        }else{
            myView.posX = myView.posX - stepX;
        }
        myView.invalidate();
    }

}



