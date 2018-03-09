package com.example.lado.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userInput, passwordInput;
    TextView userText;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput = (EditText) findViewById(R.id.buckysInput);
        passwordInput = (EditText) findViewById(R.id.buckysInputpass);
        userText = (TextView) findViewById(R.id.buckysText);
        dbHandler = new DBHandler(this, null, null, 1);
        printDatabase();
        userText.setMovementMethod(new ScrollingMovementMethod());
        userText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(), "You have pressed it long :)", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
    public void addButtonClicked(View view) {
        Users users = new Users(userInput.getText().toString(), passwordInput.getText().toString());
        dbHandler.AddUser(users);
        printDatabase();
    }

    public void deleteButtonClicked(View view) {
        String inputText = userInput.getText().toString();
        String inputTextPass = passwordInput.getText().toString();
        dbHandler.DeleteUser(inputText, inputTextPass);
        printDatabase();
    }

    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        userText.setText(dbString);
        userInput.setText("");
        passwordInput.setText(dbString);
        passwordInput.setText("");
    }
}
