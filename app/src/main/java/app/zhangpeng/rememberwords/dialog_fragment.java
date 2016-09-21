package app.zhangpeng.rememberwords;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

/**
 * Created by zhangpeng on 2016-09-06.
 */
public class dialog_fragment extends DialogFragment{
    NumberPicker nb;
    Button ok;
    Button cancel;
    SharedPreferences preferences;//read
    SharedPreferences.Editor editor;//write
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.dialog_layout, container);
        nb=(NumberPicker)view.findViewById(R.id.picker);
        ok=(Button)view.findViewById(R.id.button4);
        cancel=(Button)view.findViewById(R.id.button5);
        preferences=getActivity().getSharedPreferences("days",Context.MODE_PRIVATE);
        editor=preferences.edit();
        nb.setMaxValue(86);
        nb.setMinValue(1);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("days",nb.getValue());
                editor.commit();
                dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }
}
