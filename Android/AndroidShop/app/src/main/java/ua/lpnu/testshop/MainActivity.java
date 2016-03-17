package ua.lpnu.testshop;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewGroup m_my_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_my_list = (ViewGroup)findViewById(R.id.list);

        LayoutInflater l = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        m_my_list.addView(l.inflate( R.layout.list_item, null));
        m_my_list.addView(l.inflate( R.layout.list_item, null));
        m_my_list.addView(l.inflate( R.layout.list_item, null));
        m_my_list.addView(l.inflate( R.layout.list_item, null));
        m_my_list.addView(l.inflate( R.layout.list_item, null));
        m_my_list.addView(l.inflate( R.layout.list_item, null));
        m_my_list.addView(l.inflate( R.layout.list_item, null));


        findViewById(R.id.button1).setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if (v.getId()==R.id.button1)
        {
            AlphaAnimation anim = new AlphaAnimation(0,1);
            anim.setDuration(300);
            anim.setFillAfter(true);

            findViewById(R.id.detail).startAnimation(anim);
            findViewById(R.id.detail).setVisibility(View.VISIBLE);
        }
    }
}
