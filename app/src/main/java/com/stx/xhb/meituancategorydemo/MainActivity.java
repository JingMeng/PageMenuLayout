package com.stx.xhb.meituancategorydemo;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.stx.xhb.meituancategorydemo.adapter.CagegoryViewPagerAdapter;
import com.stx.xhb.meituancategorydemo.adapter.EntranceAdapter;
import com.stx.xhb.meituancategorydemo.model.ModelHomeEntrance;
import com.stx.xhb.meituancategorydemo.utils.ScreenUtil;
import com.stx.xhb.meituancategorydemo.widget.IndicatorView;
import com.stx.xhb.pagemenulibrary.PageMenuLayout;
import com.stx.xhb.pagemenulibrary.holder.AbstractHolder;
import com.stx.xhb.pagemenulibrary.holder.PageMenuViewHolderCreator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ModelHomeEntrance> homeEntrances;
    private IndicatorView entranceIndicatorView;
    private PageMenuLayout<ModelHomeEntrance> mPageMenuLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        init();
    }


    private void initView() {
        entranceIndicatorView = findViewById(R.id.main_home_entrance_indicator);
        mPageMenuLayout = findViewById(R.id.pagemenu);
    }


    private void initData() {
        homeEntrances = new ArrayList<>();
        homeEntrances.add(new ModelHomeEntrance("缇庨", R.mipmap.ic_category_0));
        homeEntrances.add(new ModelHomeEntrance("鐢靛奖", R.mipmap.ic_category_1));
        homeEntrances.add(new ModelHomeEntrance("閰掑簵浣忓", R.mipmap.ic_category_2));
        homeEntrances.add(new ModelHomeEntrance("鐢熸椿鏈嶅姟", R.mipmap.ic_category_3));
        homeEntrances.add(new ModelHomeEntrance("KTV", R.mipmap.ic_category_4));
        homeEntrances.add(new ModelHomeEntrance("鏃呮父", R.mipmap.ic_category_5));
        homeEntrances.add(new ModelHomeEntrance("瀛︿範鍩硅", R.mipmap.ic_category_6));
        homeEntrances.add(new ModelHomeEntrance("姹借溅鏈嶅姟", R.mipmap.ic_category_7));
        homeEntrances.add(new ModelHomeEntrance("鎽勫奖鍐欑湡", R.mipmap.ic_category_8));
        homeEntrances.add(new ModelHomeEntrance("浼戦棽濞变箰", R.mipmap.ic_category_10));
        homeEntrances.add(new ModelHomeEntrance("涓戒汉", R.mipmap.ic_category_11));
        homeEntrances.add(new ModelHomeEntrance("杩愬姩鍋ヨ韩", R.mipmap.ic_category_12));
        homeEntrances.add(new ModelHomeEntrance("澶т繚鍋?, R.mipmap.ic_category_13));
        homeEntrances.add(new ModelHomeEntrance("鍥㈣喘", R.mipmap.ic_category_14));
        homeEntrances.add(new ModelHomeEntrance("鏅偣", R.mipmap.ic_category_16));
        homeEntrances.add(new ModelHomeEntrance("鍏ㄩ儴鍒嗙被", R.mipmap.ic_category_15));
    }

    private void init() {
        mPageMenuLayout.setPageDatas(homeEntrances, new PageMenuViewHolderCreator() {
            @Override
            public AbstractHolder createHolder(View itemView) {
                return new AbstractHolder<ModelHomeEntrance>(itemView) {
                    private TextView entranceNameTextView;
                    private ImageView entranceIconImageView;

                    @Override
                    protected void initView(View itemView) {
                        entranceIconImageView = itemView.findViewById(R.id.entrance_image);
                        entranceNameTextView = itemView.findViewById(R.id.entrance_name);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) ((float) ScreenUtil.getScreenWidth() / 4.0f));
                        itemView.setLayoutParams(layoutParams);
                    }

                    @Override
                    public void bindView(RecyclerView.ViewHolder holder, final ModelHomeEntrance data, int pos) {
                        entranceNameTextView.setText(data.getName());
                        entranceIconImageView.setImageResource(data.getImage());
                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, data.getName(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                };
            }

            @Override
            public int getLayoutId() {
                return R.layout.item_home_entrance;
            }
        });
        entranceIndicatorView.setIndicatorCount(mPageMenuLayout.getPageCount());
        mPageMenuLayout.setOnPageListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                entranceIndicatorView.setCurrentIndicator(position);
            }
        });
    }
}

