package graphic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import net.stylenetwork.app0711.R;

/**
 * Created by Administrator on 2015-07-11.
 */
public class AniActivity extends Activity{
    AniView aniView;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ani);

        aniView =(AniView)findViewById(R.id.aniView);
    }
    /*
    * 우리가 정의한 뷰안의 이미지의 좌표값을 변경해보자!!
    * */
    public void move(){
        count+=10;
        aniView.posX=count;
        aniView.invalidate(); /* onDraw메서드 호출!! 즉 다시 그려라!!*/
    }

    public void btnClick(View view){
        move();
    }

}
