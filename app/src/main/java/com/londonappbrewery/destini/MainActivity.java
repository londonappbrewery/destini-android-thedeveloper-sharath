package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView StoryText;
    Button TopButton;
    int mIndexTop = 1;
    int mIndexBottom = 1;
    Button BottomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        StoryText = (TextView) findViewById(R.id.storyTextView);
        BottomButton = (Button) findViewById(R.id.buttonBottom);
        TopButton = (Button) findViewById(R.id.buttonTop);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        TopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIndexTop == 1) {
                    setStoryTextandButtonText(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                    mIndexTop = 2;
                } else if (mIndexTop == 2) {
                    setStoryText(R.string.T6_End);
                    gone();
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        BottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIndexTop == 2 && mIndexBottom == 1) {
                    setStoryText(R.string.T5_End);
                    gone();
                } else if (mIndexBottom == 1) {
                    setStoryTextandButtonText(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);
                    mIndexBottom = 2;
                } else if (mIndexBottom == 2 && mIndexTop == 2) {
                    setStoryText(R.string.T5_End);
                    gone();
                } else if (mIndexBottom == 2) {
                    setStoryText(R.string.T4_End);
                    gone();
                }
            }
        });

    }

    public void gone() {
        TopButton.setVisibility(View.GONE);
        BottomButton.setVisibility(View.GONE);
    }

    public void setStoryTextandButtonText(int st, int tbt, int bbt) {
        StoryText.setText(st);
        TopButton.setText(tbt);
        BottomButton.setText(bbt);
    }

    public void setStoryText(int stt) {
        StoryText.setText(stt);
    }

}
