package com.example.mylogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditUserActivity  extends AppCompatActivity implements View.OnClickListener {
    private TextView edUser;
    private Button btDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edituser);
        edUser = (TextView)findViewById(R.id.edUser);
        btDone = (Button)findViewById(R.id.btDone);
        btDone.setOnClickListener(this);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USER_NAME");
        edUser.setText(username);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btDone:
                onDone();
                break;
            default:
                break;
        }
    }

    private void onDone() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("USER_NAME", edUser.getText().toString());
        setResult(Activity.RESULT_OK,returnIntent);
    }


}
