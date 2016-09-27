package app.zhangpeng.rememberwords;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zhangpeng on 2016-09-02.
 */
public class fragment_words_2 extends  Fragment {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_words_2, container, false);
        text_words=new int[]{R.id.textView50,R.id.textView51,R.id.textView52,R.id.textView53,R.id.textView54
                ,R.id.textView55,R.id.textView56,R.id.textView57,R.id.textView58,R.id.textView59};
        text_voice=new int[]{R.id.textView60,R.id.textView61,R.id.textView62,R.id.textView63,R.id.textView64
                ,R.id.textView65,R.id.textView66,R.id.textView67,R.id.textView68,R.id.textView69};
        text_mean=new int[]{R.id.textView70,R.id.textView71,R.id.textView72,R.id.textView73,R.id.textView74
                ,R.id.textView75,R.id.textView76,R.id.textView77,R.id.textView78,R.id.textView79};
        preferences=getActivity().getSharedPreferences("days", Context.MODE_PRIVATE);
        editor=preferences.edit();
        click=new boolean[text_words.length];
        means=new String[text_words.length];
        word=new TextView[text_words.length];
        mean=new TextView[text_words.length];
        database=SQLiteDatabase.openOrCreateDatabase(DBmanager.DB_PATH+"/"+DBmanager.DB_NAME,null);
        Cursor cursor=database.query(false,"words",null,null,null,null,null,null,null);
        cursor.moveToPosition((preferences.getInt("days",1)-1)*40+10);//天数*40//第一个fragment
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
    public void refresh(){
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
