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
    TextView textView;
    private Button button;
    private boolean[] click;
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
        click=new boolean[4];
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem()==0) {
                    if (!click[0]){
                        fragment1.refresh();
                        button.setText("隐藏全部词意");
                    }
                    else{
                        fragment1.hide();
                        button.setText("显示全部词意");
                    }
                    click[0] = !click[0];
                }
                else if (viewPager.getCurrentItem()==1){
                    if (!click[1]){
                        fragment2.refresh();
                        button.setText("隐藏全部词意");
                    }
                    else{
                        fragment2.hide();
                        button.setText("显示全部词意");
                    }
                    click[1] = !click[1];
                }

                else if (viewPager.getCurrentItem()==2){
                    if (!click[2]){
                        fragment3.refresh();
                        button.setText("隐藏全部词意");
                    }
                    else{
                        fragment3.hide();
                        button.setText("显示全部词意");
                    }
                    click[2] = !click[2];
                }

                else if (viewPager.getCurrentItem()==3){
                    if (!click[3]){
                        fragment4.refresh();
                        button.setText("隐藏全部词意");
                    }
                    else{
                        fragment4.hide();
                        button.setText("显示全部词意");
                    }
                    click[3] = !click[3];
                }

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                textView.setText("还剩："+Integer.toString((3-position)*10)+"个");
                if (position==0) {
                    if (!fragment1.click[position])
                        button.setText("显示全部词意");
                    else
                        button.setText("隐藏全部词意");
                }
                else if (position==1){
                    if (!click[position])
                        button.setText("显示全部词意");
                    else
                        button.setText("隐藏全部词意");
                }
                else if (position==2){
                    if (!click[position])
                        button.setText("显示全部词意");
                    else
                        button.setText("隐藏全部词意");
                }
                else if (position==3){
                    if (!click[position])
                        button.setText("显示全部词意");
                    else
                        button.setText("隐藏全部词意");
                }
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
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(fpAdapter);
    }
}
