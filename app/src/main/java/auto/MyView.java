/*
* 현재 이 뷰에 우리가 원하는 그림을 그려넣기 위해, View 클래스를 재정의한다
* */
package auto;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
public class MyView extends View {
    int posX;
    int posY=200;
    int width=100;
    int height=100;
    Paint paint;


    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint  = new Paint();
        paint.setColor(Color.RED);
    }

    /* 그림이 그려질때 호출되는 메서드... 이 메서드는 그림이 조금이라도
    * 다시 그려져야 할 경우에 무조건 호출.. 단, 개발자가 이 메서드를 직접
    * 호출 할 수 없다!! ( 다른 언어와 마찬가지임..)
     * 왜??? GUI의 사용은 유저들이 하는것이고, 이때 그림이 다시 그려져야
     * 하므로 그림이 그려져야할 타이밍 및 시점은 결국 , 시스템이 결정하느것이다
     * 따라서 개발자가 메서드 호출을 해서는 않되고 할수도 없다
     * 실험) 만일 직접 호출하면?? 그냥 일반 메서드 취급하여 그래픽되지 않음.
     *
     * 개발자 원하는 타이밍에 그림을 갱신하고 싶을때?? 간접호출을 해야 함 ...
     * 자바표준 - repaint(), 안드로이드- invalidate()
    * */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(posX, posY, posX+width, posY+height, paint);
    }
}






