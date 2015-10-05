package com.example.nataliajastrzebska.fragmenttry;

import android.app.Fragment;
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
public class RegisterFragment extends android.support.v4.app.Fragment{

    View vi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,
                container, false);
        vi = view;

        Button loginBtn = (Button) view.findViewById(R.id.button2);
        loginBtn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView tv1 = (TextView) vi.findViewById(R.id.textView4);
                TextView tv2 = (TextView) vi.findViewById(R.id.textView5);
                TextView tv3 = (TextView) vi.findViewById(R.id.textView6);
                tv1.setText("");
                tv2.setText("");
                tv3.setText("");
                EditText name = (EditText) vi.findViewById(R.id.editText3);

                if (isEmailNotValid(name.getText().toString())) {
                    tv1.setText("Wrong! Name should be E-mail");
                }
                EditText pass = (EditText) vi.findViewById(R.id.editText4);
                if (pass.getText().length() < 8 || pass.getText().length()> 16){
                    tv2.setText("Wrong! Password should have 8-16 characters.");
                }
                EditText pass2 = (EditText) vi.findViewById(R.id.editText4);
                if (pass.getText().toString().length() == pass2.getText().toString().length()) {
                    if (pass.getText().toString().equals(pass2.getText().toString())) {
                        tv3.setText("Passwords don't match");
                    }
                    tv3.setText("Passwords don't match");
                }
            }
        });

        return view;
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

    boolean isValidationSuccesful (View view){
        TextView tv1 = (TextView) view.findViewById(R.id.textView4);
        TextView tv2 = (TextView) view.findViewById(R.id.textView5);
        TextView tv3 = (TextView) view.findViewById(R.id.textView6);
        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
        EditText name = (EditText) view.findViewById(R.id.editText3);

        if (isEmailNotValid(name.getText().toString())) {
            tv1.setText("Wrong! Name should be E-mail");
            return false;
        }
        EditText pass = (EditText) view.findViewById(R.id.editText4);
        if (pass.getText().length() < 8 || pass.getText().length()> 16){
            tv2.setText("Wrong! Password should have 8-16 characters.");
            return false;
        }
        EditText pass2 = (EditText) view.findViewById(R.id.editText4);
        if (pass.getText().toString().length() == pass2.getText().toString().length()) {
            if (!pass.getText().toString().equals(pass2.getText().toString())) {
                tv3.setText("Passwords don't match");
                return false;
            }
        }
        return false;
    }

}
