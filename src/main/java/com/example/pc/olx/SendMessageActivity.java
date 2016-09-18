package com.example.pc.olx;

import android.content.Intent;
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
    private String senderText;
    private String receiverText;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        sendMessageButton = (Button) findViewById(R.id.sendMessageButton);
        description = (EditText) findViewById(R.id.messageDescriptionET);
        messageTitle = (TextView) findViewById(R.id.messageTitleTV);
        subject = (TextView) findViewById(R.id.subjectMessageTV);
        intent = getIntent();
        senderText = intent.getStringExtra("sender");
        receiverText = intent.getStringExtra("receiver");
        messageTitleText = intent.getStringExtra("title");
        messageTitle.setText(messageTitleText);
        subject.setText(receiverText);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageDescriptionText = description.getText().toString();
                Message m = new Message(messageTitleText,messageDescriptionText,UserManager.getInstance(SendMessageActivity.this).getUser(senderText));
                UserManager.getInstance(SendMessageActivity.this).sendMessage(senderText,receiverText,m);
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
