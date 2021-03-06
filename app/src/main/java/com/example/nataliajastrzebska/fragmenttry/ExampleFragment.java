package com.example.nataliajastrzebska.fragmenttry;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by nataliajastrzebska on 05/10/15.
 */
public class ExampleFragment extends Fragment {

    OnRegisterClickedListener a;
    View vi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,
                container, false);
        vi = view;

        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.onRegisterClicked();
            }
        });

        Button loginBtn = (Button) view.findViewById(R.id.button);
        loginBtn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView tv1 = (TextView) vi.findViewById(R.id.textView2);
                TextView tv2 = (TextView) vi.findViewById(R.id.textView3);
                tv1.setText("");
                tv2.setText("");
                EditText name = (EditText) vi.findViewById(R.id.editText);
                if (isEmailNotValid(name.getText().toString())) {
                    tv1.setText("Wrong! Name should be E-mail");
                }
                EditText pass = (EditText) vi.findViewById(R.id.editText2);
                if (pass.getText().toString().length() < 8 || pass.getText().toString().length()> 16){
                    tv2.setText("Wrong! Password should have 8-16 characters.");
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a = (OnRegisterClickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }
    }

    public interface OnRegisterClickedListener {
        public void onRegisterClicked();
    }


    @Override
    public void onCreate (Bundle b) {
        super.onCreate(b);
    }

    public static boolean isEmailNotValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            return false;
        }
        return true;
    }


}
