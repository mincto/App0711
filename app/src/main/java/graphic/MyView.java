/*
*
* 개발자가 주도하여 그림을 그리기에 적당한 컴포넌트는 결국
* 버튼, 텍스트뷰 따위가 아니라, 아무것도 그림이 없는 상태인 그냥 View이다!!
* */
package graphic;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
public class MyView extends View {
    /* 모든 뷰는 액티비티를 벗어날수 없으므로, 생성자의 인수에
    *  액티비티를 넘겨주자
    * */

    /* 만일 개발자가 xml 파일에서 이 뷰를 사용할 경우 각종 width, height
    정보가 전달되므로, 반드시 AttributeSet 이 있는 생성자를 준비해야 한다*/
    public MyView(Context context, AttributeSet set) {
        super(context);
    }

    /*
    *
    * 모든 뷰는 자신이 그려질때, 호출되는 메서드가 지원되는데,
    * 자바표준에서는 paint 메서드이지만, 안드로이드에서는 onDraw 이다!!
    *
    * 자바표준에서는 Graphics 객체가 그림을 담당하지만, 안드로이드에서는
    * Canvas 라는 객체가 주요 그림을 그리는 핵심 기능을 담당한다!!
    * */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(); /* 그래픽 처리의 부가적인 정보를 담는객체
        주로 색상, 두께 등..
        */
        paint.setColor(Color.RED);

        canvas.drawLine(0,0,300,400, paint);
    }
}








