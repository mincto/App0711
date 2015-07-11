/*
* 버튼을 누르면 TextView에 숫자를 1씩 증가시키되,
* 자동으로 증가되는 프로그램 ( 쓰레드이용...)
*
* 쓰레드란 ?
*  하나의 프로세스(실행중인 프로그램)내에서 독립적으로 수행할 수 있는
*  세부 실행단위을 의미!!
*  몇개까지 생성가능한가?? - 메모리가 허용하는 한 가능...
*
*  주의)
*  안드로이드는 자바표준(javSE) 의 쓰레드를 그대로 지원하기는 하지만,
*  차이점이라면, 자바의 쓰레드 개발시, 개발자가 정의한 쓰레드는 UI를 접근할수
*  있도록 처리가 된 반면, 안드로이드는 개발자가 정이한 쓰레드가 UI를 제어할 수
*  있도록 처리되지 않았다...
*  결론) 안드로이에서는 우리가 정의한 쓰레드에 디자인을 제어할 수 없다!!
*  왜??)   메인쓰레드와 개발자가 정의한 쓰레드간 충돌을  방지하기 위함..엉킴방지
          메인쓰레드는 UI를 구성하거나, 이벤트를 감지하는 역할을 한다..
          메인쓰레드로 하지말아야 할 작업 - 무한루프, 대기상태에 빠지게 하는 메서드..
          이런 작업은 개발자가 정의한쓰레드로 해야함..

   해결책)   Handler 라는 객체를 지원하여, 개발자가 정의한 쓰레드가 UI를 제어하고
             싶을때는 Handler에 접수하면 된다!! --> 즉시 메인쓰레드로 하여금
             디자인을 제어할 수 있도록 처리가 된다..
             결국 개발자가 정의한 쓰레드는 간접적으로 UI를 Handler를 통해 제어할
             수 있게 된다..
* */
package thread;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import net.stylenetwork.app0711.R;



public class TimerActivity extends Activity {
    int count=0;
    TextView txt_count;
    Handler handler;/*동생으로 하여금 UI제어를 위한 부탁을 받는 객체*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_timer);
        txt_count = (TextView)findViewById(R.id.txt_count);

        handler = new Handler(){
            /*동생의 요구를 처리할 메서드 재정의 */
            @Override
            public void handleMessage(Message msg) {
                /*여기에 동생이 원하는것을 해주면 됨..*/
                txt_count.setText("count="+count);
            }
        };
    }

    /*
    * 버튼을 누르면, 쓰레드 하나를 생성하여, 작동시켜보자!!
    * 안드로이드는 자바표준의 쓰레드를 지원해준다!!
    * */
    public void btnClick(View view){
        Thread thread = new Thread(){
            public void run(){
                while(true) {
                    count++;
                    //Log.d("TimerActivity", "count = " + count);
                    /*핸들러에게 부탁하자!!
                    * handleMessage를 호출하게 됨!!
                    * 지금은 딱히나, 전달할 데이터가 없기 때문에
                    * 그냥 sendEmptyMessage 를 호출함
                    * */
                    handler.sendEmptyMessage(0);
                    /* 1초간 잠시 non-runnable 상태로 피신하자!!*/
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }; /*생성됨 !!*/
        thread.start(); /*Runnable  로 진입*/


    }
}











