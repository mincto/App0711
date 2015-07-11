/*
* 안드로이드를 포함해서 모든 GUI 응용프로그램에서 , 그래픽의 주체는 개발자가
* 아니라 GUI컴포넌트 스스로이다!!
* 예)  버튼을 그리는것은 개발자가 아니라 버튼 스스로다!!
*       텍스트뷰를 그리는것은 개발자가 아니라 텍스트뷰 스스로다!!
* 하지만 이 실습에서는 버튼을 우리가 주도해서 그려보자!!
*/
package graphic;
import android.app.Activity;
import android.os.Bundle;

import net.stylenetwork.app0711.R;

public class GraphicActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*인플레이션 + 화면부착!!*/
        setContentView(R.layout.activity_graphic);

    }
}





