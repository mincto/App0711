/*
    단순히 src만 교체할거라면 이 클래스는 필요없으나,  개발자 주도의 그래픽
     을 처리하기 위해서 일부러 그림을 그려서 이미지 교체를 처리해 보자!!
 * */
package gallery;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import net.stylenetwork.app0711.R;

public class MyImageView extends ImageView {
    Bitmap[] bitmap = new Bitmap[13];/*비트맵이 들어갈 공간만 생성*/
    int index; /*현재 배열의  index를 위한 변수*/
    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        bitmap[0] = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        bitmap[1] = BitmapFactory.decodeResource(getResources(), R.drawable.captainamerica);
        bitmap[2] = BitmapFactory.decodeResource(getResources(), R.drawable.deadpool);
        bitmap[3] = BitmapFactory.decodeResource(getResources(), R.drawable.flash);
        bitmap[4] = BitmapFactory.decodeResource(getResources(), R.drawable.hankman);
        bitmap[5] = BitmapFactory.decodeResource(getResources(), R.drawable.ironfist);
        bitmap[6] = BitmapFactory.decodeResource(getResources(), R.drawable.loki);
        bitmap[7] = BitmapFactory.decodeResource(getResources(), R.drawable.robin);
        bitmap[8] = BitmapFactory.decodeResource(getResources(), R.drawable.shield);
        bitmap[9] = BitmapFactory.decodeResource(getResources(), R.drawable.superman);
        bitmap[10] = BitmapFactory.decodeResource(getResources(), R.drawable.thepunisher);
        bitmap[11] = BitmapFactory.decodeResource(getResources(), R.drawable.venom);
        bitmap[12] = BitmapFactory.decodeResource(getResources(), R.drawable.wonderwoman);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap[index],0,0, null);
    }
}









