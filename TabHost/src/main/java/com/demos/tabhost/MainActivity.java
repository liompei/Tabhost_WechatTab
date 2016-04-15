package com.demos.tabhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private RelativeLayout mRlTab1,mRlTab2,mRlTab3,mRlTab4;
    private ImageView mIvTab1,mIvTab2,mIvTab3,mIvTab4;
    private TextView mTvTab1,mTvTab2,mTvTab3,mTvTab4;

    private FragmentManager manager;
    private Fragment IndexFragment,MagFragment,NewsFragment,MeFragment;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        initView();
        initEvent();

        setTabSelect(0);
	}

    private void initView(){
        mRlTab1=(RelativeLayout)findViewById(R.id.rl_tab1);
        mRlTab2=(RelativeLayout)findViewById(R.id.rl_tab2);
        mRlTab3=(RelativeLayout)findViewById(R.id.rl_tab3);
        mRlTab4=(RelativeLayout)findViewById(R.id.rl_tab4);

        mTvTab1=(TextView)findViewById(R.id.tv_tab1);
        mTvTab2=(TextView)findViewById(R.id.tv_tab2);
        mTvTab3=(TextView)findViewById(R.id.tv_tab3);
        mTvTab4=(TextView)findViewById(R.id.tv_tab4);

        mIvTab1=(ImageView)findViewById(R.id.iv_tab1);
        mIvTab2=(ImageView)findViewById(R.id.iv_tab2);
        mIvTab3=(ImageView)findViewById(R.id.iv_tab3);
        mIvTab4=(ImageView)findViewById(R.id.iv_tab4);

    }

    private void initEvent(){
        mRlTab1.setOnClickListener(this);
        mRlTab2.setOnClickListener(this);
        mRlTab3.setOnClickListener(this);
        mRlTab4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_tab1:
                setTabSelect(0);
                break;
            case R.id.rl_tab2:
                setTabSelect(1);

                break;
            case R.id.rl_tab3:
                setTabSelect(2);

                break;
            case R.id.rl_tab4:
                setTabSelect(3);
                break;
            default:
                break;
        }
    }


    public void setTabSelect(int i) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

        resetTab();
        switch (i) {
            case 0:
                IndexFragment=manager.findFragmentByTag("TAG1");
                hideTab(transaction);
                if (IndexFragment == null){
                    IndexFragment = new IndexTabFragment();
                    transaction.add(R.id.content, IndexFragment,"TAG1");
                } else{
                    transaction.show(IndexFragment);
                }
                Log.i("MainActivity","IndexFragment:"+IndexFragment.toString());
                mIvTab1.setImageResource(R.drawable.index_s);
                mTvTab1.setTextColor(getResources().getColor(R.color.tab_text_press));
                mRlTab1.setBackgroundColor(getResources().getColor(R.color.tab_select_back));
                break;
            case 1:
                MagFragment=manager.findFragmentByTag("TAG2");
                hideTab(transaction);
                if (MagFragment == null){
                    MagFragment = new MagTabFragment();
                    transaction.add(R.id.content, MagFragment,"TAG2");
                } else{
                    transaction.show(MagFragment);
                }
                Log.i("MainActivity","MagFragment:"+MagFragment.toString());
                mIvTab2.setImageResource(R.drawable.magzine_s);
                mTvTab2.setTextColor(getResources().getColor(R.color.tab_text_press));
                mRlTab2.setBackgroundColor(getResources().getColor(R.color.tab_select_back));
                break;
            case 2:
                NewsFragment=manager.findFragmentByTag("TAG3");
                hideTab(transaction);
                if (NewsFragment == null){
                    NewsFragment = new NewsTabFragment();
                    transaction.add(R.id.content, NewsFragment,"TAG3");
                } else{
                    transaction.show(NewsFragment);
                }
                Log.i("MainActivity","NewsFragment:"+NewsFragment.toString());
                mIvTab3.setImageResource(R.drawable.picture_s);
                mTvTab3.setTextColor(getResources().getColor(R.color.tab_text_press));
                mRlTab3.setBackgroundColor(getResources().getColor(R.color.tab_select_back));
                break;
            case 3:
                MeFragment=manager.findFragmentByTag("TAG4");
                hideTab(transaction);
                if (MeFragment == null){
                    MeFragment = new MeTabFragment();
                    transaction.add(R.id.content, MeFragment,"TAG4");
                } else{
                    transaction.show(MeFragment);
                }
                Log.i("MainActivity","MeFragment:"+MeFragment.toString());
                mIvTab4.setImageResource(R.drawable.me_s);
                mTvTab4.setTextColor(getResources().getColor(R.color.tab_text_press));
                mRlTab4.setBackgroundColor(getResources().getColor(R.color.tab_select_back));
                break;
            default:

                break;
        }
        transaction.commit();

    }

    private void resetTab(){
        mRlTab1.setBackgroundColor(getResources().getColor(R.color.tab_back));
        mRlTab2.setBackgroundColor(getResources().getColor(R.color.tab_back));
        mRlTab3.setBackgroundColor(getResources().getColor(R.color.tab_back));
        mRlTab4.setBackgroundColor(getResources().getColor(R.color.tab_back));

        mIvTab1.setImageResource(R.drawable.index);
        mIvTab2.setImageResource(R.drawable.magzine);
        mIvTab3.setImageResource(R.drawable.picture);
        mIvTab4.setImageResource(R.drawable.me);

        mTvTab1.setTextColor(getResources().getColor(R.color.tab_text));
        mTvTab2.setTextColor(getResources().getColor(R.color.tab_text));
        mTvTab3.setTextColor(getResources().getColor(R.color.tab_text));
        mTvTab4.setTextColor(getResources().getColor(R.color.tab_text));
    }

    private void hideTab(FragmentTransaction transaction){
        if (IndexFragment != null)
        {
            transaction.hide(IndexFragment);
        }
        if (MagFragment != null)
        {
            transaction.hide(MagFragment);
        }
        if (NewsFragment != null)
        {
            transaction.hide(NewsFragment);
        }
        if (MeFragment != null)
        {
            transaction.hide(MeFragment);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
