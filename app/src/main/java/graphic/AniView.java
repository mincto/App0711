/*
* 버튼에 의해서 그려진 이미지의 좌표를 수정하여, 다시 그려서
* 마치 움직이는 것과 같은 효과를 내자!!
* 사실 컴퓨터상에서 움직이는 모든 것들은 , 실제적으로 움직이는 것이 아니라
* 기존 그림을 지웠다가, 다시 그리는 것이다!!
* 따라서 그래픽 갱신이 빠르게 진행되어야 할 경우 고성능의 하드웨어와 그래픽
* 처리 로직이 필요하다.. ( 그래픽카드에도 GPU, 자체 메모리가 있는 이유..)
* */
package graphic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import net.stylenetwork.app0711.R;

public class AniView extends View {
    Bitmap bitmap;
    int posX; /*이미지의  x좌표*/
    int posY; /*이미지의  y좌표*/

    public AniView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.superman);
    }

    /*그래픽을 처리하기 위한 메서드 재정의 */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*생성을 여기서??*/
        canvas.drawBitmap(bitmap, posX, posY, null);
    }
}
















