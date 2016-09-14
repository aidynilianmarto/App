package com.example.pc.olx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pc.olx.User.Message;
import com.example.pc.olx.User.UserManager;

public class SendMessageActivity extends AppCompatActivity {
    private Button sendMessageButton;
    private EditText description;
    private TextView messageTitle;
    private TextView subject;
    private String messageTitleText;
    private String messageDescriptionText;
    private String subjectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        sendMessageButton = (Button) findViewById(R.id.sendMessageButton);
        description = (EditText) findViewById(R.id.messageDescriptionET);
        messageTitle = (TextView) findViewById(R.id.messageTitleTV);
        subject = (TextView) findViewById(R.id.subjectMessageTV);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageTitleText = getIntent().getStringExtra("title");
                messageTitle.setText(messageDescriptionText);
                subjectText = getIntent().getStringExtra("receiver");
                subject.setText(subjectText);
                messageDescriptionText = description.getText().toString();
                Message m = new Message(messageTitleText,messageDescriptionText,UserManager.getInstance(SendMessageActivity.this).getUser(getIntent().getStringExtra("sender")));
                UserManager.getInstance(SendMessageActivity.this).sendMessage(subjectText,getIntent().getStringExtra("sender"),m);
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
