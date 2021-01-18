package com.example.alarms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdditionFragment.IReferenceLayouts {

    private PagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;

    ConstraintLayout con_backToAdd;
    FrameLayout frame_add_setting ;
    FrameLayout frm_save;

    ConstraintLayout home_layout;
    FrameLayout splashScreen;
    Animation anim,anim2,anim3;

    TextView txt_day,txt_month_number,splash_textView;

    RecyclerView recyclerView;
    List<AlarmModel> alarmModelList;


    AnimatedVectorDrawable avd;
    AnimatedVectorDrawableCompat avd_compat;

    ImageView temp_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        //initViews();
        AlarmModel alarmModel = new AlarmModel();
        alarmModel.days = "Everyday";
        alarmModel.hour = 11;
        alarmModel.min = 56;
        alarmModel.label = "Merhaba";

        AlarmModel alarmModel2 = new AlarmModel();
        alarmModel2.days = "Everyday";
        alarmModel2.hour = 8;
        alarmModel2.min = 22;
        alarmModel2.label = "Merhaba";

        AlarmModel alarmModel3 = new AlarmModel();
        alarmModel3.days = "Everyday";
        alarmModel3.hour = 1;
        alarmModel3.min = 14;
        alarmModel3.label = "Merhaba";






        alarmModelList = new ArrayList<>();

        alarmModelList.add(alarmModel);
        alarmModelList.add(alarmModel2);
        alarmModelList.add(alarmModel3);

        RecyclerViewAlarms.IChecking iChecking  = new RecyclerViewAlarms.IChecking() {
            @Override
            public void check(ImageView checking) {

                Drawable drawable = checking.getDrawable();
                if(drawable instanceof  AnimatedVectorDrawableCompat)
                {
                    avd_compat = (AnimatedVectorDrawableCompat)drawable;
                    avd_compat.start();
                }
                else if (drawable instanceof  AnimatedVectorDrawable)
                {

                    avd = (AnimatedVectorDrawable)drawable;
                    avd.start();
                }

            }
        };


        RvSnoozeInterval.IChecking iCheckingInterval  = new RvSnoozeInterval.IChecking() {
            @Override
            public void check(ImageView checking) {

                temp_img = checking;
                Drawable drawable = checking.getDrawable();
                if(drawable instanceof  AnimatedVectorDrawableCompat)
                {
                    avd_compat = (AnimatedVectorDrawableCompat)drawable;
                    avd_compat.start();
                }
                else if (drawable instanceof  AnimatedVectorDrawable)
                {

                    avd = (AnimatedVectorDrawable)drawable;
                    avd.start();
                }
            }
        };



        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.POSITION_NONE );

        mViewPager = (ViewPager) findViewById(R.id.fragmentPagerrrrr);
        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

   /*
        RecyclerViewAlarms recyclerViewAlarms = new RecyclerViewAlarms(alarmModelList,this,iChecking);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setAdapter(recyclerViewAlarms);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(llm);

        //home_layout.setVisibility(View.INVISIBLE);
        //splashScreen.setVisibility(View.VISIBLE);

        //setDateTo();

        //setAnimationsToView();


         */
    }

    /*
    private void initViews()
    {
        txt_day = (TextView)findViewById(R.id.txt_day);
        txt_month_number = (TextView)findViewById(R.id.txt_month_number);
        splash_textView = (TextView)findViewById(R.id.splash_textView);

        home_layout = (ConstraintLayout)findViewById(R.id.home_layout);
        splashScreen = (FrameLayout)findViewById(R.id.splashScreen);
    }
    private  void setDateTo()
    {
        CalendarModel calendarData = new CalendarModel();

        txt_day.setText(CalendarNumConverter.getDayName(calendarData.getDay()));
        txt_month_number.setText(CalendarNumConverter.getMonthName(calendarData.getMonth()) + "  "+calendarData.getdayNum());
    }

    private void setAnimationsToView()
    {
        anim = AnimationUtils.loadAnimation(this,R.anim.alpha_0to1);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                anim2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha_1to0);
                splash_textView.setAnimation(anim2);

                anim2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                    splashScreen.setVisibility(View.GONE);
                    home_layout.setVisibility(View.VISIBLE);

                    anim3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha_0to1_home);
                    home_layout.setAnimation(anim3);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        splash_textView.setAnimation(anim);
    }

     */
    public void onClick(View v)
    {
        switch (v.getId())
        {

            case R.id.con_alarmSound:
                frame_add_setting.removeAllViews();
                LayoutInflater.from(getApplicationContext()).inflate(R.layout.alarm_sound_lyt, frame_add_setting, true);
                showBackFrame();
                break;


            case R.id.con_dismissby:

                frame_add_setting.removeAllViews();

                LayoutInflater.from(getApplicationContext()).inflate(R.layout.dismiss_lyt, frame_add_setting, true);
                showBackFrame();

                break;

            case R.id.con_label:
                frame_add_setting.removeAllViews();

                LayoutInflater.from(getApplicationContext()).inflate(R.layout.label_lyt, frame_add_setting, true);
                showBackFrame();
                break;

            case R.id.con_snooze:

                frame_add_setting.removeAllViews();
                LayoutInflater.from(getApplicationContext()).inflate(R.layout.snooze_lyt, frame_add_setting, true);
                showBackFrame();
                break;
            case R.id.con_repeat:
                frame_add_setting.removeAllViews();

                final LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view = inflater.inflate(R.layout.days_lyt, null);

                LinearLayout lnr = (LinearLayout) view.findViewById(R.id.lnr_days);

                Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_edit_view);


                LayoutInflater.from(getApplicationContext()).inflate(R.layout.days_lyt, frame_add_setting, true);

                lnr.startAnimation(animation);
                showBackFrame();

                break;
        }
    }
    private void showBackFrame()
    {
        con_backToAdd.setVisibility(View.VISIBLE);
        frm_save.setVisibility(View.GONE);
    }
    private void showSaveFrame()
    {
        con_backToAdd.setVisibility(View.GONE);
        frm_save.setVisibility(View.VISIBLE);
    }

    @Override
    public void setReferences(FrameLayout frameLayout, ConstraintLayout constraintLayout,FrameLayout frameLayout2) {
        con_backToAdd = constraintLayout;
        frm_save = frameLayout;
        frame_add_setting =  frameLayout2;
    }
}
