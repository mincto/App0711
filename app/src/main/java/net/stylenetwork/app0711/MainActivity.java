package net.stylenetwork.app0711;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    LinearLayout box;
    String[] names ={
            "BATMAN","CAPTAIN","DEADPOOL","FLASH","HANKMAN",
            "IRONFIST","LOKI","ROBIN","SHIELD","SUPERMAN",
            "PUNISHER","VENOM","WONDERWOMAN"};
    int[] images = {
            R.drawable.batman,
            R.drawable.captainamerica,
            R.drawable.deadpool,
            R.drawable.flash,
            R.drawable.hankman,
            R.drawable.ironfist,
            R.drawable.loki,
            R.drawable.robin,
            R.drawable.shield,
            R.drawable.superman,
            R.drawable.thepunisher,
            R.drawable.venom,
            R.drawable.wonderwoman
    };

    /*배열도 대량의 데이터를 처리하기에는 훌륭하지만, 단점이 있다
    * 생성시 반드시 그 크기를 명시해야 한다
    *
    * 자바에서는 객체만을 모아서 처리하는 유용한 라이브러리를 제공하는데,
    * 그 라이브러리는 java.util 패키지에 모여있고, 이 기술을 가리켜
    * 컬렉션 프레임웍이라 한다.
    * 컬렉션 프레임웍을 구성하는 객체들은 총 3가지 유형으로 나누어지는데,
    * 1) 객체를 순서있게처리하는 유형 : List (배열과 흡사: for문과 친함)
     *2) 객체를 순서없이 처리하는 유형 : Set
       3) 객체를 key- value의 쌍으로 처리하는 유형 : Map
    */
    ArrayList<Member> list=new ArrayList<Member>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();/*데이터베이스를 구축한다!!*/

        box =(LinearLayout)findViewById(R.id.box);
        //거대한복합위젯 w = new 거대한복합위젯()
        /*우리가 xml정의한 아이템을 메모리에 올린 후 현재 코드로 가져오기*/
        /*개발자 주도하에 인플레이션 시키기 위해서는 LayoutInflater를 사용한다*/
        LayoutInflater inflater=null;
        inflater=(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        for(int i=0;i<list.size();i++) {
            Member dto=list.get(i); /*멤버 인스턴스 끄집에 내기!!*/
            RelativeLayout rel = (RelativeLayout) inflater.inflate(R.layout.item, null, false);

            ImageView img=(ImageView)rel.findViewById(R.id.img);
            TextView txt_name=(TextView)rel.findViewById(R.id.txt_name);
            TextView txt_phone=(TextView)rel.findViewById(R.id.txt_phone);

            img.setImageResource(images[i]);
            txt_name.setText(dto.getName());
            txt_phone.setText(dto.getPhone());

            box.addView(rel);
        }
    }

    /*멤버들을 생성하는 초기화 메서드 */
    public void init(){
        for(int i=0;i< names.length;i++) {
            Member dto = new Member();
            dto.setImg(R.drawable.batman);
            dto.setName(names[i]);
            dto.setPhone("000-" + i);

            list.add(dto); /* 리스트에 멤버를 탑재!!*/
        }

    }

    public void removeItem(View view){
        /*현재 눌려진 버튼을 포함하는 RelelativeLayout을 지운다!!*/
        View parent=(View)view.getParent();
        box.removeView(parent);
    }

    /* 렐러티브 레이아웃 아이템을 LinerLayout에서 삭제해보자!! */
    public void btnClick(View view){
        removeItem(view);
    }

}





