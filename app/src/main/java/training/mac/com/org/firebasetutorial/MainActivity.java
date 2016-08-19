package training.mac.com.org.firebasetutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button mButtonFoggy;
    Button mButtonSunny;
    TextView mTextFieldCondition;

    //Firebase
    Firebase mRef;
    ArrayList<String> mMessages = new ArrayList<>();

    //UI
    TextView mTextView;
    ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonFoggy = (Button) findViewById(R.id.mButtonFoggy);
        mButtonSunny = (Button) findViewById(R.id.mButtonSunny);
        mTextFieldCondition = (TextView) findViewById(R.id.mTextFieldCondition);

        mTextView = (TextView) findViewById(R.id.mTextView);
        mListView = (ListView) findViewById(R.id.mListView);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //GET THE URL FROM FIREBASE (https://myfirstfirebase-dd057.firebaseio.com/)
        //THEN add 'condition' which is the place where you can save data

        mRef = new Firebase("https://myfirstfirebase-dd057.firebaseio.com/condition");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mTextFieldCondition.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mButtonFoggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.setValue("FOGGY");
            }
        });

        mButtonSunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.setValue("SUNNY");
            }
        });

        //Firebase Messages
        Firebase messagesRef = mRef.child("messages");
        messagesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }
}
