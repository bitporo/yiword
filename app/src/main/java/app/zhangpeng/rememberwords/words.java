package app.zhangpeng.rememberwords;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class words extends AppCompatActivity {
    private ViewPager viewPager;
    private FragmentPagerAdapter fpAdapter;
    private List<Fragment> list;
    private int flag=0;
    TextView textView;
    private Button button;

    fragment_words_1 fragment1=new fragment_words_1();
    fragment_words_2 fragment2=new fragment_words_2();
    fragment_words_3 fragment3=new fragment_words_3();
    fragment_words_4 fragment4=new fragment_words_4();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_mian);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_words);
        button=(Button)findViewById(R.id.button6);
//        Button button1=(Button)findViewById(R.id.button2);
//        Button button2=(Button)findViewById(R.id.button3);
        textView=(TextView)findViewById(R.id.textView43);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        setViewPager();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem()==0)
                fragment1.refresh();
                else if (viewPager.getCurrentItem()==1)
                fragment2.refresh();
                else if (viewPager.getCurrentItem()==2)
                fragment3.refresh();
                else if (viewPager.getCurrentItem()==3)
                fragment4.refresh();
            }
        });
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                flag=viewPager.getCurrentItem()-1;
//                if (flag<0)
//                    flag=0;
//                viewPager.setCurrentItem(flag);
//
//            }
//        });
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                flag=viewPager.getCurrentItem()+1;
//                if (flag>3)
//                    flag=3;
//                viewPager.setCurrentItem(flag);
//
//            }
//        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                textView.setText("还剩："+Integer.toString((3-position)*10)+"个");
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void setViewPager(){
        viewPager=(ViewPager)findViewById(R.id.page);
        list=new ArrayList<>();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
        fpAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }
            @Override
            public int getCount() {
                return list.size();
            }
        };
        viewPager.setAdapter(fpAdapter);
    }
}
