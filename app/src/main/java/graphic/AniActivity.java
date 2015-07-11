package graphic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import net.stylenetwork.app0711.R;

/**
 * Created by Administrator on 2015-07-11.
 */
public class AniActivity extends Activity {
    AniView aniView;
    int countX = 0;/* x축 값 컨트롤*/
    int countY = 0;/* y축 값 컨트롤*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ani);

        aniView = (AniView) findViewById(R.id.aniView);
    }

    /*
    * 우리가 정의한 뷰안의 이미지의 좌표값을 변경해보자!!
    * */
    public void move() {
        if(countY<0){
            countY=0;
        }
        aniView.posX = countX;
        aniView.posY=countY;
        aniView.invalidate(); /* onDraw메서드 호출!! 즉 다시 그려라!!*/
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.bt_left:countX -= 10;break;
            case R.id.bt_right:countX += 10;break;
            case R.id.bt_up:countY -= 10;break;
            case R.id.bt_down:countY += 10;break;
        }
        move();
    }

}
