package app.zhangpeng.rememberwords;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by zhangpeng on 2016-09-02.
 */
public class fragment_words_1 extends Fragment {
    private SQLiteDatabase database;
    private int[] text_words;
    private int[] text_voice;
    private int[] text_mean;
    private String[] means;
    public boolean[] click;
    private TextView[] word;
    private TextView pro;
    private TextView[] mean;
    SharedPreferences preferences;//read
    SharedPreferences.Editor editor;//write
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_words_1,container,false);
        text_words=new int[]{R.id.textView12,R.id.textView14,R.id.textView16,R.id.textView18,R.id.textView20
                            ,R.id.textView22,R.id.textView24,R.id.textView26,R.id.textView28,R.id.textView30};
        text_voice=new int[]{R.id.textView13,R.id.textView15,R.id.textView17,R.id.textView19,R.id.textView21
                            ,R.id.textView23,R.id.textView25,R.id.textView27,R.id.textView29,R.id.textView31};
        text_mean=new int[]{R.id.textView32,R.id.textView33,R.id.textView34,R.id.textView35,R.id.textView36
                            ,R.id.textView37,R.id.textView38,R.id.textView39,R.id.textView40,R.id.textView41};
        click=new boolean[text_words.length];
        means=new String[text_words.length];
        word=new TextView[text_words.length];
        mean=new TextView[text_words.length];
        preferences=getActivity().getSharedPreferences("days", Context.MODE_PRIVATE);
        editor=preferences.edit();
        database=SQLiteDatabase.openOrCreateDatabase(DBmanager.DB_PATH+"/"+DBmanager.DB_NAME,null);
        Cursor cursor=database.query(false,"words",null,null,null,null,null,null,null);
        cursor.moveToPosition((preferences.getInt("days",1)-1)*40);//天数*40//第一个fragment
        for (int i=0;i<text_words.length;i++){
            word[i]=(TextView)rootView.findViewById(text_words[i]);
            pro=(TextView)rootView.findViewById(text_voice[i]);
            mean[i]=(TextView)rootView.findViewById(text_mean[i]);
            means[i]=cursor.getString(2);
            word[i].setText(cursor.getString(0));
            pro.setText("/"+cursor.getString(1)+"/");
            mean[i].setText("");
            cursor.moveToNext();
        }
        word[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click[0])
                    mean[0].setText("");
                else
                    mean[0].setText(means[0]);
                click[0]=!click[0];
            }
        });
        word[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click[1])
                    mean[1].setText("");
                else
                    mean[1].setText(means[1]);
                click[1]=!click[1];
            }
        });
       word[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click[2])
                    mean[2].setText("");
                else
                    mean[2].setText(means[2]);
                click[2]=!click[2];
            }
        });
        word[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click[3])
                    mean[3].setText("");
                else
                    mean[3].setText(means[3]);
                click[3]=!click[3];
            }
        });
        word[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click[4])
                    mean[4].setText("");
                else
                    mean[4].setText(means[4]);
                click[4]=!click[4];
            }
        });
        word[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click[5])
                    mean[5].setText("");
                else
                    mean[5].setText(means[5]);
                click[5]=!click[5];
            }
        });
       word[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click[6])
                    mean[6].setText("");
                else
                    mean[6].setText(means[6]);
                click[6]=!click[6];
            }
        });
       word[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click[7])
                    mean[7].setText("");
                else
                    mean[7].setText(means[7]);
                click[7]=!click[7];
            }
        });
       word[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click[8])
                    mean[8].setText("");
                else
                    mean[8].setText(means[8]);
                click[8]=!click[8];
            }
        });
       word[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click[9])
                    mean[9].setText("");
                else
                    mean[9].setText(means[9]);
                click[9]=!click[9];
            }
        });
        return rootView;
    }
    public void refresh(){//显示
        for (int i=0;i<text_words.length;i++){
            mean[i].setText(means[i]);
           click[i]=true;
        }

    }
    public void hide(){//隐藏
        for (int i=0;i<text_words.length;i++){
            mean[i].setText("");
            click[i]=false;
        }
    }


}
