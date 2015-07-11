/*
* 버튼을 상속받아, 나만의 버튼으로 재정의해보자!!
* */
package graphic;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
public class MyButton extends Button{
    /*안드로이드의 모든 위젯은 액티비티없이 존재할 수 없다!!*/
    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}
